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

public class Record2 {

    public static void main(String[] args) {
        g().viewSvg();
    }

    public static Graph g() {
        Graph g = new Graph("G").addNode(new Node().setShape(Shape.record));
        g.addNodes(
                new Node("a").setLabel("<f0> foo | x | <f1> bar"),
                new Node("b").setLabel("a | { <f0> foo | x | <f1> bar } | b"));
        g.addEdge(
                new Edge().addNode("a", "f0").addNode("b", "f1"));
        return g;
    }
}
