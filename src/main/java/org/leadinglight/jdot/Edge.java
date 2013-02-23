package org.leadinglight.jdot;

import org.leadinglight.jdot.impl.GraphElement;
import org.leadinglight.jdot.impl.Options;

public class Edge extends GraphElement {
	public Edge(Node start, Node end) {
		_start = start;
		_end = end;
	}
	
	public Node getStart() {
		return _start;
	}
	
	public Node getEnd() {
		return _end;
	}
	
	public String toDot() {
		String dot;

		if(getGraph().getType() == Graph.Type.digraph) {
			dot = _start.getName() + " -> " + _end.getName();
		} else {
			dot = _start.getName() + " -- " + _end.getName();
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
		// TODO Specify color as an enum. 
		// Tricky because there are so many different ones that depend on different color schemes.
		getOptions().setOption(Options.Key.color, color);
		return this;
	}
	
	private Node _start;
	private Node _end;
	private Graph _graph;
}
