package info.leadinglight.jdot.samples;

import info.leadinglight.jdot.*;
import info.leadinglight.jdot.enums.*;

public class Alf {

    public static void main(String[] args) {
        g().viewSvg();
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
        g.addEdges(new Edge("Aggregate", "Type_decl"), new Edge("Class",
                "Aggregate"), new Edge("Union", "Aggregate"), new Edge(
                        "Data", "Data_decl"), new Edge("Data", "Defn"), new Edge(
                        "Data_decl", "Defined_decl"), new Edge("Data_member",
                        "Nontype_decl"), new Edge("Defined_decl", "Nontype_decl"),
                new Edge("Defn", "Defined_decl"), new Edge("Enum",
                        "Type_decl"),
                new Edge("Enumerator", "Nontype_decl"), new Edge(
                        "Function", "Defn"), new Edge("Function",
                        "Function_decl"),
                new Edge("Constructor", "Function"), new Edge(
                        "Destructor", "Function"), new Edge("Function_decl",
                        "Defined_decl"), new Edge("Nontype_decl", "Decl"),
                new Edge("Template_type_arg", "Type_decl"), new Edge(
                        "Type_decl", "Decl"), new Edge("Typedef",
                        "Type_decl"));
        return g;
    }
}
