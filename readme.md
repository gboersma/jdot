JDot
====

Java library that provides wrapper for Graphviz. Generates DOT and uses Graphviz to generate graphs.

Usage
=====

Construct a Graph or ClusterGraph and add Nodes and Edges to it.

JDot uses Java enumerated types where possible for setting attributes, in order to self-document
the API. Use syntax completion in your IDE to quickly see the valid options for many of the 
attributes.

JDot uses the builder pattern to easily construct graphs, especially for setting attributes on graphs, nodes, and edges.

Here is sample code for building a graph: 

    :::java
        Graph g = new Graph("structs");
        g.addNodes(
                new Node().setShape(Shape.record),
                new Node("struct1").setShape(Shape.record).setLabel("<f0> left|<f1> middle|<f2> right"),
                new Node("struct2").setShape(Shape.record).setLabel("<f0> one|<f1> two"),
                new Node("struct3").setShape(Shape.record).setLabel("hello\nworld |{ b |{c|<here> d|e}| f}| g | h"));
        g.addEdges(
                new Edge().addNode("struct1", "f1").addNode("struct2", "f0"),
                new Edge().addNode("struct1", "f2").addNode("struct3", "here"));
        return g;

Look in the test package info.leadinglight.jdot.samples package for a complete list of samples.

Dependencies
============

Requires the dot executable. By default, is located in /usr/local/bin. Use Graph.setDefaultCmd to change it.

Note: For Mac OS X, homebrew has a recipe for Graphviz that puts the executable here.

Not required, but supports viewing graphs in a browser. By default, the command to open the file on the browser is "open -a 'Google Chrome.app'". Use Graph.setDefaultBrowserCmd to change it.

Building from Source
====================

- mvn clean install

This will build the library, and execute the unit tests. These generate sample graphs that are equivalent
to the Graphviz provided samples, and compares the resulting SVG to what the Graphviz samples generate.

Use the following command to generate the samples and display them in the browser (e.g. the graph for the abstract.gv sample):

- java -cp target/test-classes/.:target/jdot-1.0.0.jar info.leadinglight.jdot.samples.Abstract

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
FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 