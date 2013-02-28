package info.leadinglight.jdot.samples;

import info.leadinglight.jdot.*;

public class Clust2 {
	public static void main(String[] args) {
		g().viewSvg();
	}

	public static Graph g() {
		Graph g = new Graph("G");
		g.addClusterGraph(new ClusterGraph("_c0").addEdge("a0", "a1", "a2", "a3"));
		g.addClusterGraph(new ClusterGraph("_c1").addEdge("b0", "b1", "b2", "b3"));
		g.addEdges(new Edge("x", "a0"), new Edge("x", "b0"), new Edge("a1", "b3"), new Edge("b3", "a1"));
		return g;
	}
}
