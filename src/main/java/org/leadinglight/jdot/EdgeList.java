package org.leadinglight.jdot;

import java.util.ArrayList;
import java.util.List;

import org.leadinglight.jdot.impl.AbstractElement;
import org.leadinglight.jdot.impl.AbstractGraph;

public class EdgeList extends AbstractElement {
	public EdgeList(AbstractGraph graph) {
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
	
	public boolean isStyle() {
		return _edges.size() == 1 && _edges.get(0).isStyle();
	}
	
	public String toDot() {
		String dot = "";
		
		if(_rank != null) {
			dot = dot + "rank=" + _rank + "\n";
		}
		
		if(getOptions().hasOptions()) {
			dot = getOptions().getOptionsAsString() + "\n";
		}

		for (Edge e : _edges) {
			dot = dot + e.toDot();
		}

		return dot;
	}

	private List<Edge> _edges;
	private AbstractGraph _graph;
	private Rank _rank;

	// Options
	
	public enum Rank {
		same, min, source, max, sink
	}
	
	public EdgeList setRank(Rank rank) {
		_rank = rank;
		return this;
	}
}
