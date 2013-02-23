package org.leadinglight.jdot;

import org.leadinglight.jdot.impl.GraphElement;
import org.leadinglight.jdot.impl.Options;

public class Edge extends GraphElement {
	public enum Dir {
		back, forward, both
	}
	
	/**
	 * An Edge without a start or end is a style edge.
	 */
	public Edge() {
		_start = null;
		_end = null;
	}
	
	public Edge(Node start, Node end) {
		_start = start;
		_end = end;
	}
	
	public Edge(Graph graph, String startName, String endName) {
		_graph = graph;
		_start = graph.getNode(startName, true);
		_end = graph.getNode(endName, true);
	}
	
	public boolean isStyle() {
		return _start == null && _end == null;
	}
	
	public Node getStart() {
		return _start;
	}
	
	public Node getEnd() {
		return _end;
	}
	
	public String toDot() {
		String dot;

		if(isStyle()) {
			dot = "edge";
		} else {
			if(getGraph().getType() == Graph.Type.digraph) {
				dot = "\"" + _start.getName() + "\" -> \"" + _end.getName() + "\"";
			} else {
				dot = "\"" + _start.getName() + "\" -- \"" + _end.getName() + "\"";
			}
		}
			
		if(getOptions().hasOptions()) {
			dot = dot + " " + getOptions().getOptionsAsString() + ";\n";
		} else {
			dot = dot + ";\n";
		}

		return dot;
	}
	
	public Edge setGraph(Graph graph) {
		_graph = graph;
		return this;
	}
	
	public Graph getGraph() {
		return _graph;
	}
	
	public Edge setLabel(String label) {
		getOptions().setOption(Options.Key.label, label);
		return this;
	}
	
	/**
	 * Set the color of the node.
	 * @param color Name of the color as a string (http://www.graphviz.org/doc/info/colors.html).
	 */
	public Edge setColor(String color) {
		getOptions().setOption(Options.Key.color, color);
		return this;
	}
	
	public Edge setColor(Color.X11 color) {
		getOptions().setOption(Options.Key.color, color);
		return this;
	}

	public Edge setColor(Color.SVG color) {
		getOptions().setOption(Options.Key.color, color);
		return this;
	}
	
	public Edge setFontSize(String fontsize) {
		getOptions().setOption(Options.Key.fontsize, fontsize);
		return this;
	}
	
	public Edge setFontName(String fontname) {
		getOptions().setOption(Options.Key.fontname, fontname);
		return this;
	}

	public Edge setFontColor(String fontcolor) {
		getOptions().setOption(Options.Key.fontcolor, fontcolor);
		return this;
	}

	public Edge setFontColor(Color.X11 fontcolor) {
		getOptions().setOption(Options.Key.fontcolor, fontcolor);
		return this;
	}
	
	public Edge setFontColor(Color.SVG fontcolor) {
		getOptions().setOption(Options.Key.fontcolor, fontcolor);
		return this;
	}
	
	public Edge setDir(Dir dir) {
		getOptions().setOption(Options.Key.dir, dir);
		return this;
	}

	private Node _start;
	private Node _end;
	private Graph _graph;
}
