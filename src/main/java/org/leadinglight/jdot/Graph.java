package org.leadinglight.jdot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Graph extends GraphElement {
	public Graph() {
		_name = null;
		_type = GraphType.digraph;
		_nodes = new ArrayList<Node>();
		_edges = new ArrayList<Edge>();
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}
	
	public void setType(GraphType type) {
		_type = type;
	}
	
	public GraphType getType() {
		return _type;
	}
	
	public void addNode(Node n) {
		n.setGraph(this);
		_nodes.add(n);
	}
	
	public void addEdge(Edge e) {
		e.setGraph(this);
		_edges.add(e);
	}
	
	public String toDot() {
		String dot = _type.name();
		
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
	private GraphType _type; 
	private List<Node> _nodes;
	private List<Edge> _edges;
} 
