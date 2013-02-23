package org.leadinglight.jdot;

public class GraphTest {
	public static void main(String[] args) {
		GraphTest gt = new GraphTest();
		Graph g1 = gt.simpleDirectedGraph();
//		System.out.println("Simple directed graph:\n" + g1.toDot());
//		g1.dot2svg();
//		Graph g2 = gt.directedGraph();
//		System.out.println("Directed graph:\n" + g2.toDot());
//		g2.dot2svg();
		Graph g3 = gt.undirectedGraph();
		System.out.println("Undirected graph:\n" + g3.toDot());
		g3.dot2svg();
	}
	
	public Graph simpleDirectedGraph() {
		Graph g = new Graph();
		Node n1 = new Node("1");
		g.addNode(n1);
		Node n2 = new Node("2");
		g.addNode(n2);
		Node n3 = new Node("3");
		g.addNode(n3);
		Edge e1 = new Edge(n1, n2);
		g.addEdge(e1);
		Edge e2 = new Edge(n1, n3);
		g.addEdge(e2);
		Edge e3 = new Edge(n2, n3);
		g.addEdge(e3);
		return g;
	}
	
	public Graph directedGraph() {
		// TODO Support much nicer construction patterns.
		Graph g = new Graph();
		g.setName("sample1");
		g.setType(GraphType.digraph);
		Node n1 = new Node("1");
		n1.setLabel("Node 1");
		n1.setColor("green");
		n1.setShape("square");
		g.addNode(n1);
		Node n2 = new Node("2");
		n2.setLabel("Node 2");
		n2.setColor("purple");
		n2.setShape("circle");
		g.addNode(n2);
		Node n3 = new Node("3");
		n3.setLabel("Node 3");
		n3.setColor("blue");
		n3.setShape("triangle");
		g.addNode(n3);
		Edge e1 = new Edge(n1, n2);
		e1.setColor("red");
		g.addEdge(e1);
		Edge e2 = new Edge(n1, n3);
		e2.setLabel("This is an edge.");
		e2.setColor("green");
		g.addEdge(e2);
		Edge e3 = new Edge(n2, n3);
		e3.setColor("yellow");
		g.addEdge(e3);
		return g;
	}
	
	public Graph undirectedGraph() {
		// TODO Support much nicer construction patterns.
		Graph g = new Graph();
		g.setName("sample1");
		g.setType(GraphType.graph);
		Node n1 = new Node("1");
		n1.setLabel("Node 1");
		n1.setColor("green");
		n1.setShape("square");
		g.addNode(n1);
		Node n2 = new Node("2");
		n2.setLabel("Node 2");
		n2.setColor("purple");
		n2.setShape("circle");
		g.addNode(n2);
		Node n3 = new Node("3");
		n3.setLabel("Node 3");
		n3.setColor("blue");
		n3.setShape("triangle");
		g.addNode(n3);
		Edge e1 = new Edge(n1, n2);
		e1.setColor("red");
		g.addEdge(e1);
		Edge e2 = new Edge(n1, n3);
		e2.setLabel("This is an edge.");
		e2.setColor("green");
		g.addEdge(e2);
		Edge e3 = new Edge(n2, n3);
		e3.setColor("yellow");
		g.addEdge(e3);
		return g;
	}
}
