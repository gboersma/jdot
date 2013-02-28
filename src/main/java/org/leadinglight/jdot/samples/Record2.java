package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.*;
import org.leadinglight.jdot.enums.*;

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
