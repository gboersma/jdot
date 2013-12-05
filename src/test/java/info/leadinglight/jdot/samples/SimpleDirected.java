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
package info.leadinglight.jdot.samples;

import info.leadinglight.jdot.*;

public class SimpleDirected {

    public static void main(String[] args) {
        g().viewSvg();
    }

    public static Graph g() {
        Graph g = new Graph();
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Edge e1 = new Edge("1", "2");
        Edge e2 = new Edge("1", "3");
        Edge e3 = new Edge("2", "3");
        g.addNodes(n1, n2, n3).addEdges(e1, e2, e3);
        return g;
    }
}
