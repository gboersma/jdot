package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;
import org.leadinglight.jdot.SubGraph;

public class Clust2 {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("G");
		g.addSubGraph(new SubGraph("cluster_c0").addEdges(
				new Edge(g, "a0", "a1", "a2", "a3")));
		g.addSubGraph(new SubGraph("cluster_c1").addEdges(
				new Edge(g, "b0", "b1", "b2", "b3")));
		g.addEdges(new Edge(g, "x", "a0"), new Edge(g, "x", "b0"), new Edge(g, "a1", "b3"), new Edge(g, "b3", "a1"));
		return g;
	}
}
