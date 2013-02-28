package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.*;
import org.leadinglight.jdot.enums.*;

public class Clust4 {
	public static void main(String[] args) {
		g().viewSvg();
	}

	public static Graph g() {
		Graph g = new Graph("G");
		g.addClusterGraph(new ClusterGraph("_0").setStyle(Style.ClusterGraph.filled).setColor(Color.X11.lightgrey).setLabel("process #1").addNode(
				new Node().setStyle(Style.Node.filled).setColor(Color.X11.white)).addEdge("a0", "a1", "a2", "a3"));
		g.addClusterGraph(new ClusterGraph("_1").setColor(Color.X11.blue).setLabel("process #2").addNode(
				new Node().setStyle(Style.Node.filled)).addEdge("b0", "b1", "b2", "b3"));
		g.addNodes(
				new Node("start").setShape(Shape.Mdiamond),
				new Node("end").setShape(Shape.Msquare));
		g.addEdges(new Edge("start", "a0"), new Edge("start", "b0"), new Edge("a1", "b3"), new Edge("b2", "a3"), 
				new Edge("a3", "a0"), new Edge("a3", "end"), new Edge("b3", "end"));
		return g;
	}
}
