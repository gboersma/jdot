package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.*;

public class Clust3 {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("G");
		g.addClusterGraph(new ClusterGraph("_c0").addEdge("a0", "a1", "a2", "a3"));
		g.addClusterGraph(new ClusterGraph("_c1").addEdge("b0", "b1", "b2", "b3"));
		g.addEdges(new Edge("x", "a0"), new Edge("x", "b0"), new Edge("a1", "b3"), new Edge("b1", "a3"));
		return g;
	}
}
