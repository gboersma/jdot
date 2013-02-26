package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;
import org.leadinglight.jdot.Node;
import org.leadinglight.jdot.Node.Shape;
import org.leadinglight.jdot.Node.Style;

public class Switch {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}
	
	public static Graph g() {
		Graph g = new Graph("G").setCenter(true).setRankDir(Graph.Rankdir.LR).setBgColor("#808080");
		g.addEdge(new Edge().setDir(Edge.Dir.none));
		g.addNode(new Node().setWidth(0.3).setHeight(0.3).setLabel(""));
		g.addNodeList().addNodes(
				new Node().setShape(Shape.circle).setStyle(Style.invis),
				new Node("1"), new Node("2"), new Node("3"), new Node("4"), new Node("5"), new Node("6"), new Node("7"), new Node("8"),
				new Node("10"), new Node("20"), new Node("30"), new Node("40"), new Node("50"), new Node("60"), new Node("70"), new Node("80"));
		g.addNodeList().addNodes(
				new Node().setShape(Shape.circle),
				new Node("a"), new Node("b"), new Node("c"), new Node("d"), new Node("e"), new Node("f"), new Node("g"), new Node("h"), 
				new Node("i"), new Node("j"), new Node("k"), new Node("l"), new Node("m"), new Node("n"), new Node("o"), new Node("p"), 
				new Node("q"), new Node("r"), new Node("s"), new Node("t"), new Node("u"), new Node("v"), new Node("w"), new Node("x"));
		g.addNodeList().addNodes(
				new Node().setShape(Shape.diamond),
				new Node("A"), new Node("B"), new Node("C"), new Node("D"), new Node("E"), new Node("F"), new Node("G"), new Node("H"), 
				new Node("I"), new Node("J"), new Node("K"), new Node("L"), new Node("M"), new Node("N"), new Node("O"), new Node("P"), 
				new Node("Q"), new Node("R"), new Node("S"), new Node("T"), new Node("U"), new Node("V"), new Node("W"), new Node("X"));
		g.addEdgeList().addEdges(
				new Edge(g, "1", "a").addNodes(g, "A", "B").setColor("#0000ff"),
				new Edge(g, "2", "b").addNodes(g, "B", "A").setColor("#ff0000"),
				new Edge(g, "3", "c").addNodes(g, "C", "D").setColor("#ffff00"),
				new Edge(g, "4", "d").addNodes(g, "D", "C").setColor("#00ff00"),
				new Edge(g, "5", "e").addNodes(g, "E", "F").setColor("#000000"),
				new Edge(g, "6", "f").addNodes(g, "F", "E").setColor("#00ffff"),
				new Edge(g, "7", "g").addNodes(g, "G", "H").setColor("#ffffff"),
				new Edge(g, "8", "h").addNodes(g, "H", "G").setColor("#ff00ff"));
		g.addEdgeList().addEdges(
				new Edge().setColor("#ff0000:#0000ff"),
				new Edge(g, "A", "i").addNodes(g, "I", "K"),
				new Edge(g, "B", "j").addNodes(g, "J", "L"));
		g.addEdgeList().addEdges(
				new Edge().setColor("#00ff00:#ffff00"),
				new Edge(g, "C", "k").addNodes(g, "K", "I"),
				new Edge(g, "D", "l").addNodes(g, "L", "J"));
		g.addEdgeList().addEdges(
				new Edge().setColor("#00ffff:#000000"),
				new Edge(g, "E", "m").addNodes(g, "M", "O"),
				new Edge(g, "F", "n").addNodes(g, "N", "P"));
		g.addEdgeList().addEdges(
				new Edge().setColor("#ff00ff:#ffffff"),
				new Edge(g, "G", "o").addNodes(g, "O", "M"),
				new Edge(g, "H", "p").addNodes(g, "P", "N"));
		g.addEdgeList().addEdges(
				new Edge().setColor("#00ff00:#ffff00:#ff0000:#0000ff"),
				new Edge(g, "I", "q").addNodes(g, "Q", "U"),
				new Edge(g, "J", "r").addNodes(g, "R", "V"),
				new Edge(g, "K", "s").addNodes(g, "S", "W"),
				new Edge(g, "L", "t").addNodes(g, "T", "X"));
		g.addEdgeList().addEdges(
				new Edge().setColor("#ff00ff:#ffffff:#00ffff:#000000"),
				new Edge(g, "M", "u").addNodes(g, "U", "Q"),
				new Edge(g, "N", "v").addNodes(g, "V", "R"),
				new Edge(g, "O", "w").addNodes(g, "W", "S"),
				new Edge(g, "P", "x").addNodes(g, "X", "T"));
		g.addEdgeList().addEdges(
				new Edge().setColor("#ff00ff:#ffffff:#00ffff:#000000:#00ff00:#ffff00:#ff0000:#0000ff"),
				new Edge(g, "Q", "10"),
				new Edge(g, "R", "20"),
				new Edge(g, "S", "30"),
				new Edge(g, "T", "40"),
				new Edge(g, "U", "50"),
				new Edge(g, "V", "60"),
				new Edge(g, "W", "70"),
				new Edge(g, "X", "80"));
		return g;
	}
}
