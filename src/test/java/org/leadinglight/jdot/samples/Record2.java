package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;
import org.leadinglight.jdot.Node;
import org.leadinglight.jdot.Node.Shape;

public class Record2 {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("G").addNode(new Node().setShape(Shape.record));
		g.addNodes(
				new Node("a").setLabel("<f0> foo | x | <f1> bar"),
				new Node("b").setLabel("a | { <f0> foo | x | <f1> bar } | b"));
		g.addEdge(
				new Edge().addNode(g, "a", "f0").addNode(g, "b", "f1"));
		return g;
	}
}
