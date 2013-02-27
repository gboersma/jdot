package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.*;

public class Clust5 {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("G").setSize("6,6");
		g.addEdge(new Edge("a", "b", "c"));
		g.addClusterGraph(new ClusterGraph("cluster0").addEdge("x0", "y0").addEdge("x0", "z0"));
		g.addClusterGraph(new ClusterGraph("cluster1").addEdge("x1", "y1").addEdge("x1", "z1"));
		g.addClusterGraph(new ClusterGraph("cluster2").addEdges(new Edge("x2", "y2"), new Edge("x2", "z2")));
		g.addEdges(new Edge("a", "x0"), new Edge("b", "x1"), new Edge("b", "x2"), new Edge("a", "z2"), new Edge("c", "z1"));
		return g;
	}
}
