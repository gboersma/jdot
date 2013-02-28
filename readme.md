JDot
====

Java library that provides wrapper for Graphviz. Generates DOT and uses Graphviz to generate graphs.

Dependencies
============

- Assumes that dot executable is located in /usr/local/bin. 

If you need to change this, you will need to specify the command in the sample code.

- Assumes that browser is invoked with "open -a 'Google Chrome.app'".

If you need to change this, you will need to specify the browser command in the sample code.  

Usage
=====

- mvn clean install

This will build the library.

- java -cp target/jdot-0.0.1-SNAPSHOT.jar info.leadinglight.jdot.samples.Abstract

Generate the graph for the abstract.gv sample (same as in Graphviz distro), and display it in the browser.
Look in the info.leadinglight.jdot.samples package for a complete list of samples.

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
 