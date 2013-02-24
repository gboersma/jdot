package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.Color;
import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;
import org.leadinglight.jdot.Node;

public class Viewfile {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}
	public static Graph g() {
		Graph g = new Graph("Viewfile");
		g.addNodes(new Node().setStyle(Node.Style.filled), new Node("atoi")
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
				new Edge(g, "fclose", "close").setColor(Color.X11.green),
				new Edge(g, "fgets", "fstat").setColor(Color.X11.green),
				new Edge(g, "fgets", "read").setColor(Color.X11.green),
				new Edge(g, "fopen", "open").setColor(Color.X11.green),
				new Edge(g, "printf", "write").setColor(Color.X11.green),
				new Edge(g, "main", "fgets").setColor(Color.X11.blue),
				new Edge(g, "main", "getopt").setColor(Color.X11.green),
				new Edge(g, "main", "makeargs").setColor(Color.X11.blue),
				new Edge(g, "main", "makepairs").setColor(Color.X11.green),
				new Edge(g, "main", "chkmalloc").setColor(Color.X11.green),
				new Edge(g, "main", "error").setColor(Color.X11.blue),
				new Edge(g, "main", "viewlines").setColor(Color.X11.green),
				new Edge(g, "makeargs", "chkmalloc").setColor(Color.X11.blue),
				new Edge(g, "makepairs", "atoi").setColor(Color.X11.green),
				new Edge(g, "makepairs", "init_list").setColor(Color.X11.green),
				new Edge(g, "makepairs", "insert_list")
						.setColor(Color.X11.green),
				new Edge(g, "makepairs", "chkmalloc").setColor(Color.X11.green),
				new Edge(g, "free_list", "free").setColor(Color.X11.blue),
				new Edge(g, "init_list", "chkmalloc").setColor(Color.X11.green),
				new Edge(g, "insert_list", "chkmalloc")
						.setColor(Color.X11.green),
				new Edge(g, "walk_list", "error").setColor(Color.X11.blue),
				new Edge(g, "walk_list", "viewline").setColor(Color.X11.green),
				new Edge(g, "chkmalloc", "malloc").setColor(Color.X11.green),
				new Edge(g, "chkmalloc", "error").setColor(Color.X11.blue),
				new Edge(g, "error", "exit").setColor(Color.X11.blue),
				new Edge(g, "error", "fprintf").setColor(Color.X11.blue),
				new Edge(g, "error", "error").setColor(Color.X11.blue),
				new Edge(g, "viewline", "fgets").setColor(Color.X11.red),
				new Edge(g, "viewline", "printf").setColor(Color.X11.red),
				new Edge(g, "viewline", "rewind").setColor(Color.X11.green),
				new Edge(g, "viewlines", "fclose").setColor(Color.X11.green),
				new Edge(g, "viewlines", "fopen").setColor(Color.X11.green),
				new Edge(g, "viewlines", "walk_list").setColor(Color.X11.green),
				new Edge(g, "viewlines", "viewline").setColor(Color.X11.blue));
		return g;
	}

}
