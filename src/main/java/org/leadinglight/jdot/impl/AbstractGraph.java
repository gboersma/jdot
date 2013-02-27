package org.leadinglight.jdot.impl;

import java.util.ArrayList;
import java.util.List;

import org.leadinglight.jdot.Edge;
import org.leadinglight.jdot.EdgeList;
import org.leadinglight.jdot.Node;
import org.leadinglight.jdot.NodeList;
import org.leadinglight.jdot.SubGraph;

public abstract class AbstractGraph extends AbstractElement {
	public AbstractGraph() {
		_name = null;
		_nodeLists = new ArrayList<NodeList>();
		_nodeLists.add(new NodeList(this));
		_edgeLists = new ArrayList<EdgeList>();
		_edgeLists.add(new EdgeList(this));
		_subGraphs = new ArrayList<SubGraph>();
	}
	
	public AbstractGraph(String name) {
		_name = name;
		_nodeLists = new ArrayList<NodeList>();
		_nodeLists.add(new NodeList(this));
		_edgeLists = new ArrayList<EdgeList>();
		_edgeLists.add(new EdgeList(this));
		_subGraphs = new ArrayList<SubGraph>();
	}
	
	public AbstractGraph setName(String name) {
		_name = name;
		return this;
	}
	
	public String getName() {
		return _name;
	}
	
	public List<NodeList> getNodeLists() {
		return _nodeLists;
	}

	public NodeList getNodeList() {
		return getNodeList(_nodeLists.size() - 1);
	}
	
	public NodeList getNodeList(int index) {
		return _nodeLists.get(index);
	}
	
	public NodeList createNodeList() {
		_nodeLists.add(new NodeList(this));
		return getNodeList();
	}
	
	public NodeList addNodeList() {
		return createNodeList();
	}

	public AbstractGraph addNode(Node n) {
		getNodeList().addNode(n);
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
		for(NodeList nl : _nodeLists) {
			Node n = nl.getNode(name);
			if(n != null) {
				return n;
			}
		}
		
		if(create) {
			Node n = new Node(name);
			getNodeList().addNode(n);
			return n;
		} else {
			throw new RuntimeException("Node " + name + " not found.");
		}
	}
	
	public List<EdgeList> getEdgeLists() {
		return _edgeLists;
	}
	
	public EdgeList getEdgeList() {
		return getEdgeList(_edgeLists.size() - 1);
	}
	
	public EdgeList getEdgeList(int index) {
		return _edgeLists.get(index);
	}
	
	public EdgeList createEdgeList() {
		_edgeLists.add(new EdgeList(this));
		return getEdgeList();
	}
	
	public EdgeList addEdgeList() {
		return createEdgeList();
	}

	public AbstractGraph addEdge(Edge e) {
		getEdgeList().addEdge(e);
		return this;
	}
	
	public AbstractGraph addEdges(Edge ... edges) {
		for(Edge e: edges) {
			addEdge(e);
		}
		return this;
	}
	
	public AbstractGraph addSubGraph(SubGraph subGraph) {
		_subGraphs.add(subGraph);
		return this;
	}
	
	public List<SubGraph> getSubGraphs() {
		return _subGraphs;
	}
	
	public String toDot() {
		String dot = " {\n";
		
		if(getOptions().hasOptions()) {
			dot = dot + "graph [" + getOptions().getOptionsAsString() + "]\n";
		}

		for(SubGraph sg: _subGraphs) {
			dot = dot + sg.toDot();
		}
		
		if(getNodeLists().size() > 1) {
			for (NodeList nl : getNodeLists()) {
				if(nl.isStyle()) {
					dot = dot + nl.toDot();
				} else {
					dot = dot + "{\n" + nl.toDot() + "}\n";
				}
			}
		} else {
			dot = dot + getNodeList().toDot();
		}
		
		if(getEdgeLists().size() > 1) {
			for (EdgeList el : getEdgeLists()) {
				if(el.isStyle()) {
					dot = dot + el.toDot();
				} else {
					dot = dot + "{\n" + el.toDot() + "}\n";
				}
			}
		} else {
			dot = dot + getEdgeList().toDot();
		}

		dot = dot + "}\n";
		return dot;
	}
	
	private List<NodeList> _nodeLists;
	private List<EdgeList> _edgeLists;
	private List<SubGraph> _subGraphs;
	private String _name;
}
