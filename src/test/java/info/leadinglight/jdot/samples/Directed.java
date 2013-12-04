/**
    Copyright 2013 Gerald Boersma <gerald.boersma@gmail.com>

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
import info.leadinglight.jdot.enums.*;

public class Directed {

    public static void main(String[] args) {
        g().viewSvg();
    }

    public static Graph g() {
        Graph g = new Graph("sample1").setType(GraphType.digraph);
        Node n1 = new Node("1").setLabel("Node 1").setColor(Color.X11.green)
                .setShape(Shape.square);
        Node n2 = new Node("2").setLabel("Node 2").setColor(Color.X11.purple)
                .setShape(Shape.circle);
        Node n3 = new Node("3").setLabel("Node 3").setColor(Color.X11.blue)
                .setShape(Shape.triangle);
        Edge e1 = new Edge("1", "2").setColor(Color.X11.red);
        Edge e2 = new Edge("1", "3").setLabel("This is an edge.").setColor(
                Color.X11.green);
        Edge e3 = new Edge("2", "3").setColor(Color.X11.yellow);
        g.addNodes(n1, n2, n3).addEdges(e1, e2, e3);
        return g;
    }
}
