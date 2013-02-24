package org.leadinglight.jdot;

import org.leadinglight.jdot.Node.Shape;

public class GraphTest {
	public static void main(String[] args) {
		GraphTest gt = new GraphTest();
//		Graph g = gt.simpleDirectedGraph();
//		Graph g = gt.directedGraph();
//		Graph g = gt.undirectedGraph();
//		Graph g = gt.viewfile();
//		Graph g = gt.grammar();
//		Graph g = gt.pmpipe();
//		Graph g = gt.abstractGraph();
		Graph g = gt.alf();
		System.out.println(g.toDot());
		g.dot2svg();
	}
	
	public Graph simpleDirectedGraph() {
		Graph g = new Graph();
		Node n1 = new Node("1");
		Node n2 = new Node("2");
		Node n3 = new Node("3");
		Edge e1 = new Edge(n1, n2);
		Edge e2 = new Edge(n1, n3);
		Edge e3 = new Edge(n2, n3);
		g.addNodes(n1, n2, n3).addEdges(e1, e2, e3);
		return g;
	}
	
	public Graph directedGraph() {
		Graph g = new Graph().setName("sample1").setType(Graph.Type.digraph);
		Node n1 = new Node("1").setLabel("Node 1").setColor(Color.X11.green).setShape(Node.Shape.square);
		Node n2 = new Node("2").setLabel("Node 2").setColor(Color.X11.purple).setShape(Node.Shape.circle);
		Node n3 = new Node("3").setLabel("Node 3").setColor(Color.X11.blue).setShape(Node.Shape.triangle);
		Edge e1 = new Edge(n1, n2).setColor(Color.X11.red);
		Edge e2 = new Edge(n1, n3).setLabel("This is an edge.").setColor(Color.X11.green);
		Edge e3 = new Edge(n2, n3).setColor(Color.X11.yellow);
		g.addNodes(n1, n2, n3).addEdges(e1, e2, e3);
		return g;
	}
	
	public Graph undirectedGraph() {
		Graph g = new Graph().setName("sample1").setType(Graph.Type.graph);
		Node n1 = new Node("1").setLabel("Node 1").setColor(Color.X11.green).setShape(Node.Shape.square);
		Node n2 = new Node("2").setLabel("Node 2").setColor(Color.X11.purple).setShape(Node.Shape.circle);
		Node n3 = new Node("3").setLabel("Node 3").setColor(Color.X11.blue).setShape(Node.Shape.triangle);
		Edge e1 = new Edge(n1, n2).setColor(Color.X11.red);
		Edge e2 = new Edge(n1, n3).setLabel("This is an edge.").setColor(Color.X11.green);
		Edge e3 = new Edge(n2, n3).setColor(Color.X11.yellow);
		g.addNodes(n1, n2, n3).addEdges(e1, e2, e3);
		return g;
	}
	
	// These duplicate the samples provided with Graphviz.
	
