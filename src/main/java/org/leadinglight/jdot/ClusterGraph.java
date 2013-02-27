package org.leadinglight.jdot;

import org.leadinglight.jdot.impl.AbstractGraph;
import org.leadinglight.jdot.impl.Options;

public class ClusterGraph extends AbstractGraph {
	public ClusterGraph() {
		super();
	}
	
	public ClusterGraph(String name) {
		super(name);
	}
	
	public ClusterGraph addNode(Node n) {
		super.addNode(n);
		return this;
	}
	
	public ClusterGraph addNodes(Node ... nodes) {
		super.addNodes(nodes);
		return this;
	}
	
	public ClusterGraph addEdge(Edge e) {
		super.addEdge(e);
		return this;
	}
	
	public ClusterGraph addEdges(Edge ... edges) {
		super.addEdges(edges);
		return this;
	}
	
	public ClusterGraph addSubGraph(SubGraph subGraph) {
		super.addGraph(subGraph);
		return this;
	}
	
	public ClusterGraph addClusterGraph(ClusterGraph clusterGraph) {
		super.addGraph(clusterGraph);
		return this;
	}

	public String toDot() {
		String dot = "subgraph ";
		
		if(getName() != null && getName().length() > 0) {
			if(!getName().startsWith("cluster")) {
				dot = dot + "cluster" + getName();
			} else {
				dot = dot + getName();
			}
		}
		
		dot = dot + super.toDot();
		return dot;
	}
	
	// Options
	
	public enum Style {
		solid, dashed, dotted, bold, rounded, filled, striped, invis
	}
	
	public ClusterGraph setLabel(String label) {
		getOptions().setOption(Options.Key.label, label);
		return this;
	}
	
	public ClusterGraph setColor(String color) {
		getOptions().setOption(Options.Key.color, color);
		return this;
	}
	
	public ClusterGraph setColor(Color.X11 color) {
		getOptions().setOption(Options.Key.color, color);
		return this;
	}

	public ClusterGraph setColor(Color.SVG color) {
		getOptions().setOption(Options.Key.color, color);
		return this;
	}

	public ClusterGraph setStyle(Style style) {
		getOptions().setOption(Options.Key.style, style);
		return this;
	}
}
