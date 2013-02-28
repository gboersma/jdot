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
