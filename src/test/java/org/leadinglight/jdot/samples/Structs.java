package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;
import org.leadinglight.jdot.Node;
import org.leadinglight.jdot.Node.Shape;

public class Structs {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("structs");
		g.addNodes(
				new Node().setShape(Shape.record),
				new Node("struct1").setShape(Shape.record).setLabel("<f0> left|<f1> middle|<f2> right"),
				new Node("struct2").setShape(Shape.record).setLabel("<f0> one|<f1> two"),
				new Node("struct3").setShape(Shape.record).setLabel("hello\nworld |{ b |{c|<here> d|e}| f}| g | h"));
		g.addEdges(
				new Edge().addNode(g, "struct1", "f1").addNode(g, "struct2", "f0"),
				new Edge().addNode(g, "struct1", "f2").addNode(g, "struct3", "here"));
		return g;
	}
}
