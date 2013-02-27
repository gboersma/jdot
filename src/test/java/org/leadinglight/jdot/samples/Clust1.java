package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.ClusterGraph;
import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;

public class Clust1 {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("G");
		g.addClusterGraph(new ClusterGraph("_c0").addEdges(
				new Edge(g, "a0", "a1", "a2", "a3")));
		g.addClusterGraph(new ClusterGraph("_c1").addEdges(
				new Edge(g, "b0", "b1", "b2", "b3")));
		g.addEdges(new Edge(g, "x", "a0"), new Edge(g, "x", "b0"), new Edge(g, "a1", "a3"), new Edge(g, "a3", "a0"));
		return g;
	}
}
