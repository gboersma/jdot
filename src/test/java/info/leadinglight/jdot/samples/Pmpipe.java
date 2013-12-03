package info.leadinglight.jdot.samples;

import info.leadinglight.jdot.*;
import info.leadinglight.jdot.enums.*;

public class Pmpipe {

    public static void main(String[] args) {
        g().viewSvg();
    }

    public static Graph g() {
        Graph g = new Graph("g");
        // Style node
        g.addNode(new Node().setFontSize(14).setFontName("Times-Roman")
                .setFontColor(Color.X11.black).setShape(Shape.box)
                .setColor(Color.X11.black).setWidth(0.5));
        // Style edge
        g.addEdge(new Edge().setFontSize(14).setFontName("Times-Roman")
                .setFontColor(Color.X11.black).setColor(Color.X11.black));
        // Nodes
        g.addNodes(
                new Node("23296").setLabel("23296\\n?"),
                new Node("182948-1").setLabel("182948-1\\n182949-1\\npipe")
                .setFontSize(7).setShape(Shape.doublecircle),
                new Node("23310").setLabel("23310\\ncat"),
                new Node("182950-1").setLabel("182950-1\\n182951-1\\npipe")
                .setFontSize(7).setShape(Shape.doublecircle),
                new Node("23311").setLabel("23311\\ncat"),
                new Node("182952-1").setLabel("182952-1\\n182953-1\\npipe")
                .setFontSize(7).setShape(Shape.doublecircle),
                new Node("23312").setLabel("23312\\ncat"),
                new Node("182954-1").setLabel("182954-1\\n182955-1\\npipe")
                .setFontSize(7).setShape(Shape.doublecircle),
                new Node("23313").setLabel("23313\\ncat"),
                new Node("79893+2568").setLabel(
                        "79893+2568\\n/usr/share/lib/termcap").setShape(
                        Shape.ellipse),
                new Node("85+2560").setLabel("85+2560\\n?").setShape(
                        Shape.ellipse), new Node("23314")
                .setLabel("23314\\ncat"),
                new Node("4151865284+0").setLabel("4151865284+0\\n/tmp/termcap")
                .setShape(Shape.ellipse));
        g.addEdges(
                new Edge("23296", "23310").setFontSize(14)
                .setFontName("Times-Roman")
                .setFontColor(Color.X11.black)
                .setColor(Color.X11.black),
                new Edge("23296", "23311").setFontSize(14)
                .setFontName("Times-Roman")
                .setFontColor(Color.X11.black)
                .setColor(Color.X11.black),
                new Edge("23311", "182948-1").setFontSize(14)
                .setFontName("Times-Roman")
                .setFontColor(Color.X11.black)
                .setColor(Color.X11.black).setDir(Dir.back),
                new Edge("23310", "182948-1").setFontSize(14)
                .setFontName("Times-Roman")
                .setFontColor(Color.X11.black)
                .setColor(Color.X11.black).setDir(Dir.forward),
                new Edge("23296", "23312").setFontSize(14)
                .setFontName("Times-Roman")
                .setFontColor(Color.X11.black)
                .setColor(Color.X11.black),
                new Edge("23312", "182952-1").setFontSize(14)
                .setFontName("Times-Roman")
                .setFontColor(Color.X11.black)
                .setColor(Color.X11.black).setDir(Dir.forward),
                new Edge("23312", "182950-1").setFontSize(14)
                .setFontName("Times-Roman")
                .setFontColor(Color.X11.black)
                .setColor(Color.X11.black).setDir(Dir.back),
                new Edge("23296", "23313").setFontSize(14)
                .setFontName("Times-Roman")
                .setFontColor(Color.X11.black)
                .setColor(Color.X11.black),
                new Edge("23313", "182954-1").setFontSize(14)
                .setFontName("Times-Roman")
                .setFontColor(Color.X11.black)
                .setColor(Color.X11.black).setDir(Dir.forward),
                new Edge("23311", "182950-1").setFontSize(14)
                .setFontName("Times-Roman")
                .setFontColor(Color.X11.black)
                .setColor(Color.X11.black).setDir(Dir.forward),
                new Edge("23310", "79893+2568").setFontSize(14)
                .setFontName("Times-Roman")
                .setFontColor(Color.X11.black)
                .setColor(Color.X11.black).setDir(Dir.back),
                new Edge("23296", "85+2560").setFontSize(14)
                .setFontName("Times-Roman")
                .setFontColor(Color.X11.black)
                .setColor(Color.X11.black).setDir(Dir.both),
                new Edge("23296", "23314").setFontSize(14)
                .setFontName("Times-Roman")
                .setFontColor(Color.X11.black)
                .setColor(Color.X11.black),
                new Edge("23314", "85+2560").setFontSize(14)
                .setFontName("Times-Roman")
                .setFontColor(Color.X11.black)
                .setColor(Color.X11.black).setDir(Dir.both),
                new Edge("23314", "182954-1").setFontSize(14)
                .setFontName("Times-Roman")
                .setFontColor(Color.X11.black)
                .setColor(Color.X11.black).setDir(Dir.back),
                new Edge("23296", "85+2560").setFontSize(14)
                .setFontName("Times-Roman")
                .setFontColor(Color.X11.black)
                .setColor(Color.X11.black).setDir(Dir.both),
                new Edge("23314", "4151865284+0").setFontSize(14)
                .setFontName("Times-Roman")
                .setFontColor(Color.X11.black)
                .setColor(Color.X11.black).setDir(Dir.forward),
                new Edge("23313", "182952-1").setFontSize(14)
                .setFontName("Times-Roman")
                .setFontColor(Color.X11.black)
                .setColor(Color.X11.black).setDir(Dir.back));
        return g;
    }
}
