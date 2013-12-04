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

import info.leadinglight.jdot.Edge;
import info.leadinglight.jdot.Graph;

public class Mike {

    public static void main(String[] args) {
        g().viewSvg();
    }

    public static Graph g() {
        Graph g = new Graph("mike").setSize("8,8");
        g.addEdges(new Edge("a", "A"), new Edge("a", "m"), new Edge(
                "a", "E"), new Edge("t", "O"), new Edge("r", "V"),
                new Edge("r", "Q"), new Edge("p", "B"), new Edge("m",
                        "R"), new Edge("l", "C"), new Edge("c", "C"),
                new Edge("W", "X"), new Edge("W", "D"), new Edge("V",
                        "W"), new Edge("T", "U"), new Edge("Q", "T"),
                new Edge("Q", "H"), new Edge("Q", "A"), new Edge("O",
                        "K"), new Edge("L", "U"), new Edge("K", "L"),
                new Edge("K", "J"), new Edge("K", "E"), new Edge("J",
                        "I"), new Edge("R", "B"), new Edge("P", "F"),
                new Edge("H", "R"), new Edge("H", "P"), new Edge("U",
                        "H"), new Edge("G", "U"), new Edge("E", "G"),
                new Edge("C", "Z"), new Edge("C", "D"), new Edge("S",
                        "D"), new Edge("B", "N"), new Edge("B", "D"),
                new Edge("B", "S"), new Edge("M", "B"), new Edge("A",
                        "M"), new Edge("N", "Y"));
        return g;
    }
}
