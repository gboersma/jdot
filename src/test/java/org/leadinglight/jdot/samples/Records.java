package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;
import org.leadinglight.jdot.Node;
import org.leadinglight.jdot.Node.Shape;

public class Records {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("G").setRankDir(Graph.Rankdir.LR);
		g.addNodes(
				new Node().setShape(Shape.record),
				new Node("a").setLabel("<bala> Graphs can\\lbe fun\\l|<f1> mid|<f2> right\\r"),
				new Node("b").setLabel("<left>   |<mid> b |   "),
				new Node("c").setLabel("<p1>   | c |<p2>   "),
				new Node("x").setLabel("<p1>   | x |<p2>   "),
				new Node("y").setLabel("<p1>   | y |<p2>   "),
				new Node("z").setLabel("   | z |<p2>   "));
		g.addEdges(
				new Edge().addNode(g, "a", "bala").addNode(g, "b", "left"),
				new Edge().addNode(g, "a", "f1").addNode(g, "d"),
				new Edge().addNode(g, "a", "f2").addNode(g, "y", "p1"),
				new Edge().addNode(g, "c", "p1").addNode(g, "d"),
				new Edge().addNode(g, "b", "mid").addNode(g, "x", "p1"),
				new Edge().addNode(g, "c", "p2").addNode(g, "y", "p2"),
				new Edge().addNode(g, "b", "left").addNode(g, "z", "p2"));
		return g;
	}
}
