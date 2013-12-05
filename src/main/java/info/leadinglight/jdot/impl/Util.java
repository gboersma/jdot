/**
    Copyright 2013 Gerald Boersma <gerald dot boersma at gmail dot com>

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 */
package info.leadinglight.jdot.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

/**
 * Various utility functions based on JDK only.
 */
public class Util {

    /**
     * Concatenate the strings in the list with the , separator.
     * @param l List of strings to concatenate.
     * @return The concatenated string.
     */
    public static String join(List<String> l) {
        return join(l, ", ");
    }

    public static String join(List<String> l, String sep) {
        int k = l.size();
        if (k == 0) {
            return null;
        }
        StringBuilder out = new StringBuilder();
        out.append(l.get(0));
        for (int x = 1; x < k; ++x) {
            out.append(sep).append(l.get(x));
        }
        return out.toString();
    }

    public static String[] append(String[] array, String item) {
        final int N = array.length;
        array = Arrays.copyOf(array, N + 1);
        array[N] = item;
        return array;
    }

    public static String toTempFile(String content) {
        try {
            return toFile(content, File.createTempFile("jdot", ".out"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toFile(String content, File file) {
        try {
            FileWriter w = new FileWriter(file);
            w.write(content);
            w.flush();
            w.close();
            return file.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String fromFile(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append("\n");
                    line = br.readLine();
                }
                return sb.toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                br.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String sh(String cmd) {
        return sh(cmd, null);
    }

    public static String sh(String cmd, String input) {
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            Reader in;
            if (input != null) {
                in = new StringReader(input);
            } else {
                in = new StringReader("");
            }
            Writer out = new StringWriter();
            Writer err = new StringWriter();
            communicate(p, in, out, err);
            return out.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String sh(String[] cmds) {
        return sh(cmds, null);
    }

    public static String sh(String[] cmds, String input) {
        try {
            Process p = Runtime.getRuntime().exec(cmds);
            Reader in;
            if (input != null) {
                in = new StringReader(input);
            } else {
                in = new StringReader("");
            }
            Writer out = new StringWriter();
            Writer err = new StringWriter();
            communicate(p, in, out, err);
            return out.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Handle communication with a process, reading its output/error and feeding
     * its input
     *
     * @param process The process to execute
     * @param _in Reader that will feed the input pipe of the process
     * @param out Writer that will receive the output of the process
     * @param err Writer that will receive the error pipe of the process
     */
    private static void communicate(
            Process process,
            final Reader _in,
            final Writer out,
            final Writer err) {
        // Buffer the input reader
        final BufferedReader in = new BufferedReader(_in);

        // Final versions of the the params, to be used within the threads
        final BufferedReader stdOut = new BufferedReader(new InputStreamReader(process.getInputStream()));
        final BufferedReader stdErr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        final BufferedWriter stdIn = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

        // Thread that reads std out and feeds the writer given in input
        Thread t1 = new Thread() {
            @Override
            public void run() {
                String line;
                try {
                    while ((line = stdOut.readLine()) != null) {
                        out.write(line + "\n");
                    }
                } catch (IOException e) {
                    throw new Error(e);
                }
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) { /* Who cares ?*/ }
            }
        };
        t1.start(); // Starts now

        // Thread that reads std err and feeds the writer given in input
        Thread t2 = new Thread() {
            @Override
            public void run() {
                String line;
                try {
                    while ((line = stdErr.readLine()) != null) {
                        err.write(line + "\n");
                    }
                } catch (IOException e) {
                    throw new Error(e);
                }
                try {
                    err.flush();
                    err.close();
                } catch (IOException e) { /* Who cares ?*/ }
            }
        };
        t2.start(); // Starts now

        // Thread that reads the std in given in input and that feeds the input of the process
        Thread t3 = new Thread() {
            @Override
            public void run() {
                String line;
                try {
                    while ((line = in.readLine()) != null) {
                        stdIn.write(line + "\n");
                    }
                } catch (IOException e) {
                    throw new Error(e);
                }

                try {
                    stdIn.flush();
                    stdIn.close();
                } catch (IOException e) { /* Who cares ?*/ }
            }
        };
        t3.start(); // Starts now

        // Wait until the end of the process
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            throw new Error(e);
        }

        // Need to wait until all the threads finish up...
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            // Do nothing...
        }
    } // End of #communicate	
}
