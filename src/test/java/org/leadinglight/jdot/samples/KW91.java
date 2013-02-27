package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.EdgeList.Rank;
import org.leadinglight.jdot.Graph;
import org.leadinglight.jdot.SubGraph;

public class KW91 {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("G");
		SubGraph sg = new SubGraph("cluster_outer").setStyle(SubGraph.Style.bold).addEdges(new Edge(g, "Act_1", "Act_21"), new Edge(g, "Act_1", "Act_23"), new Edge(g, "Act_25", "Act_3"));
		g.addSubGraph(sg);
		SubGraph sg2 = new SubGraph("cluster_inner").setLabel("                          Act_2");
		sg2.addEdge(new Edge(g, "Act_21", "Act_22").setMinLen(2)).getEdgeList().setRank(Rank.same);
		sg2.addEdgeList().addEdges(new Edge(g, "Act_22", "Act_23"), new Edge(g, "Act_22", "Act_24"));
		sg2.addEdgeList().addEdge(new Edge(g, "Act_23", "Act_24").setMinLen(2)).setRank(Rank.same);
		sg2.addEdgeList().addEdges(new Edge(g, "Act_23", "Act_25"), new Edge(g, "Act_24", "Act_25"));
		sg.addSubGraph(sg2);
		g.addEdges(new Edge(g, "Ext_1", "Act_1"), new Edge(g, "Act_3", "Ext_2"), new Edge(g, "Ext_3", "Act_24"));
		return g;
	}
}
