package org.leadinglight.jdot;

import org.leadinglight.jdot.impl.GraphElement;
import org.leadinglight.jdot.impl.Options;

public class Node extends GraphElement {
	public enum Shape {
		box, polygon, ellipse, oval, 
		circle, point, egg, triangle, 
		plaintext, diamond, trapezium, parallelogram,
		house, pentagon, hexagon, septagon,
		octagon, doublecircle, doubleoctagon, tripleoctagon, 
		invtriangle, invtrapezium, invhouse, Mdiamond,
		Msquare, Mcircle, rect, rectangle,
		square, none, note, tab,
		folder, box3d, component, promoter,
		cds, terminator, utr, primersite,
		restrictionsite, fivepoverhang, threepoverhang, noverhang,
		assembly, signature, insulator, ribosite,
		rnastab, proteasesite, proteinstab, rpromoter,
		rarrow, larrow, lpromoter,
		record, Mrecord
	}
	
	public enum Style {
		filled, invis
	}
	
	/**
	 * A Node without a name specified is a style node.
	 */
	public Node() {
		_name = "node";
	}
	
	public Node(String name) {
		_name = name;
	}
	
	public boolean isStyle() {
		return _name.equals("node");
	}
	
	public String getName() {
		return _name;
	}
	
	public String toDot() {
		String dot = "";
		
		if (!isStyle()) {
			dot = "\"" + _name + "\"";
		} else {
			dot = _name; 
		}
		
		if(getOptions().hasOptions()) {
			dot = dot + " " + getOptions().getOptionsAsString() + ";\n";
		} else {
			dot = dot + ";\n";
		}
		
		return dot;
	}
	
	public Node setGraph(Graph graph) {
		_graph = graph;
		return this;
	}
	
	public Graph getGraph() {
		return _graph;
	}

	public Node setLabel(String label) {
		getOptions().setOption(Options.Key.label, label);
		return this;
	}
	
	/**
	 * Set the color of the node.
	 * @param color Name of the color as a string (http://www.graphviz.org/doc/info/colors.html).
	 */
	public Node setColor(String color) {
		getOptions().setOption(Options.Key.color, color);
		return this;
	}
	
	public Node setColor(Color.X11 color) {
		getOptions().setOption(Options.Key.color, color);
		return this;
	}

	public Node setColor(Color.SVG color) {
		getOptions().setOption(Options.Key.color, color);
		return this;
	}
	
	public Node setShape(Shape shape) {
		getOptions().setOption(Options.Key.shape, shape);
		return this;
	}
	
	public Node setStyle(Style style) {
		getOptions().setOption(Options.Key.style, style);
		return this;
	}
	
	public Node setFontSize(String fontsize) {
		getOptions().setOption(Options.Key.fontsize, fontsize);
		return this;
	}
	
	public Node setFontName(String fontname) {
		getOptions().setOption(Options.Key.fontname, fontname);
		return this;
	}

	public Node setFontColor(String fontcolor) {
		getOptions().setOption(Options.Key.fontcolor, fontcolor);
		return this;
	}

	public Node setFontColor(Color.X11 fontcolor) {
		getOptions().setOption(Options.Key.fontcolor, fontcolor);
		return this;
	}
	
	public Node setFontColor(Color.SVG fontcolor) {
		getOptions().setOption(Options.Key.fontcolor, fontcolor);
		return this;
	}

	public Node setWidth(String width) {
		getOptions().setOption(Options.Key.width, width);
		return this;
	}

	private String _name;
	private Graph _graph;
}
