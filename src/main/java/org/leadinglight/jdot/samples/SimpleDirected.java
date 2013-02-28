package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.*;

public class SimpleDirected {
	public static void main(String[] args) {
		g().viewSvg();
	}
	
	public static Graph g() {
		Graph g = new Graph();
		Node n1 = new Node("1");
		Node n2 = new Node("2");
		Node n3 = new Node("3");
		Edge e1 = new Edge("1", "2");
		Edge e2 = new Edge("1", "3");
		Edge e3 = new Edge("2", "3");
		g.addNodes(n1, n2, n3).addEdges(e1, e2, e3);
		return g;
	}
}
