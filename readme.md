JDot
====

Java library that provides wrapper for Graphviz. Generates DOT and uses Graphviz to generate graphs.

Dependencies
============

- Requires the dot executable.

By default, is located in /usr/local/bin. Use Graph.setDefaultCmd to change it.

- Requires a browser to display graphs.

By default, the command to open the file on the browser is "open -a 'Google Chrome.app'". Use Graph.setDefaultBrowserCmd to change it.

Usage
=====

- mvn clean install

This will build the library.

There are samples that are equivalent to the GraphViz-provided samples in the test package. The following command
generates the graph for the abstract.gv sample and displays it in the browser.

- java -cp target/test-classes/.:target/jdot-1.0.0.jar info.leadinglight.jdot.samples.Abstract

Look in the test package info.leadinglight.jdot.samples package for a complete list of samples.

License
=======

Copyright 2013 Gerald Boersma <gerald.boersma@gmail.com>

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the 'Software'), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 