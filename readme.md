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

- Requires the dot executable. By default, is located in /usr/local/bin. Use Graph.setDefaultCmd to change it.

Note: For Mac OS X, homebrew has a recipe for Graphviz that puts the executable here.

- Not required, but JDot supports viewing graphs in a browser. By default, the command to open the file on the browser is "open -a 'Google Chrome.app'". Use Graph.setDefaultBrowserCmd to change it.

Distribution
============

Available from Maven Central. Add the following to your pom:

    :::xml
        <dependency>
            <groupId>info.leadinglight</groupId>
            <artifactId>jdot</artifactId>
            <version>1.0</version>
        </dependency>

Building from Source
====================

Use Maven:

- mvn clean install

This will build the library, and execute the unit tests. These generate sample graphs that are equivalent
to the Graphviz provided samples, and compares the resulting SVG to what the Graphviz samples generate.

Use the following command to generate the samples and display them in the browser (e.g. the graph for the abstract.gv sample):

- java -cp target/test-classes/.:target/jdot-1.0.0.jar info.leadinglight.jdot.samples.Abstract

License
=======

Copyright 2013 Gerald Boersma <gerald dot boersma at gmail dot com>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this except in compliance with the License.
You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 
