package org.leadinglight.jdot;

import org.leadinglight.jdot.impl.AbstractGraph;

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
		super.addGraph(subGraph);
		return this;
	}

	public SubGraph addClusterGraph(ClusterGraph clusterGraph) {
		super.addGraph(clusterGraph);
		return this;
	}

	public String toDot() {
		String dot = "subgraph ";
		
		if(getName() != null && getName().length() > 0) {
			dot = dot + getName();
		}
		
		dot = dot + super.toDot();
		return dot;
	}
}
