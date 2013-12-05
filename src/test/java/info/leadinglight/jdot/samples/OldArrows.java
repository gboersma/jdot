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

public class OldArrows {

    public static void main(String[] args) {
        g().viewSvg();
    }

    public static Graph g() {
        Graph g = new Graph("G").setRankSep(1.5).setSplines(true).setOverlap(false);
        g.addEdge(new Edge().setLabelDistance(3.0));
        g.addNode(new Node().setShape(Shape.circle).setWidth(0.5).setLabel(""));
        g.addSubGraph(new SubGraph().addEdges(
                new Edge().setDir(Dir.back).setSameHead("ahead"),
                new Edge("a", "Z").setArrowTail(ArrowType.none).setTailLabel("none"),
                new Edge("b", "Z").setArrowTail(ArrowType.normal).setTailLabel("normal"),
                new Edge("c", "Z").setArrowTail(ArrowType.inv).setTailLabel("inv"),
                new Edge("d", "Z").setArrowTail(ArrowType.dot).setTailLabel("dot"),
                new Edge("e", "Z").setArrowTail(ArrowType.odot).setTailLabel("odot"),
                new Edge("f", "Z").setArrowTail(ArrowType.invdot).setTailLabel("invdot"),
                new Edge("g", "Z").setArrowTail(ArrowType.invodot).setTailLabel("invodot"),
                new Edge("h", "Z").setArrowTail(ArrowType.open).setTailLabel("open"),
                new Edge("i", "Z").setArrowTail(ArrowType.halfopen).setTailLabel("halfopen").setArrowHead(ArrowType.inv).setHeadLabel("samehead"),
                new Edge("j", "Z").setArrowTail(ArrowType.empty).setTailLabel("empty"),
                new Edge("k", "Z").setArrowTail(ArrowType.invempty).setTailLabel("invempty"),
                new Edge("l", "Z").setArrowTail(ArrowType.diamond).setTailLabel("diamond"),
                new Edge("m", "Z").setArrowTail(ArrowType.odiamond).setTailLabel("odiamond"),
                new Edge("n", "Z").setArrowTail(ArrowType.box).setTailLabel("box"),
                new Edge("o", "Z").setArrowTail(ArrowType.obox).setTailLabel("obox"),
                new Edge("p", "Z").setArrowTail(ArrowType.tee).setTailLabel("tee"),
                new Edge("q", "Z").setArrowTail(ArrowType.crow).setTailLabel("crow")));
        g.addSubGraph(new SubGraph().addEdges(
                new Edge().setSameTail("atail"),
                new Edge("Z", "A").setArrowHead(ArrowType.none).setHeadLabel("none"),
                new Edge("Z", "B").setArrowHead(ArrowType.normal).setHeadLabel("normal"),
                new Edge("Z", "C").setArrowHead(ArrowType.inv).setHeadLabel("inv"),
                new Edge("Z", "D").setArrowHead(ArrowType.dot).setHeadLabel("dot"),
                new Edge("Z", "E").setArrowHead(ArrowType.odot).setHeadLabel("odot"),
                new Edge("Z", "F").setArrowHead(ArrowType.invdot).setHeadLabel("invdot"),
                new Edge("Z", "G").setArrowHead(ArrowType.invodot).setHeadLabel("invodot"),
                new Edge("Z", "H").setArrowHead(ArrowType.open).setHeadLabel("open"),
                new Edge("Z", "I").setArrowHead(ArrowType.halfopen).setHeadLabel("halfopen").setArrowTail(ArrowType.inv).setTailLabel("sametail"),
                new Edge("Z", "J").setArrowHead(ArrowType.empty).setHeadLabel("empty"),
                new Edge("Z", "K").setArrowHead(ArrowType.invempty).setHeadLabel("invempty"),
                new Edge("Z", "L").setArrowHead(ArrowType.diamond).setHeadLabel("diamond"),
                new Edge("Z", "M").setArrowHead(ArrowType.odiamond).setHeadLabel("odiamond"),
                new Edge("Z", "N").setArrowHead(ArrowType.box).setHeadLabel("box"),
                new Edge("Z", "O").setArrowHead(ArrowType.obox).setHeadLabel("obox"),
                new Edge("Z", "P").setArrowHead(ArrowType.tee).setHeadLabel("tee"),
                new Edge("Z", "Q").setArrowHead(ArrowType.crow).setHeadLabel("crow")));
        return g;
    }
}
