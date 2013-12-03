package info.leadinglight.jdot.samples;

import info.leadinglight.jdot.*;
import info.leadinglight.jdot.enums.*;

public class Viewfile {

    public static void main(String[] args) {
        g().viewSvg();
    }

    public static Graph g() {
        Graph g = new Graph("Viewfile");
        g.addNodes(new Node().setStyle(Style.Node.filled), new Node("atoi")
                .setColor(Color.X11.green), new Node("chkmalloc")
                .setColor(Color.X11.green), new Node("close")
                .setColor(Color.X11.green), new Node("error")
                .setColor(Color.X11.blue), new Node("exit")
                .setColor(Color.X11.blue), new Node("fclose")
                .setColor(Color.X11.green), new Node("fgets")
                .setColor(Color.X11.red), new Node("fopen")
                .setColor(Color.X11.green), new Node("fprintf")
                .setColor(Color.X11.blue), new Node("free")
                .setColor(Color.X11.blue), new Node("free_list")
                .setColor(Color.X11.blue), new Node("fstat")
                .setColor(Color.X11.green), new Node("getopt")
                .setColor(Color.X11.green), new Node("init_list")
                .setColor(Color.X11.green), new Node("insert_list")
                .setColor(Color.X11.green), new Node("main")
                .setColor(Color.X11.green), new Node("makeargs")
                .setColor(Color.X11.blue), new Node("makepairs")
                .setColor(Color.X11.green), new Node("malloc")
                .setColor(Color.X11.green), new Node("open")
                .setColor(Color.X11.green), new Node("printf")
                .setColor(Color.X11.red), new Node("read")
                .setColor(Color.X11.green), new Node("rewind")
                .setColor(Color.X11.green), new Node("viewline")
                .setColor(Color.X11.green), new Node("viewlines")
                .setColor(Color.X11.green), new Node("walk_list")
                .setColor(Color.X11.green), new Node("write")
                .setColor(Color.X11.green));
        g.addEdges(
                new Edge("fclose", "close").setColor(Color.X11.green),
                new Edge("fgets", "fstat").setColor(Color.X11.green),
                new Edge("fgets", "read").setColor(Color.X11.green),
                new Edge("fopen", "open").setColor(Color.X11.green),
                new Edge("printf", "write").setColor(Color.X11.green),
                new Edge("main", "fgets").setColor(Color.X11.blue),
                new Edge("main", "getopt").setColor(Color.X11.green),
                new Edge("main", "makeargs").setColor(Color.X11.blue),
                new Edge("main", "makepairs").setColor(Color.X11.green),
                new Edge("main", "chkmalloc").setColor(Color.X11.green),
                new Edge("main", "error").setColor(Color.X11.blue),
                new Edge("main", "viewlines").setColor(Color.X11.green),
                new Edge("makeargs", "chkmalloc").setColor(Color.X11.blue),
                new Edge("makepairs", "atoi").setColor(Color.X11.green),
                new Edge("makepairs", "init_list").setColor(Color.X11.green),
                new Edge("makepairs", "insert_list")
                .setColor(Color.X11.green),
                new Edge("makepairs", "chkmalloc").setColor(Color.X11.green),
                new Edge("free_list", "free").setColor(Color.X11.blue),
                new Edge("init_list", "chkmalloc").setColor(Color.X11.green),
                new Edge("insert_list", "chkmalloc")
                .setColor(Color.X11.green),
                new Edge("walk_list", "error").setColor(Color.X11.blue),
                new Edge("walk_list", "viewline").setColor(Color.X11.green),
                new Edge("chkmalloc", "malloc").setColor(Color.X11.green),
                new Edge("chkmalloc", "error").setColor(Color.X11.blue),
                new Edge("error", "exit").setColor(Color.X11.blue),
                new Edge("error", "fprintf").setColor(Color.X11.blue),
                new Edge("error", "error").setColor(Color.X11.blue),
                new Edge("viewline", "fgets").setColor(Color.X11.red),
                new Edge("viewline", "printf").setColor(Color.X11.red),
                new Edge("viewline", "rewind").setColor(Color.X11.green),
                new Edge("viewlines", "fclose").setColor(Color.X11.green),
                new Edge("viewlines", "fopen").setColor(Color.X11.green),
                new Edge("viewlines", "walk_list").setColor(Color.X11.green),
                new Edge("viewlines", "viewline").setColor(Color.X11.blue));
        return g;
    }

}
