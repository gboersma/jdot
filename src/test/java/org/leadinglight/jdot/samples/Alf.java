package org.leadinglight.jdot.samples;

import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.Graph;
import org.leadinglight.jdot.Node;
import org.leadinglight.jdot.Node.Shape;

public class Alf {
	public static void main(String[] args) {
		Graph g = g();
		System.out.println(g.toDot());
		g.dot2svg();
	}

	public static Graph g() {
		Graph g = new Graph("Alf").setSize("6,9");
		g.addNode(new Node().setShape(Shape.record));
		g.addNodes(
				new Node("Decl")
						.setLabel("\n\nDecl|{name|access|decl_flags|extern_c_linkage}"),
				new Node("Nontype_decl").setLabel("Nontype_decl|{type}"),
				new Node("Defined_decl").setLabel("Defined_decl|{linkage}"),
				new Node("Data_decl").setLabel("Data_decl|{storage_class}"),
				new Node("Function_decl")
						.setLabel("Function_decl|{formals|defaults}"),
				new Node("Data").setLabel("Data|{initializer}"), new Node(
						"Function").setLabel("Function|{body}"), new Node(
						"Constructor")
						.setLabel("Constructor|{member_initializers}"));
		g.addEdges(new Edge(g, "Aggregate", "Type_decl"), new Edge(g, "Class",
				"Aggregate"), new Edge(g, "Union", "Aggregate"), new Edge(g,
				"Data", "Data_decl"), new Edge(g, "Data", "Defn"), new Edge(g,
				"Data_decl", "Defined_decl"), new Edge(g, "Data_member",
				"Nontype_decl"), new Edge(g, "Defined_decl", "Nontype_decl"),
				new Edge(g, "Defn", "Defined_decl"), new Edge(g, "Enum",
						"Type_decl"),
				new Edge(g, "Enumerator", "Nontype_decl"), new Edge(g,
						"Function", "Defn"), new Edge(g, "Function",
						"Function_decl"),
				new Edge(g, "Constructor", "Function"), new Edge(g,
						"Destructor", "Function"), new Edge(g, "Function_decl",
						"Defined_decl"), new Edge(g, "Nontype_decl", "Decl"),
				new Edge(g, "Template_type_arg", "Type_decl"), new Edge(g,
						"Type_decl", "Decl"), new Edge(g, "Typedef",
						"Type_decl"));
		return g;
	}
}
