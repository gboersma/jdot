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

public class Switch {

    public static void main(String[] args) {
        g().viewSvg();
    }

    public static Graph g() {
        Graph g = new Graph("G").setCenter(true).setRankDir(Rankdir.LR).setBgColor("#808080");
        g.addEdge(new Edge().setDir(Dir.none));
        g.addNode(new Node().setWidth(0.3).setHeight(0.3).setLabel(""));
        g.addSubGraph(new SubGraph().addNodes(
                new Node().setShape(Shape.circle).setStyle(Style.Node.invis),
                new Node("1"), new Node("2"), new Node("3"), new Node("4"), new Node("5"), new Node("6"), new Node("7"), new Node("8"),
                new Node("10"), new Node("20"), new Node("30"), new Node("40"), new Node("50"), new Node("60"), new Node("70"), new Node("80")));
        g.addSubGraph(new SubGraph().addNodes(
                new Node().setShape(Shape.circle),
                new Node("a"), new Node("b"), new Node("c"), new Node("d"), new Node("e"), new Node("f"), new Node("g"), new Node("h"),
                new Node("i"), new Node("j"), new Node("k"), new Node("l"), new Node("m"), new Node("n"), new Node("o"), new Node("p"),
                new Node("q"), new Node("r"), new Node("s"), new Node("t"), new Node("u"), new Node("v"), new Node("w"), new Node("x")));
        g.addSubGraph(new SubGraph().addNodes(
                new Node().setShape(Shape.diamond),
                new Node("A"), new Node("B"), new Node("C"), new Node("D"), new Node("E"), new Node("F"), new Node("G"), new Node("H"),
                new Node("I"), new Node("J"), new Node("K"), new Node("L"), new Node("M"), new Node("N"), new Node("O"), new Node("P"),
                new Node("Q"), new Node("R"), new Node("S"), new Node("T"), new Node("U"), new Node("V"), new Node("W"), new Node("X")));
        g.addSubGraph(new SubGraph().addEdges(
                new Edge("1", "a").addNodes("A", "B").setColor("#0000ff"),
                new Edge("2", "b").addNodes("B", "A").setColor("#ff0000"),
                new Edge("3", "c").addNodes("C", "D").setColor("#ffff00"),
                new Edge("4", "d").addNodes("D", "C").setColor("#00ff00"),
                new Edge("5", "e").addNodes("E", "F").setColor("#000000"),
                new Edge("6", "f").addNodes("F", "E").setColor("#00ffff"),
                new Edge("7", "g").addNodes("G", "H").setColor("#ffffff"),
                new Edge("8", "h").addNodes("H", "G").setColor("#ff00ff")));
        g.addSubGraph(new SubGraph().addEdges(
                new Edge().setColor("#ff0000:#0000ff"),
                new Edge("A", "i").addNodes("I", "K"),
                new Edge("B", "j").addNodes("J", "L")));
        g.addSubGraph(new SubGraph().addEdges(
                new Edge().setColor("#00ff00:#ffff00"),
                new Edge("C", "k").addNodes("K", "I"),
                new Edge("D", "l").addNodes("L", "J")));
        g.addSubGraph(new SubGraph().addEdges(
                new Edge().setColor("#00ffff:#000000"),
                new Edge("E", "m").addNodes("M", "O"),
                new Edge("F", "n").addNodes("N", "P")));
        g.addSubGraph(new SubGraph().addEdges(
                new Edge().setColor("#ff00ff:#ffffff"),
                new Edge("G", "o").addNodes("O", "M"),
                new Edge("H", "p").addNodes("P", "N")));
        g.addSubGraph(new SubGraph().addEdges(
                new Edge().setColor("#00ff00:#ffff00:#ff0000:#0000ff"),
                new Edge("I", "q").addNodes("Q", "U"),
                new Edge("J", "r").addNodes("R", "V"),
                new Edge("K", "s").addNodes("S", "W"),
                new Edge("L", "t").addNodes("T", "X")));
        g.addSubGraph(new SubGraph().addEdges(
                new Edge().setColor("#ff00ff:#ffffff:#00ffff:#000000"),
                new Edge("M", "u").addNodes("U", "Q"),
                new Edge("N", "v").addNodes("V", "R"),
                new Edge("O", "w").addNodes("W", "S"),
                new Edge("P", "x").addNodes("X", "T")));
        g.addSubGraph(new SubGraph().addEdges(
                new Edge().setColor("#ff00ff:#ffffff:#00ffff:#000000:#00ff00:#ffff00:#ff0000:#0000ff"),
                new Edge("Q", "10"),
                new Edge("R", "20"),
                new Edge("S", "30"),
                new Edge("T", "40"),
                new Edge("U", "50"),
                new Edge("V", "60"),
                new Edge("W", "70"),
                new Edge("X", "80")));
        return g;
    }
}
