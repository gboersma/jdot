package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.Color;
import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;
import org.leadinglight.jdot.Node;

public class Directed {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}
	
	public static Graph g() {
		Graph g = new Graph("sample1").setType(Graph.Type.digraph);
		Node n1 = new Node("1").setLabel("Node 1").setColor(Color.X11.green)
				.setShape(Node.Shape.square);
		Node n2 = new Node("2").setLabel("Node 2").setColor(Color.X11.purple)
				.setShape(Node.Shape.circle);
		Node n3 = new Node("3").setLabel("Node 3").setColor(Color.X11.blue)
				.setShape(Node.Shape.triangle);
		Edge e1 = new Edge(n1, n2).setColor(Color.X11.red);
		Edge e2 = new Edge(n1, n3).setLabel("This is an edge.").setColor(
				Color.X11.green);
		Edge e3 = new Edge(n2, n3).setColor(Color.X11.yellow);
		g.addNodes(n1, n2, n3).addEdges(e1, e2, e3);
		return g;
	}
}
