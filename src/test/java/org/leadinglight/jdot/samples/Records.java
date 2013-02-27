package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.*;
import org.leadinglight.jdot.enums.*;

public class Records {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
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
