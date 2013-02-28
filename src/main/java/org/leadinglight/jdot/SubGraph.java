package org.leadinglight.jdot;

import org.leadinglight.jdot.enums.*;
import org.leadinglight.jdot.impl.*;

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
	
	public SubGraph addEdge(String name, String ... names) {
		super.addEdge(name, names);
		return this;
	}
	
	public SubGraph addEdges(Edge ... edges) {
		super.addEdges(edges);
		return this;
	}
	
	public SubGraph addSubGraph(SubGraph subGraph) {
		super.addGraph(subGraph);
		return this;
	}

	public SubGraph addClusterGraph(ClusterGraph clusterGraph) {
		super.addGraph(clusterGraph);
		return this;
	}

	public String toDot(boolean linefeed) {
		String dot = "";
		
		if(getName() != null && getName().length() > 0) {
			dot = dot + "subgraph " + getName() + " ";
		}
		
		dot = dot + "{" + (linefeed ? "\n" : " ");

		if(getAttrs().has()) {
			dot = dot + "graph [" + getAttrs().getAsString() + "]" + (linefeed ? "\n" : " ");
		}

		if(_rank != null) {
			dot = dot + "rank=" + _rank + (linefeed ? "\n" : " ");
		}
		for(AbstractElement e: getElements()) {
			dot = dot + e.toDot(linefeed); 
		}
		dot = dot + "}" + (linefeed ? "\n" : " ");
		return dot;
	}
	
	// Attrs
	
	private Rank _rank = null;
	
	public SubGraph setOrdering(Ordering ordering) {
		getAttrs().set(Attrs.Key.ordering, ordering);
		return this;
	}

	public SubGraph setRank(Rank rank) {
		_rank = rank;
		return this;
	}
}
