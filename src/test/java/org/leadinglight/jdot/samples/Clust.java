package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.Color;
import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;
import org.leadinglight.jdot.SubGraph;

public class Clust {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("G");
		g.addSubGraph(new SubGraph("cluster_0").setLabel("hello world").setColor(Color.X11.hotpink).addEdges(
				new Edge(g, "a", "b"), new Edge(g, "a", "c")));
		g.addSubGraph(new SubGraph("cluster_1").setLabel("MSDOT").setColor(Color.X11.purple).setStyle(SubGraph.Style.dashed).addEdges(
				new Edge(g, "x", "y"), new Edge(g, "x", "z"), new Edge(g, "y", "z"), new Edge(g, "y", "q")));
		g.addEdges(new Edge(g, "top", "a"), new Edge(g, "top", "y"), new Edge(g, "y", "b"));
		return g;
	}
}
