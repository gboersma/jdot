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
import info.leadinglight.jdot.enums.*;

public class Records {

    public static void main(String[] args) {
        g().viewSvg();
    }

    public static Graph g() {
        Graph g = new Graph("G").setRankDir(Rankdir.LR);
        g.addNodes(
                new Node().setShape(Shape.record),
                new Node("a").setLabel("<bala> Graphs can\\lbe fun\\l|<f1> mid|<f2> right\\r"),
                new Node("b").setLabel("<left>   |<mid> b |   "),
                new Node("c").setLabel("<p1>   | c |<p2>   "),
                new Node("x").setLabel("<p1>   | x |<p2>   "),
                new Node("y").setLabel("<p1>   | y |<p2>   "),
                new Node("z").setLabel("   | z |<p2>   "));
        g.addEdges(
                new Edge().addNode("a", "bala").addNode("b", "left"),
                new Edge().addNode("a", "f1").addNode("d"),
                new Edge().addNode("a", "f2").addNode("y", "p1"),
                new Edge().addNode("c", "p1").addNode("d"),
                new Edge().addNode("b", "mid").addNode("x", "p1"),
                new Edge().addNode("c", "p2").addNode("y", "p2"),
                new Edge().addNode("b", "left").addNode("z", "p2"));
        return g;
    }
}
