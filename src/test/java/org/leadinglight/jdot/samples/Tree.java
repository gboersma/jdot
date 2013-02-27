package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;
import org.leadinglight.jdot.Node;
import org.leadinglight.jdot.Node.Shape;

public class Tree {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("g").addNode(new Node().setShape(Shape.record).setHeight(0.1));
		g.addNodes(
				new Node("node0").setLabel("<f0> |<f1> G|<f2> "),
				new Node("node1").setLabel("<f0> |<f1> E|<f2> "),
				new Node("node2").setLabel("<f0> |<f1> B|<f2> "),
				new Node("node3").setLabel("<f0> |<f1> F|<f2> "),
				new Node("node4").setLabel("<f0> |<f1> R|<f2> "),
				new Node("node5").setLabel("<f0> |<f1> H|<f2> "),
				new Node("node6").setLabel("<f0> |<f1> Y|<f2> "),
				new Node("node7").setLabel("<f0> |<f1> A|<f2> "),
				new Node("node8").setLabel("<f0> |<f1> C|<f2> "));
		g.addEdges(
				new Edge().addNode(g, "node0", "f2").addNode(g, "node4", "f1"),
				new Edge().addNode(g, "node0", "f0").addNode(g, "node1", "f1"),
				new Edge().addNode(g, "node1", "f0").addNode(g, "node2", "f1"),
				new Edge().addNode(g, "node1", "f2").addNode(g, "node3", "f1"),
				new Edge().addNode(g, "node2", "f2").addNode(g, "node8", "f1"),
				new Edge().addNode(g, "node2", "f0").addNode(g, "node7", "f1"),
				new Edge().addNode(g, "node4", "f2").addNode(g, "node6", "f1"),
				new Edge().addNode(g, "node4", "f0").addNode(g, "node5", "f1"));
		return g;
	}
}
