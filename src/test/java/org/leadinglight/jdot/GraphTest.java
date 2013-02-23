package org.leadinglight.jdot;

public class GraphTest {
	public static void main(String[] args) {
		GraphTest gt = new GraphTest();
		Graph g1 = gt.simpleDirectedGraph();
		System.out.println("Simple directed graph:\n" + g1.toDot());
		g1.dot2svg();
		Graph g2 = gt.directedGraph();
		System.out.println("Directed graph:\n" + g2.toDot());
		g2.dot2svg();
		Graph g3 = gt.undirectedGraph();
		System.out.println("Undirected graph:\n" + g3.toDot());
		g3.dot2svg();
	}
	
	public Graph simpleDirectedGraph() {
		Graph g = new Graph();
		Node n1 = new Node("1");
		Node n2 = new Node("2");
		Node n3 = new Node("3");
		Edge e1 = new Edge(n1, n2);
		Edge e2 = new Edge(n1, n3);
		Edge e3 = new Edge(n2, n3);
		g.addNode(n1).addNode(n2).addNode(n3).addEdge(e1).addEdge(e2).addEdge(e3);
		return g;
	}
	
	public Graph directedGraph() {
		Graph g = new Graph().setName("sample1").setType(Graph.Type.digraph);
		Node n1 = new Node("1").setLabel("Node 1").setColor(Color.X11.green).setShape(Node.Shape.square);
		Node n2 = new Node("2").setLabel("Node 2").setColor(Color.X11.purple).setShape(Node.Shape.circle);
		Node n3 = new Node("3").setLabel("Node 3").setColor(Color.X11.blue).setShape(Node.Shape.triangle);
		Edge e1 = new Edge(n1, n2).setColor(Color.X11.red);
		Edge e2 = new Edge(n1, n3).setLabel("This is an edge.").setColor(Color.X11.green);
		Edge e3 = new Edge(n2, n3).setColor(Color.X11.yellow);
		g.addNode(n1).addNode(n2).addNode(n3).addEdge(e1).addEdge(e2).addEdge(e3);
		return g;
	}
	
	public Graph undirectedGraph() {
		Graph g = new Graph().setName("sample1").setType(Graph.Type.graph).setStrict(true);
		Node n1 = new Node("1").setLabel("Node 1").setColor(Color.X11.green).setShape(Node.Shape.square);
		Node n2 = new Node("2").setLabel("Node 2").setColor(Color.X11.purple).setShape(Node.Shape.circle);
		Node n3 = new Node("3").setLabel("Node 3").setColor(Color.X11.blue).setShape(Node.Shape.triangle);
		Edge e1 = new Edge(n1, n2).setColor(Color.X11.red);
		Edge e2 = new Edge(n1, n3).setLabel("This is an edge.").setColor(Color.X11.green);
		Edge e3 = new Edge(n2, n3).setColor(Color.X11.yellow);
		g.addNode(n1).addNode(n2).addNode(n3).addEdge(e1).addEdge(e2).addEdge(e3);
		return g;
	}
}
