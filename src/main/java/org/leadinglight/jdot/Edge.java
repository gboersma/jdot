package org.leadinglight.jdot;

import java.util.ArrayList;
import java.util.List;

import org.leadinglight.jdot.impl.GraphElement;
import org.leadinglight.jdot.impl.Options;
import org.leadinglight.jdot.impl.Util;

public class Edge extends GraphElement {
	/**
	 * An Edge without a start or end is a style edge.
	 */
	public Edge() {
		_startNode = null;
		_endNodes = new ArrayList<Node>();
	}
	
	public Edge(Node startNode, Node endNode) {
		_startNode = startNode;
		_endNodes = new ArrayList<Node>();
		_endNodes.add(endNode);
	}
	
	public Edge(Node startNode, Node ... endNodes) {
		_startNode = startNode;
		_endNodes = new ArrayList<Node>();
		for(Node n: endNodes) {
			_endNodes.add(n);
		}
	}
	
	public Edge(Graph graph, String startName, String endName) {
		_graph = graph;
		_startNode = graph.getNode(startName, true);
		_endNodes = new ArrayList<Node>();
		_endNodes.add(graph.getNode(endName, true));
	}
	
	public Edge(Graph graph, String startName, String ... endNames) {
		_graph = graph;
		_startNode = graph.getNode(startName, true);
		_endNodes = new ArrayList<Node>();
		for(String endName: endNames) {
			_endNodes.add(graph.getNode(endName, true));
		}
	}
	
	public boolean isStyle() {
		return _startNode == null && _endNodes.size() == 0;
	}
	
	public String toDot() {
		String dot;

		if(isStyle()) {
			dot = "edge";
		} else {
			String endNodes = "";
			if(_endNodes.size() > 1) {
				List<String> nl = new ArrayList<String>();
				for(Node endNode: _endNodes) {
					nl.add("\"" + endNode.getName() + "\""); 
				}
				endNodes = "{" + Util.join(nl, "; ") + ";}";
			} else {
				endNodes = "\"" + _endNodes.get(0).getName() + "\""; 
			}
			
			if(getGraph().getType() == Graph.Type.digraph) {
				dot = "\"" + _startNode.getName() + "\" -> " + endNodes;
			} else {
				dot = "\"" + _startNode.getName() + "\" -- " + endNodes;
			}
		}
			
		if(getOptions().hasOptions()) {
			dot = dot + " " + getOptions().getOptionsAsString() + ";\n";
		} else {
			if(_endNodes.size() == 1) {
				dot = dot + ";\n";
			} else {
				dot = dot + "\n";
			}
		}

		return dot;
	}
	
	public Edge setGraph(Graph graph) {
		_graph = graph;
		return this;
	}
	
	public Graph getGraph() {
		return _graph;
	}
	
	// Options
	
	public enum Dir {
		back, forward, both
	}
	
	public enum ArrowType {
		normal, inv, dot, invdot, odot, invodot, none, tee, empty, invempty, diamond, 
		odiamond, ediamond, crow, box, obox, open, halfopen, vee
	}
	
	public Edge setLabel(String label) {
		getOptions().setOption(Options.Key.label, label);
		return this;
	}
	
	/**
	 * Set the color of the node.
	 * @param color Name of the color as a string (http://www.graphviz.org/doc/info/colors.html).
	 */
	public Edge setColor(String color) {
		getOptions().setOption(Options.Key.color, color);
		return this;
	}
	
	public Edge setColor(Color.X11 color) {
		getOptions().setOption(Options.Key.color, color);
		return this;
	}

	public Edge setColor(Color.SVG color) {
		getOptions().setOption(Options.Key.color, color);
		return this;
	}
	
	public Edge setFontSize(String fontsize) {
		getOptions().setOption(Options.Key.fontsize, fontsize);
		return this;
	}
	
	public Edge setFontName(String fontname) {
		getOptions().setOption(Options.Key.fontname, fontname);
		return this;
	}

	public Edge setFontColor(String fontcolor) {
		getOptions().setOption(Options.Key.fontcolor, fontcolor);
		return this;
	}

	public Edge setFontColor(Color.X11 fontcolor) {
		getOptions().setOption(Options.Key.fontcolor, fontcolor);
		return this;
	}
	
	public Edge setFontColor(Color.SVG fontcolor) {
		getOptions().setOption(Options.Key.fontcolor, fontcolor);
		return this;
	}
	
	public Edge setDir(Dir dir) {
		getOptions().setOption(Options.Key.dir, dir);
		return this;
	}
	
	public Edge setLabelDistance(double labeldistance) {
		getOptions().setOption(Options.Key.labeldistance, labeldistance);
		return this;
	}
	
	public Edge setSameHead(String ahead) {
		getOptions().setOption(Options.Key.samehead, ahead);
		return this;
	}
	
	public Edge setSameTail(String atail) {
		getOptions().setOption(Options.Key.sametail, atail);
		return this;
	}

	public Edge setArrowHead(ArrowType arrowType) {
		getOptions().setOption(Options.Key.arrowhead, arrowType);
		return this;
	}

	public Edge setArrowTail(ArrowType arrowType) {
		getOptions().setOption(Options.Key.arrowtail, arrowType);
		return this;
	}
	
	public Edge setTailLabel(String label) {
		getOptions().setOption(Options.Key.taillabel, label);
		return this;
	}

	public Edge setHeadLabel(String label) {
		getOptions().setOption(Options.Key.headlabel, label);
		return this;
	}

	private Node _startNode;
	private List<Node> _endNodes;
	private Graph _graph;
}
