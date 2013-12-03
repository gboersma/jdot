package info.leadinglight.jdot.samples;

import info.leadinglight.jdot.*;
import info.leadinglight.jdot.enums.*;

public class Tree {

    public static void main(String[] args) {
        g().viewSvg();
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
                new Edge().addNode("node0", "f2").addNode("node4", "f1"),
                new Edge().addNode("node0", "f0").addNode("node1", "f1"),
                new Edge().addNode("node1", "f0").addNode("node2", "f1"),
                new Edge().addNode("node1", "f2").addNode("node3", "f1"),
                new Edge().addNode("node2", "f2").addNode("node8", "f1"),
                new Edge().addNode("node2", "f0").addNode("node7", "f1"),
                new Edge().addNode("node4", "f2").addNode("node6", "f1"),
                new Edge().addNode("node4", "f0").addNode("node5", "f1"));
        return g;
    }
}
