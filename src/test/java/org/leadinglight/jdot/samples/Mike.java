package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;

public class Mike {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("mike").setSize("8,8");
		g.addEdges(new Edge(g, "a", "A"), new Edge(g, "a", "m"), new Edge(g,
				"a", "E"), new Edge(g, "t", "O"), new Edge(g, "r", "V"),
				new Edge(g, "r", "Q"), new Edge(g, "p", "B"), new Edge(g, "m",
						"R"), new Edge(g, "l", "C"), new Edge(g, "c", "C"),
				new Edge(g, "W", "X"), new Edge(g, "W", "D"), new Edge(g, "V",
						"W"), new Edge(g, "T", "U"), new Edge(g, "Q", "T"),
				new Edge(g, "Q", "H"), new Edge(g, "Q", "A"), new Edge(g, "O",
						"K"), new Edge(g, "L", "U"), new Edge(g, "K", "L"),
				new Edge(g, "K", "J"), new Edge(g, "K", "E"), new Edge(g, "J",
						"I"), new Edge(g, "R", "B"), new Edge(g, "P", "F"),
				new Edge(g, "H", "R"), new Edge(g, "H", "P"), new Edge(g, "U",
						"H"), new Edge(g, "G", "U"), new Edge(g, "E", "G"),
				new Edge(g, "C", "Z"), new Edge(g, "C", "D"), new Edge(g, "S",
						"D"), new Edge(g, "B", "N"), new Edge(g, "B", "D"),
				new Edge(g, "B", "S"), new Edge(g, "M", "B"), new Edge(g, "A",
						"M"), new Edge(g, "N", "Y"));
		return g;
	}
}
