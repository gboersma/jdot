package org.leadinglight.jdot.impl;

import java.util.ArrayList;
import java.util.List;

import org.leadinglight.jdot.*;

public abstract class AbstractGraph extends AbstractElement {
	public AbstractGraph() {
		_name = null;
		_elements = new ArrayList<AbstractElement>();
	}
	
	public AbstractGraph(String name) {
		_name = name;
		_elements = new ArrayList<AbstractElement>();
	}
	
	public String getName() {
		return _name;
	}
	
	public List<AbstractElement> getElements() {
		return _elements;
	}
	
	public AbstractGraph addNode(Node n) {
		_elements.add(n);
		return this;
	}
	
	public AbstractGraph addNodes(Node ... nodes) {
		for (Node n : nodes) {
			addNode(n);
		}
		return this;
	}
	
	public Node getNode(String name) {
		return getNode(name, false);
	}
	
	public Node getNode(String name, boolean create) {
		for(AbstractElement e : _elements) {
			if(e instanceof Node && ((Node)e).getName().equals(name)) {
				return (Node)e;
			}
			if(e instanceof AbstractGraph) {
				Node n = ((AbstractGraph)e).getNodeOrNull(name);
				if(n != null) {
					return n;
				}
			}
		}
		
		if(create) {
			Node n = new Node(name);
			addNode(n);
			return n;
		} else {
			throw new RuntimeException("Node " + name + " not found.");
		}
	}
	
	private Node getNodeOrNull(String name) {
		for(AbstractElement e : _elements) {
			if(e instanceof Node && ((Node)e).getName().equals(name)) {
				return (Node)e;
			}
			if(e instanceof AbstractGraph) {
				Node n = ((AbstractGraph)e).getNodeOrNull(name);
				if(n != null) {
					return n;
				}
			}
		}
		return null;
	}
	
	public AbstractGraph addEdge(Edge e) {
		_elements.add(e.setGraph(this));
		return this;
	}
	
	public AbstractGraph addEdge(String name, String ... names) {
		addEdge(new Edge(name, names).setGraph(this));
		return this;
	}
	
	public AbstractGraph addEdges(Edge ... edges) {
		for(Edge e: edges) {
			addEdge(e);
		}
		return this;
	}
	
	public AbstractGraph addGraph(AbstractGraph graph) {
		_elements.add(graph);
		return this;
	}
	
	private List<AbstractElement> _elements;
	private String _name;
}
