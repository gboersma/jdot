package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.Color;
import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;
import org.leadinglight.jdot.Node;
import org.leadinglight.jdot.SubGraph;
import org.leadinglight.jdot.Node.Shape;

public class Clust4 {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("G");
		g.addSubGraph(new SubGraph("cluster_c0").setStyle(SubGraph.Style.filled).setColor(Color.X11.lightgrey).setLabel("process #1").addNode(
				new Node().setStyle(Node.Style.filled).setColor(Color.X11.white)).addEdge(
				new Edge(g, "a0", "a1", "a2", "a3")));
		g.addSubGraph(new SubGraph("cluster_c1").setColor(Color.X11.blue).setLabel("process #2").addNode(
				new Node().setStyle(Node.Style.filled)).addEdge(
				new Edge(g, "b0", "b1", "b2", "b3")));
		g.addNodes(
				new Node("start").setShape(Node.Shape.Mdiamond),
				new Node("end").setShape(Node.Shape.Msquare));
		g.addEdges(new Edge(g, "start", "a0"), new Edge(g, "start", "b0"), new Edge(g, "a1", "b3"), new Edge(g, "b2", "a3"), 
				new Edge(g, "a3", "a0"), new Edge(g, "a3", "end"), new Edge(g, "b3", "end"));
		return g;
	}
}
