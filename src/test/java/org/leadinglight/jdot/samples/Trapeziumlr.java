package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;
import org.leadinglight.jdot.Node;
import org.leadinglight.jdot.Node.Shape;
import org.leadinglight.jdot.NodeList;

public class Trapeziumlr {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}
	
	public static Graph g() {
		Graph g = new Graph();
		g.setSize("7,9.5").setPage("8,10.5").setRatio(Graph.Ratio.fill).setRankDir(Graph.Rankdir.LR);
		g.getNodeList().setRank(NodeList.Rank.same);
		g.addNodes(
				new Node().setShape(Shape.house),
				new Node("A"),
				new Node("C"),
				new Node("E"),
				new Node("G"),
				new Node("I"),
				new Node("K"),
				new Node("M"),
				new Node("O"),
				new Node("Q"),
				new Node("S"),
				new Node("U"),
				new Node("W"),
				new Node("Y"),
				new Node().setShape(Shape.invhouse),
				new Node("B"),
				new Node("D"),
				new Node("F"),
				new Node("H"),
				new Node("J"),
				new Node("L"),
				new Node("N"),
				new Node("P"),
				new Node("R"),
				new Node("T"),
				new Node("V"),
				new Node("X"),
				new Node("Z"));
		g.createNodeList().addNodes(
				new Node().setShape(Shape.trapezium),
				new Node("Trapezium"));
		g.getNodeList().setRank(NodeList.Rank.same).setOrdering(NodeList.Ordering.out);
		g.addEdges(
				new Edge(g, "Trapezium", "A"),
				new Edge(g, "Trapezium", "B"),
				new Edge(g, "Trapezium", "C"),
				new Edge(g, "Trapezium", "D"),
				new Edge(g, "Trapezium", "E"),
				new Edge(g, "Trapezium", "F"),
				new Edge(g, "Trapezium", "G"),
				new Edge(g, "Trapezium", "H"),
				new Edge(g, "Trapezium", "I"),
				new Edge(g, "Trapezium", "J"),
				new Edge(g, "Trapezium", "K"),
				new Edge(g, "Trapezium", "L"),
				new Edge(g, "Trapezium", "M"),
				new Edge(g, "Trapezium", "N"),
				new Edge(g, "Trapezium", "O"),
				new Edge(g, "Trapezium", "P"),
				new Edge(g, "Trapezium", "Q"),
				new Edge(g, "Trapezium", "R"),
				new Edge(g, "Trapezium", "S"),
				new Edge(g, "Trapezium", "T"),
				new Edge(g, "Trapezium", "U"),
				new Edge(g, "Trapezium", "V"),
				new Edge(g, "Trapezium", "W"),
				new Edge(g, "Trapezium", "X"),
				new Edge(g, "Trapezium", "Y"),
				new Edge(g, "Trapezium", "Z"));
		g.createNodeList().addNodes(
				new Node().setShape(Shape.parallelogram),
				new Node("a"),
				new Node("b"),
				new Node("c"),
				new Node("d"),
				new Node("e"),
				new Node("f"),
				new Node("g"),
				new Node("h"),
				new Node("i"),
				new Node("j"),
				new Node("k"),
				new Node("l"),
				new Node("m"),
				new Node("n"),
				new Node("o"),
				new Node("p"),
				new Node("q"),
				new Node("r"),
				new Node("s"),
				new Node("t"),
				new Node("u"),
				new Node("v"),
				new Node("w"),
				new Node("x"),
				new Node("y"),
				new Node("z"));
		g.getNodeList().setRank(NodeList.Rank.same);
		g.addEdges(
				new Edge(g, "a", "Trapezium"),
				new Edge(g, "b", "Trapezium"),
				new Edge(g, "c", "Trapezium"),
				new Edge(g, "d", "Trapezium"),
				new Edge(g, "e", "Trapezium"),
				new Edge(g, "f", "Trapezium"),
				new Edge(g, "g", "Trapezium"),
				new Edge(g, "h", "Trapezium"),
				new Edge(g, "i", "Trapezium"),
				new Edge(g, "j", "Trapezium"),
				new Edge(g, "k", "Trapezium"),
				new Edge(g, "l", "Trapezium"),
				new Edge(g, "m", "Trapezium"),
				new Edge(g, "n", "Trapezium"),
				new Edge(g, "o", "Trapezium"),
				new Edge(g, "p", "Trapezium"),
				new Edge(g, "q", "Trapezium"),
				new Edge(g, "r", "Trapezium"),
				new Edge(g, "s", "Trapezium"),
				new Edge(g, "t", "Trapezium"),
				new Edge(g, "u", "Trapezium"),
				new Edge(g, "v", "Trapezium"),
				new Edge(g, "w", "Trapezium"),
				new Edge(g, "x", "Trapezium"),
				new Edge(g, "y", "Trapezium"),
				new Edge(g, "z", "Trapezium"));
		return g;
	}
}