	public Graph viewfile() {
		Graph g = new Graph("Viewfile");
		g.addNodes(
				new Node().setStyle(Node.Style.filled),
				new Node("atoi").setColor(Color.X11.green),
				new Node("chkmalloc").setColor(Color.X11.green),
				new Node("close").setColor(Color.X11.green),
				new Node("error").setColor(Color.X11.blue),
				new Node("exit").setColor(Color.X11.blue),
				new Node("fclose").setColor(Color.X11.green),
				new Node("fgets").setColor(Color.X11.red),
				new Node("fopen").setColor(Color.X11.green),
				new Node("fprintf").setColor(Color.X11.blue),
				new Node("free").setColor(Color.X11.blue),
				new Node("free_list").setColor(Color.X11.blue),
				new Node("fstat").setColor(Color.X11.green),
				new Node("getopt").setColor(Color.X11.green),
				new Node("init_list").setColor(Color.X11.green),
				new Node("insert_list").setColor(Color.X11.green),
				new Node("main").setColor(Color.X11.green),
				new Node("makeargs").setColor(Color.X11.blue),
				new Node("makepairs").setColor(Color.X11.green),
				new Node("malloc").setColor(Color.X11.green),
				new Node("open").setColor(Color.X11.green),
				new Node("printf").setColor(Color.X11.red),
				new Node("read").setColor(Color.X11.green),
				new Node("rewind").setColor(Color.X11.green),
				new Node("viewline").setColor(Color.X11.green),
				new Node("viewlines").setColor(Color.X11.green),
				new Node("walk_list").setColor(Color.X11.green),
				new Node("write").setColor(Color.X11.green));
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
				new Edge(g, "makepairs", "insert_list").setColor(Color.X11.green),
				new Edge(g, "makepairs", "chkmalloc").setColor(Color.X11.green),
				new Edge(g, "free_list", "free").setColor(Color.X11.blue),
				new Edge(g, "init_list", "chkmalloc").setColor(Color.X11.green),
				new Edge(g, "insert_list", "chkmalloc").setColor(Color.X11.green),
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
	
	public Graph grammar() {
		Graph g = new Graph("L0").setSize("8,8").setOrdering(Graph.Ordering.out);
		g.addNode(new Node().setShape(Shape.box));
		g.addNodes(
				new Node("n0").setLabel("E"),
				new Node("n1").setLabel("T"),
				new Node("n2").setLabel("F"),
				new Node("n3").setLabel("IDENT : a "),
				new Node("n4").setLabel("+"),
				new Node("n5").setLabel("T"),
				new Node("n6").setLabel("F"),
				new Node("n7").setLabel("("),
				new Node("n8").setLabel("E"),
				new Node("n9").setLabel("T"),
				new Node("n10").setLabel("F"),
				new Node("n11").setLabel("IDENT : b "),
				new Node("n12").setLabel("*"),
				new Node("n13").setLabel("F"),
				new Node("n14").setLabel("IDENT : c "),
				new Node("n15").setLabel(")"),
				new Node("n16").setLabel("*"),
				new Node("n17").setLabel("F"),
				new Node("n18").setLabel("("),
				new Node("n19").setLabel("E"),
				new Node("n20").setLabel("T"),
				new Node("n21").setLabel("F"),
				new Node("n22").setLabel("IDENT : d "),
				new Node("n23").setLabel("*"),
				new Node("n24").setLabel("F"),
				new Node("n25").setLabel("IDENT : e "),
				new Node("n26").setLabel("+"),
				new Node("n27").setLabel("T"),
				new Node("n28").setLabel("F"),
				new Node("n29").setLabel("("),
				new Node("n30").setLabel("E"),
				new Node("n31").setLabel("T"),
				new Node("n32").setLabel("F"),
				new Node("n33").setLabel("IDENT : a "),
				new Node("n34").setLabel("*"),
				new Node("n35").setLabel("F"),
				new Node("n36").setLabel("IDENT : b "),
				new Node("n37").setLabel(")"),
				new Node("n38").setLabel(")"),
				new Node("n39").setLabel("+"),
				new Node("n40").setLabel("T"),
				new Node("n41").setLabel("F"),
				new Node("n42").setLabel("IDENT : q "));
		g.addEdges(
				new Edge(g, "n0", "n1"),
				new Edge(g, "n0", "n4"),
				new Edge(g, "n0", "n5"),
				new Edge(g, "n0", "n39"),
				new Edge(g, "n0", "n40"),
				new Edge(g, "n1", "n2"),
				new Edge(g, "n2", "n3"),
				new Edge(g, "n5", "n6"),
				new Edge(g, "n5", "n16"),
				new Edge(g, "n5", "n17"),
				new Edge(g, "n6", "n7"),
				new Edge(g, "n6", "n8"),
				new Edge(g, "n6", "n15"),
				new Edge(g, "n8", "n9"),
				new Edge(g, "n9", "n10"),
				new Edge(g, "n9", "n12"),
				new Edge(g, "n9", "n13"),
				new Edge(g, "n10", "n11"),
				new Edge(g, "n13", "n14"),
				new Edge(g, "n17", "n18"),
				new Edge(g, "n17", "n19"),
				new Edge(g, "n17", "n38"),
				new Edge(g, "n19", "n20"),
				new Edge(g, "n19", "n26"),
				new Edge(g, "n19", "n27"),
				new Edge(g, "n20", "n21"),
				new Edge(g, "n20", "n23"),
				new Edge(g, "n20", "n24"),
				new Edge(g, "n21", "n22"),
				new Edge(g, "n24", "n25"),
				new Edge(g, "n27", "n28"),
				new Edge(g, "n28", "n29"),
				new Edge(g, "n28", "n30"),
				new Edge(g, "n28", "n37"),
				new Edge(g, "n30", "n31"),
				new Edge(g, "n31", "n32"),
				new Edge(g, "n31", "n34"),
				new Edge(g, "n31", "n35"),
				new Edge(g, "n32", "n33"),
				new Edge(g, "n35", "n36"),
				new Edge(g, "n40", "n41"),
				new Edge(g, "n41", "n42"));
		return g;
	}
	
	public Graph pmpipe() {
		Graph g = new Graph("g");
		// Style node
		g.addNode(new Node().setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).
				setShape(Shape.box).setColor(Color.X11.black).setWidth("0.5"));
		// Style edge
		g.addEdge(new Edge().setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).
				setColor(Color.X11.black));
		// Nodes
		g.addNodes(
				new Node("23296").setLabel("23296\n?"),
				new Node("182948-1").setLabel("182948-1\n182949-1\npipe").setFontSize("7").setShape(Shape.doublecircle),
				new Node("23310").setLabel("23310\ncat"),
				new Node("182950-1").setLabel("182950-1\n182951-1\npipe").setFontSize("7").setShape(Shape.doublecircle),
				new Node("23311").setLabel("23311\ncat"),
				new Node("182952-1").setLabel("182952-1\n182953-1\npipe").setFontSize("7").setShape(Shape.doublecircle),
				new Node("23312").setLabel("23312\ncat"),
				new Node("182954-1").setLabel("182954-1\n182955-1\npipe").setFontSize("7").setShape(Shape.doublecircle),
				new Node("23313").setLabel("23313\ncat"),
				new Node("79893+2568").setLabel("79893+2568\n/usr/share/lib/termcap").setShape(Shape.ellipse),
				new Node("85+2560").setLabel("85+2560\n?").setShape(Shape.ellipse),
				new Node("23314").setLabel("23314\ncat"),
				new Node("4151865284+0").setLabel("4151865284+0\n/tmp/termcap").setShape(Shape.ellipse));
		g.addEdges(
				new Edge(g, "23296", "23310").setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).setColor(Color.X11.black),
				new Edge(g, "23296", "23311").setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).setColor(Color.X11.black),
				new Edge(g, "23311", "182948-1").setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).setColor(Color.X11.black).setDir(Edge.Dir.back),
				new Edge(g, "23310", "182948-1").setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).setColor(Color.X11.black).setDir(Edge.Dir.forward),
				new Edge(g, "23296", "23312").setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).setColor(Color.X11.black),
				new Edge(g, "23312", "182952-1").setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).setColor(Color.X11.black).setDir(Edge.Dir.forward),
				new Edge(g, "23312", "182950-1").setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).setColor(Color.X11.black).setDir(Edge.Dir.back),
				new Edge(g, "23296", "23313").setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).setColor(Color.X11.black),
				new Edge(g, "23313", "182954-1").setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).setColor(Color.X11.black).setDir(Edge.Dir.forward),
				new Edge(g, "23311", "182950-1").setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).setColor(Color.X11.black).setDir(Edge.Dir.forward),
				new Edge(g, "23310", "79893+2568").setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).setColor(Color.X11.black).setDir(Edge.Dir.back),
				new Edge(g, "23296", "85+2560").setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).setColor(Color.X11.black).setDir(Edge.Dir.both),
				new Edge(g, "23296", "23314").setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).setColor(Color.X11.black),
				new Edge(g, "23314", "85+2560").setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).setColor(Color.X11.black).setDir(Edge.Dir.both),
				new Edge(g, "23314", "182954-1").setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).setColor(Color.X11.black).setDir(Edge.Dir.back),
				new Edge(g, "23296", "85+2560").setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).setColor(Color.X11.black).setDir(Edge.Dir.both),
				new Edge(g, "23314", "4151865284+0").setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).setColor(Color.X11.black).setDir(Edge.Dir.forward),
				new Edge(g, "23313", "182952-1").setFontSize("14").setFontName("Times-Roman").setFontColor(Color.X11.black).setColor(Color.X11.black).setDir(Edge.Dir.back));
		return g;
	}
	
	public Graph abstractGraph() {
		Graph g = new Graph("abstract").setSize("6,6");
		g.addEdges(
				new Edge(g, "S24", "27"),
				new Edge(g, "S24", "25"),
				new Edge(g, "S1", "10"),
				new Edge(g, "S1", "2"),
				new Edge(g, "S35", "36"),
				new Edge(g, "S35", "43"),
				new Edge(g, "S30", "31"),
				new Edge(g, "S30", "33"),
				new Edge(g, "9", "42"),
				new Edge(g, "9", "T1"),
				new Edge(g, "25", "T1"),
				new Edge(g, "25", "26"),
				new Edge(g, "27", "T24"),
				new Edge(g, "2", "3"),
				new Edge(g, "2", "16"),
				new Edge(g, "2", "17"),
				new Edge(g, "2", "T1"),
				new Edge(g, "2", "18"),
				new Edge(g, "10", "11"),
				new Edge(g, "10", "14"),
				new Edge(g, "10", "T1"),
				new Edge(g, "10", "13"),
				new Edge(g, "10", "12"),
				new Edge(g, "31", "T1"),
				new Edge(g, "31", "32"),
				new Edge(g, "33", "T30"),
				new Edge(g, "33", "34"),
				new Edge(g, "42", "4"),
				new Edge(g, "26", "4"),
				new Edge(g, "3", "4"),
				new Edge(g, "16", "15"),
				new Edge(g, "17", "19"),
				new Edge(g, "18", "29"),
				new Edge(g, "11", "4"),
				new Edge(g, "14", "15"),
				new Edge(g, "37", "39"),
				new Edge(g, "37", "41"),
				new Edge(g, "37", "38"),
				new Edge(g, "37", "40"),
				new Edge(g, "13", "19"),
				new Edge(g, "12", "29"),
				new Edge(g, "43", "38"),
				new Edge(g, "43", "40"),
				new Edge(g, "36", "19"),
				new Edge(g, "32", "23"),
				new Edge(g, "34", "29"),
				new Edge(g, "39", "15"),
				new Edge(g, "41", "29"),
				new Edge(g, "38", "4"),
				new Edge(g, "40", "19"),
				new Edge(g, "4", "5"),
				new Edge(g, "19", "21"),
				new Edge(g, "19", "20"),
				new Edge(g, "19", "28"),
				new Edge(g, "5", "6"),
				new Edge(g, "5", "T35"),
				new Edge(g, "5", "23"),
				new Edge(g, "21", "22"),
				new Edge(g, "20", "15"),
				new Edge(g, "28", "29"),
				new Edge(g, "6", "7"),
				new Edge(g, "15", "T1"),
				new Edge(g, "22", "23"),
				new Edge(g, "22", "T35"),
				new Edge(g, "29", "T30"),
				new Edge(g, "7", "T8"),
				new Edge(g, "23", "T24"),
				new Edge(g, "23", "T1"));
		return g;
	}
	
	public Graph alf() {
		Graph g = new Graph("Alf").setSize("6,9");
		g.addNode(new Node().setShape(Shape.record));
		g.addNodes(
				new Node("Decl").setLabel("\n\nDecl|{name|access|decl_flags|extern_c_linkage}"),
				new Node("Nontype_decl").setLabel("Nontype_decl|{type}"),
				new Node("Defined_decl").setLabel("Defined_decl|{linkage}"),
				new Node("Data_decl").setLabel("Data_decl|{storage_class}"),
				new Node("Function_decl").setLabel("Function_decl|{formals|defaults}"),
				new Node("Data").setLabel("Data|{initializer}"),
				new Node("Function").setLabel("Function|{body}"),
				new Node("Constructor").setLabel("Constructor|{member_initializers}"));
		g.addEdges(
				new Edge(g, "Aggregate", "Type_decl"),
				new Edge(g, "Class", "Aggregate"),
				new Edge(g, "Union", "Aggregate"),
				new Edge(g, "Data", "Data_decl"),
				new Edge(g, "Data", "Defn"),
				new Edge(g, "Data_decl", "Defined_decl"),
				new Edge(g, "Data_member", "Nontype_decl"),
				new Edge(g, "Defined_decl", "Nontype_decl"),
				new Edge(g, "Defn", "Defined_decl"),
				new Edge(g, "Enum", "Type_decl"),
				new Edge(g, "Enumerator", "Nontype_decl"),
				new Edge(g, "Function", "Defn"),
				new Edge(g, "Function", "Function_decl"),
				new Edge(g, "Constructor", "Function"),
				new Edge(g, "Destructor", "Function"),
				new Edge(g, "Function_decl", "Defined_decl"),
				new Edge(g, "Nontype_decl", "Decl"),
				new Edge(g, "Template_type_arg", "Type_decl"),
				new Edge(g, "Type_decl", "Decl"),
				new Edge(g, "Typedef", "Type_decl"));
		return g;
	}
}
