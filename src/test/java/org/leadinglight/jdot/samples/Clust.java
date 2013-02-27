package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.*;
import org.leadinglight.jdot.enums.*;

public class Clust {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("G");
		g.addClusterGraph(
				new ClusterGraph("_0").setLabel("hello world").setColor(Color.X11.hotpink).addEdge("a", "b").addEdge("a", "c"));
		g.addClusterGraph(
				new ClusterGraph("_1").setLabel("MSDOT").setColor(Color.X11.purple).setStyle(Style.ClusterGraph.dashed).addEdge("x", "y").addEdge("x", "z").addEdge("y", "z").addEdge("y", "q"));
		g.addEdges(new Edge("top", "a"), new Edge("top", "y"), new Edge("y", "b"));
		return g;
	}
}
