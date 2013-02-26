package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;
import org.leadinglight.jdot.Node;
import org.leadinglight.jdot.Node.Shape;

public class OldArrow {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("G").setRankSep(1.5).setSplines(true).setOverlap(false);
		g.addEdge(new Edge().setLabelDistance(3.0));
		g.addNode(new Node().setShape(Shape.circle).setWidth("0.5").setLabel(""));
		g.createEdgeList().addEdges(
				new Edge().setDir(Edge.Dir.back).setSameHead("ahead"),
				new Edge(g, "a", "Z").setArrowTail(Edge.ArrowType.none).setTailLabel("none"),
				new Edge(g, "b", "Z").setArrowTail(Edge.ArrowType.normal).setTailLabel("normal"),
				new Edge(g, "c", "Z").setArrowTail(Edge.ArrowType.inv).setTailLabel("inv"),
				new Edge(g, "d", "Z").setArrowTail(Edge.ArrowType.dot).setTailLabel("dot"),
				new Edge(g, "e", "Z").setArrowTail(Edge.ArrowType.odot).setTailLabel("odot"),
				new Edge(g, "f", "Z").setArrowTail(Edge.ArrowType.invdot).setTailLabel("invdot"),
				new Edge(g, "g", "Z").setArrowTail(Edge.ArrowType.invodot).setTailLabel("invodot"),
				new Edge(g, "h", "Z").setArrowTail(Edge.ArrowType.open).setTailLabel("open"),
				new Edge(g, "i", "Z").setArrowTail(Edge.ArrowType.halfopen).setTailLabel("halfopen").setArrowHead(Edge.ArrowType.inv).setHeadLabel("samehead"),
				new Edge(g, "j", "Z").setArrowTail(Edge.ArrowType.empty).setTailLabel("empty"),
				new Edge(g, "k", "Z").setArrowTail(Edge.ArrowType.invempty).setTailLabel("invempty"),
				new Edge(g, "l", "Z").setArrowTail(Edge.ArrowType.diamond).setTailLabel("diamond"),
				new Edge(g, "m", "Z").setArrowTail(Edge.ArrowType.odiamond).setTailLabel("odiamond"),
				new Edge(g, "n", "Z").setArrowTail(Edge.ArrowType.box).setTailLabel("box"),
				new Edge(g, "o", "Z").setArrowTail(Edge.ArrowType.obox).setTailLabel("obox"),
				new Edge(g, "p", "Z").setArrowTail(Edge.ArrowType.tee).setTailLabel("tee"),
				new Edge(g, "q", "Z").setArrowTail(Edge.ArrowType.crow).setTailLabel("crow"));
		g.createEdgeList().addEdges(
				new Edge().setSameTail("atail"),
				new Edge(g, "Z", "A").setArrowHead(Edge.ArrowType.none).setHeadLabel("none"),
				new Edge(g, "Z", "B").setArrowHead(Edge.ArrowType.normal).setHeadLabel("normal"),
				new Edge(g, "Z", "C").setArrowHead(Edge.ArrowType.inv).setHeadLabel("inv"),
				new Edge(g, "Z", "D").setArrowHead(Edge.ArrowType.dot).setHeadLabel("dot"),
				new Edge(g, "Z", "E").setArrowHead(Edge.ArrowType.odot).setHeadLabel("odot"),
				new Edge(g, "Z", "F").setArrowHead(Edge.ArrowType.invdot).setHeadLabel("invdot"),
				new Edge(g, "Z", "G").setArrowHead(Edge.ArrowType.invodot).setHeadLabel("invodot"),
				new Edge(g, "Z", "H").setArrowHead(Edge.ArrowType.open).setHeadLabel("open"),
				new Edge(g, "Z", "I").setArrowHead(Edge.ArrowType.halfopen).setHeadLabel("halfopen").setArrowTail(Edge.ArrowType.inv).setTailLabel("sametail"),
				new Edge(g, "Z", "J").setArrowHead(Edge.ArrowType.empty).setHeadLabel("empty"),
				new Edge(g, "Z", "K").setArrowHead(Edge.ArrowType.invempty).setHeadLabel("invempty"),
				new Edge(g, "Z", "L").setArrowHead(Edge.ArrowType.diamond).setHeadLabel("diamond"),
				new Edge(g, "Z", "M").setArrowHead(Edge.ArrowType.odiamond).setHeadLabel("odiamond"),
				new Edge(g, "Z", "N").setArrowHead(Edge.ArrowType.box).setHeadLabel("box"),
				new Edge(g, "Z", "O").setArrowHead(Edge.ArrowType.obox).setHeadLabel("obox"),
				new Edge(g, "Z", "P").setArrowHead(Edge.ArrowType.tee).setHeadLabel("tee"),
				new Edge(g, "Z", "Q").setArrowHead(Edge.ArrowType.crow).setHeadLabel("crow"));
		return g;
	}
}
