package org.leadinglight.jdot;

import org.leadinglight.jdot.impl.AbstractGraph;
import org.leadinglight.jdot.impl.Options;

public class SubGraph extends AbstractGraph {
	public SubGraph() {
		super();
	}
	
	public SubGraph(String name) {
		super(name);
	}
	
	public SubGraph addNode(Node n) {
		super.addNode(n);
		return this;
	}
	
	public SubGraph addNodes(Node ... nodes) {
		super.addNodes(nodes);
		return this;
	}
	
	public SubGraph addEdge(Edge e) {
		super.addEdge(e);
		return this;
	}
	
	public SubGraph addEdges(Edge ... edges) {
		super.addEdges(edges);
		return this;
	}
	
	public SubGraph addSubGraph(SubGraph subGraph) {
		super.addSubGraph(subGraph);
		return this;
	}

	public String toDot() {
		String dot = "subgraph ";
		
		if(getName() != null && getName().length() > 0) {
			dot = dot + " " + getName();
		}
		
		dot = dot + super.toDot();
		return dot;
	}
	
	// Options
	
	public enum Style {
		solid, dashed, dotted, bold, rounded, filled, striped, invis
	}
	
	public SubGraph setLabel(String label) {
		getOptions().setOption(Options.Key.label, label);
		return this;
	}
	
	public SubGraph setColor(String color) {
		getOptions().setOption(Options.Key.color, color);
		return this;
	}
	
	public SubGraph setColor(Color.X11 color) {
		getOptions().setOption(Options.Key.color, color);
		return this;
	}

	public SubGraph setColor(Color.SVG color) {
		getOptions().setOption(Options.Key.color, color);
		return this;
	}

	public SubGraph setStyle(Style style) {
		getOptions().setOption(Options.Key.style, style);
		return this;
	}
}
