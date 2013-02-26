package org.leadinglight.jdot;

import java.util.ArrayList;
import java.util.List;

import org.leadinglight.jdot.impl.GraphElement;

public class EdgeList extends GraphElement {
	public EdgeList(Graph graph) {
		_graph = graph;
		_edges = new ArrayList<Edge>();
	}
	
	public EdgeList addEdge(Edge e) {
		e.setGraph(_graph);
		_edges.add(e);
		return this;
	}
	
	public EdgeList addEdges(Edge ... edges) {
		for(Edge e: edges) {
			addEdge(e);
		}
		return this;
	}
	
	public String toDot() {
		String dot = "";
		
		if(getOptions().hasOptions()) {
			dot = getOptions().getOptionsAsString() + "\n";
		}

		for (Edge e : _edges) {
			dot = dot + e.toDot();
		}

		return dot;
	}

	private List<Edge> _edges;
	private Graph _graph;
}
