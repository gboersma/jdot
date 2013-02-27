package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.ClusterGraph;
import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;

public class Clust5 {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("G").setSize("6,6");
		g.addEdge(new Edge(g, "a", "b", "c"));
		g.addClusterGraph(new ClusterGraph("cluster0").addEdges(
				new Edge(g, "x0", "y0"), new Edge(g, "x0", "z0")));
		g.addClusterGraph(new ClusterGraph("cluster1").addEdges(
				new Edge(g, "x1", "y1"), new Edge(g, "x1", "z1")));
		g.addClusterGraph(new ClusterGraph("cluster2").addEdges(
				new Edge(g, "x2", "y2"), new Edge(g, "x2", "z2")));
		g.addEdges(new Edge(g, "a", "x0"), new Edge(g, "b", "x1"), new Edge(g, "b", "x2"), new Edge(g, "a", "z2"), new Edge(g, "c", "z1"));
		return g;
	}
}
