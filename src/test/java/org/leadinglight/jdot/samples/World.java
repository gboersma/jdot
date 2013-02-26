package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;
import org.leadinglight.jdot.Node;
import org.leadinglight.jdot.NodeList;

public class World {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("world").setSize("7,7");
		g.getNodeList().setRank(NodeList.Rank.same).addNodes(
				new Node("S8"), new Node("S24"), new Node("S1"), new Node("S35"), new Node("S30"));
		g.createNodeList().setRank(NodeList.Rank.same).addNodes(
				new Node("T8"), new Node("T24"), new Node("T1"), new Node("T35"), new Node("T30"));
		g.createNodeList().setRank(NodeList.Rank.same).addNodes(
				new Node("43"), new Node("37"), new Node("36"), new Node("10"), new Node("2"));
		g.createNodeList().setRank(NodeList.Rank.same).addNodes(
				new Node("25"), new Node("9"), new Node("38"), new Node("40"), new Node("13"), 
				new Node("17"), new Node("12"), new Node("18"));
		g.createNodeList().setRank(NodeList.Rank.same).addNodes(
				new Node("26"), new Node("42"), new Node("11"), new Node("3"), new Node("33"), 
				new Node("19"), new Node("39"), new Node("14"), new Node("16"));
		g.createNodeList().setRank(NodeList.Rank.same).addNodes(
				 new Node("4"), new Node("31"), new Node("34"), new Node("21"), new Node("41"),
				 new Node("28"), new Node("20"));
		g.createNodeList().setRank(NodeList.Rank.same).addNodes(
				new Node("27"), new Node("5"), new Node("22"), new Node("32"), new Node("29"), new Node("15"));
		g.createNodeList().setRank(NodeList.Rank.same).addNodes(
				new Node("6"), new Node("23"));
		g.createNodeList().setRank(NodeList.Rank.same).addNodes(
				new Node("7"));
		
		g.addEdges(
				new Edge(g, "S8", "9"),
				new Edge(g, "S24", "25"),
				new Edge(g, "S24", "27"),
				new Edge(g, "S1", "2"),
				new Edge(g, "S1", "10"),
				new Edge(g, "S35", "43"),
				new Edge(g, "S35", "36"),
				new Edge(g, "S30", "31"),
				new Edge(g, "S30", "33"),
				new Edge(g, "9", "42"),
				new Edge(g, "9", "T1"),
				new Edge(g, "25", "T1"),
				new Edge(g, "25", "26"),
				new Edge(g, "27", "T24"),
				// Note: It is important for the edges to be constructed like this.
				// I am not sure why they cannot be separated. If they are, it produces a different result.
				// Perhaps something to do with the ranking?
				new Edge(g, "2", "3", "16", "17", "T1", "18"),
				new Edge(g, "10", "11", "14", "T1", "13", "12"),
				new Edge(g, "31", "T1"),
				new Edge(g, "31", "32"),
				new Edge(g, "33", "T30"),
				new Edge(g, "33", "34"),
				new Edge(g, "42", "4"),
				new Edge(g, "26", "4"),
				new Edge(g, "3", "4"),
				new Edge(g, "16", "15"),
				new Edge(g, "17", "19"),
				new Edge(g, "18", "29"),
				new Edge(g, "11", "4"),
				new Edge(g, "14", "15"),
				new Edge(g, "37", "39", "41", "38", "40"),				
				new Edge(g, "13", "19"),
				new Edge(g, "12", "29"),
				new Edge(g, "43", "38"),
				new Edge(g, "43", "40"),
				new Edge(g, "36", "19"),
				new Edge(g, "32", "23"),
				new Edge(g, "34", "29"),
				new Edge(g, "39", "15"),
				new Edge(g, "41", "29"),
				new Edge(g, "38", "4"),
				new Edge(g, "40", "19"),
				new Edge(g, "4", "5"),
				new Edge(g, "19", "21", "20", "28"),
				new Edge(g, "5", "6", "T35", "23"),
				new Edge(g, "21", "22"),
				new Edge(g, "20", "15"),
				new Edge(g, "28", "29"),
				new Edge(g, "6", "7"),
				new Edge(g, "15", "T1"),
				new Edge(g, "22", "T35"),
				new Edge(g, "22", "23"),
				new Edge(g, "29", "T30"),
				new Edge(g, "7", "T8"),
				new Edge(g, "23", "T24"),
				new Edge(g, "23", "T1"));
		return g;
	}
}
