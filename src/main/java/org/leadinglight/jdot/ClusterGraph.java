package org.leadinglight.jdot;

import org.leadinglight.jdot.enums.*;
import org.leadinglight.jdot.impl.*;

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
	
	public ClusterGraph addEdge(String name, String ... names) {
		super.addEdge(name, names);
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
		String dot = "subgraph";
		
		if(getName() != null && getName().length() > 0) {
			if(!getName().startsWith("cluster")) {
				dot = dot + " cluster" + getName();
			} else {
				dot = dot + " " + getName();
			}
		}
		
		dot = dot + " {\n";
		if(getAttrs().has()) {
			dot = dot + "graph [" + getAttrs().getAsString() + "]\n";
		}
		for(AbstractElement e: getElements()) {
			dot = dot + e.toDot(); 
		}
		dot = dot + "}\n";
		return dot;
	}
	
	// Attrs
	
	public ClusterGraph setLabel(String label) {
		getAttrs().set(Attrs.Key.label, label);
		return this;
	}
	
	public ClusterGraph setColor(String color) {
		getAttrs().set(Attrs.Key.color, color);
		return this;
	}
	
	public ClusterGraph setColor(Color.X11 color) {
		getAttrs().set(Attrs.Key.color, color);
		return this;
	}

	public ClusterGraph setColor(Color.SVG color) {
		getAttrs().set(Attrs.Key.color, color);
		return this;
	}

	public ClusterGraph setStyle(Style.ClusterGraph style) {
		getAttrs().set(Attrs.Key.style, style);
		return this;
	}
}
