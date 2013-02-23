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
	
	public Node(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}
	
	public String toDot() {
		String dot = _name;
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

	private String _name;
	private Graph _graph;
}
