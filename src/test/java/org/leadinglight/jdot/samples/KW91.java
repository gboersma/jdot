package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.ClusterGraph;
import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.EdgeList.Rank;
import org.leadinglight.jdot.Graph;

public class KW91 {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("G");
		ClusterGraph sg = new ClusterGraph("_outer").setStyle(ClusterGraph.Style.bold).addEdges(new Edge(g, "Act_1", "Act_21"), new Edge(g, "Act_1", "Act_23"), new Edge(g, "Act_25", "Act_3"));
		g.addClusterGraph(sg);
		ClusterGraph sg2 = new ClusterGraph("_inner").setLabel("                          Act_2");
		sg2.addEdge(new Edge(g, "Act_21", "Act_22").setMinLen(2)).getEdgeList().setRank(Rank.same);
		sg2.addEdgeList().addEdges(new Edge(g, "Act_22", "Act_23"), new Edge(g, "Act_22", "Act_24"));
		sg2.addEdgeList().addEdge(new Edge(g, "Act_23", "Act_24").setMinLen(2)).setRank(Rank.same);
		sg2.addEdgeList().addEdges(new Edge(g, "Act_23", "Act_25"), new Edge(g, "Act_24", "Act_25"));
		sg.addClusterGraph(sg2);
		g.addEdges(new Edge(g, "Ext_1", "Act_1"), new Edge(g, "Act_3", "Ext_2"), new Edge(g, "Ext_3", "Act_24"));
		return g;
	}
}
