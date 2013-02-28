package info.leadinglight.jdot.samples;

import info.leadinglight.jdot.*;
import info.leadinglight.jdot.enums.*;


public class Trapeziumlr {
	public static void main(String[] args) {
		g().viewSvg();
	}
	
	public static Graph g() {
		Graph g = new Graph("test").setSize("7,9.5").setPage("8,10.5").setRatio(Ratio.fill).setRankDir(Rankdir.LR);
		g.addSubGraph(new SubGraph().setRank(Rank.same).addNodes(
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
				new Node("Z")));
		g.addSubGraph(new SubGraph().addNodes(
				new Node().setShape(Shape.trapezium),
				new Node("Trapezium")).setRank(Rank.same).setOrdering(Ordering.out));
		g.addEdges(
				new Edge("Trapezium", "A"),
				new Edge("Trapezium", "B"),
				new Edge("Trapezium", "C"),
				new Edge("Trapezium", "D"),
				new Edge("Trapezium", "E"),
				new Edge("Trapezium", "F"),
				new Edge("Trapezium", "G"),
				new Edge("Trapezium", "H"),
				new Edge("Trapezium", "I"),
				new Edge("Trapezium", "J"),
				new Edge("Trapezium", "K"),
				new Edge("Trapezium", "L"),
				new Edge("Trapezium", "M"),
				new Edge("Trapezium", "N"),
				new Edge("Trapezium", "O"),
				new Edge("Trapezium", "P"),
				new Edge("Trapezium", "Q"),
				new Edge("Trapezium", "R"),
				new Edge("Trapezium", "S"),
				new Edge("Trapezium", "T"),
				new Edge("Trapezium", "U"),
				new Edge("Trapezium", "V"),
				new Edge("Trapezium", "W"),
				new Edge("Trapezium", "X"),
				new Edge("Trapezium", "Y"),
				new Edge("Trapezium", "Z"));
		g.addSubGraph(new SubGraph().addNodes(
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
				new Node("z")).setRank(Rank.same));
		g.addEdges(
				new Edge("a", "Trapezium"),
				new Edge("b", "Trapezium"),
				new Edge("c", "Trapezium"),
				new Edge("d", "Trapezium"),
				new Edge("e", "Trapezium"),
				new Edge("f", "Trapezium"),
				new Edge("g", "Trapezium"),
				new Edge("h", "Trapezium"),
				new Edge("i", "Trapezium"),
				new Edge("j", "Trapezium"),
				new Edge("k", "Trapezium"),
				new Edge("l", "Trapezium"),
				new Edge("m", "Trapezium"),
				new Edge("n", "Trapezium"),
				new Edge("o", "Trapezium"),
				new Edge("p", "Trapezium"),
				new Edge("q", "Trapezium"),
				new Edge("r", "Trapezium"),
				new Edge("s", "Trapezium"),
				new Edge("t", "Trapezium"),
				new Edge("u", "Trapezium"),
				new Edge("v", "Trapezium"),
				new Edge("w", "Trapezium"),
				new Edge("x", "Trapezium"),
				new Edge("y", "Trapezium"),
				new Edge("z", "Trapezium"));
		return g;
	}
}
