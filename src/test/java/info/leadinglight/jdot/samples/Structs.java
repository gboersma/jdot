package info.leadinglight.jdot.samples;

import info.leadinglight.jdot.*;
import info.leadinglight.jdot.enums.*;

public class Structs {

    public static void main(String[] args) {
        g().viewSvg();
    }

    public static Graph g() {
        Graph g = new Graph("structs");
        g.addNodes(
                new Node().setShape(Shape.record),
                new Node("struct1").setShape(Shape.record).setLabel("<f0> left|<f1> middle|<f2> right"),
                new Node("struct2").setShape(Shape.record).setLabel("<f0> one|<f1> two"),
                new Node("struct3").setShape(Shape.record).setLabel("hello\nworld |{ b |{c|<here> d|e}| f}| g | h"));
        g.addEdges(
                new Edge().addNode("struct1", "f1").addNode("struct2", "f0"),
                new Edge().addNode("struct1", "f2").addNode("struct3", "here"));
        return g;
    }
}
