package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;
import org.leadinglight.jdot.Node;

public class SimpleDirected {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}
	
	public static Graph g() {
		Graph g = new Graph();
		Node n1 = new Node("1");
		Node n2 = new Node("2");
		Node n3 = new Node("3");
		Edge e1 = new Edge(n1, n2);
		Edge e2 = new Edge(n1, n3);
		Edge e3 = new Edge(n2, n3);
		g.addNodes(n1, n2, n3).addEdges(e1, e2, e3);
		return g;
	}
}
