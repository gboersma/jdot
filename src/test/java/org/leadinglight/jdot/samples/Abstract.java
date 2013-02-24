package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;

public class Abstract {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("abstract").setSize("6,6");
		g.addEdges(new Edge(g, "S24", "27"), new Edge(g, "S24", "25"),
				new Edge(g, "S1", "10"), new Edge(g, "S1", "2"), new Edge(g,
						"S35", "36"), new Edge(g, "S35", "43"), new Edge(g,
						"S30", "31"), new Edge(g, "S30", "33"), new Edge(g,
						"9", "42"), new Edge(g, "9", "T1"), new Edge(g, "25",
						"T1"), new Edge(g, "25", "26"),
				new Edge(g, "27", "T24"), new Edge(g, "2", "3"), new Edge(g,
						"2", "16"), new Edge(g, "2", "17"), new Edge(g, "2",
						"T1"), new Edge(g, "2", "18"), new Edge(g, "10", "11"),
				new Edge(g, "10", "14"), new Edge(g, "10", "T1"), new Edge(g,
						"10", "13"), new Edge(g, "10", "12"), new Edge(g, "31",
						"T1"), new Edge(g, "31", "32"),
				new Edge(g, "33", "T30"), new Edge(g, "33", "34"), new Edge(g,
						"42", "4"), new Edge(g, "26", "4"), new Edge(g, "3",
						"4"), new Edge(g, "16", "15"), new Edge(g, "17", "19"),
				new Edge(g, "18", "29"), new Edge(g, "11", "4"), new Edge(g,
						"14", "15"), new Edge(g, "37", "39"), new Edge(g, "37",
						"41"), new Edge(g, "37", "38"),
				new Edge(g, "37", "40"), new Edge(g, "13", "19"), new Edge(g,
						"12", "29"), new Edge(g, "43", "38"), new Edge(g, "43",
						"40"), new Edge(g, "36", "19"),
				new Edge(g, "32", "23"), new Edge(g, "34", "29"), new Edge(g,
						"39", "15"), new Edge(g, "41", "29"), new Edge(g, "38",
						"4"), new Edge(g, "40", "19"), new Edge(g, "4", "5"),
				new Edge(g, "19", "21"), new Edge(g, "19", "20"), new Edge(g,
						"19", "28"), new Edge(g, "5", "6"), new Edge(g, "5",
						"T35"), new Edge(g, "5", "23"),
				new Edge(g, "21", "22"), new Edge(g, "20", "15"), new Edge(g,
						"28", "29"), new Edge(g, "6", "7"), new Edge(g, "15",
						"T1"), new Edge(g, "22", "23"),
				new Edge(g, "22", "T35"), new Edge(g, "29", "T30"), new Edge(g,
						"7", "T8"), new Edge(g, "23", "T24"), new Edge(g, "23",
						"T1"));
		return g;
	}
}
