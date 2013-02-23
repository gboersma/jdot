package org.leadinglight.jdot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.leadinglight.jdot.impl.GraphElement;
import org.leadinglight.jdot.impl.Util;

/**
 * Graph structure to be laid out and drawn by Graphviz.
 */
public class Graph extends GraphElement {
	public enum Type {
		graph, digraph
	}

	public Graph() {
		_name = null;
		_type = Type.digraph;
		_strict = false;
		_nodes = new ArrayList<Node>();
		_edges = new ArrayList<Edge>();
	}
	
	public Graph setName(String name) {
		_name = name;
		return this;
	}
	
	public String getName() {
		return _name;
	}
	
	public Graph setType(Type type) {
		_type = type;
		return this;
	}
	
	public Type getType() {
		return _type;
	}
	
	public Graph setStrict(boolean strict) {
		_strict = strict;
		return this;
	}
	
	public boolean isStrict() {
		return _strict;
	}
	
	public Graph addNode(Node n) {
		n.setGraph(this);
		_nodes.add(n);
		return this;
	}
	
	public Graph addEdge(Edge e) {
		e.setGraph(this);
		_edges.add(e);
		return this;
	}
	
	public String toDot() {
		String dot = "";
		
		if(isStrict()) {
			dot = "strict ";
		}
		
		dot = dot + _type.name();
		
		if(_name != null && _name.length() > 0) {
			dot = dot + " " + _name;
		}
		
		dot = dot + " {\n";
		
		for (Node n : _nodes) {
			dot = dot + n.toDot();
		}
		
		for (Edge e: _edges) {
			dot = dot + e.toDot();
		}
		
		dot = dot + "}\n";
		return dot;
	}
	
	public void dot2svg() {
		try {
			File tfile = File.createTempFile("temp-file", ".svg");
			String svg = Util.sh("/usr/local/bin/dot -Tsvg", toDot());
			//System.out.println("SVG is " + svg);
			FileWriter w = new FileWriter(tfile);
			w.write(svg);
			w.flush();
			w.close();
			Util.sh(new String[]{"open", "-a", "Google Chrome.app", "file://" + tfile.toString()});
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String _name;
	private Type _type; 
	private List<Node> _nodes;
	private List<Edge> _edges;
	private boolean _strict;
} 
