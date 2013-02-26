package org.leadinglight.jdot;

import java.util.ArrayList;
import java.util.List;

import org.leadinglight.jdot.impl.AbstractElement;
import org.leadinglight.jdot.impl.AbstractGraph;

public class NodeList extends AbstractElement {
	public NodeList(AbstractGraph graph) {
		_graph = graph;
		_nodes = new ArrayList<Node>();
	}
	
	public NodeList addNode(Node n) {
		n.setGraph(_graph);
		_nodes.add(n);
		return this;
	}
	
	public NodeList addNodes(Node ... nodes) {
		for (Node n : nodes) {
			addNode(n);
		}
		return this;
	}
	
	public Node getNode(String name) {
		for(Node n : _nodes) {
			if(n.getName().equals(name)) {
				return n;
			}
		}
		return null;
	}
	
	public boolean isStyle() {
		return _nodes.size() == 1 && _nodes.get(0).isStyle();
	}
	
	public String toDot() {
		String dot = "";
		
		if(_rank != null) {
			dot = dot + "rank=" + _rank + "\n";
		}

		if(_ordering != null) {
			dot = dot + "ordering=" + _ordering + "\n";
		}

		if(getOptions().hasOptions()) {
			dot = getOptions().getOptionsAsString() + "\n";
		}

		for (Node n : _nodes) {
			dot = dot + n.toDot();
		}
		return dot;
	}
	
	// Options
	
	public enum Rank {
		same, min, source, max, sink
	}

	public enum Ordering {
		in, out
	}
	
	public NodeList setRank(Rank rank) {
		_rank = rank;
		return this;
	}
	
	public NodeList setOrdering(Ordering ordering) {
		_ordering = ordering;
		return this;
	}
	
	private List<Node> _nodes;
	private AbstractGraph _graph;
	private Rank _rank;
	private Ordering _ordering;
}
