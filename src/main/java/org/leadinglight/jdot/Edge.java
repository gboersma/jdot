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
		_edgeNodeLists = new ArrayList<EdgeNodeList>();
	}
	
	public Edge(Node n1, Node ... nodes) {
		_edgeNodeLists = new ArrayList<EdgeNodeList>();
		_edgeNodeLists.add(new EdgeNodeList(n1));
		for(Node n: nodes) {
			_edgeNodeLists.add(new EdgeNodeList(n));
		}
	}
	
	public Edge(Graph graph, String name, String ... names) {
		_graph = graph;
		_edgeNodeLists = new ArrayList<EdgeNodeList>();
		_edgeNodeLists.add(new EdgeNodeList(graph.getNode(name, true)));
		for(String n: names) {
			_edgeNodeLists.add(new EdgeNodeList(graph.getNode(n, true)));
		}
	}
	
	public Edge addNode(Node node) {
		_edgeNodeLists.add(new EdgeNodeList(node));
		return this;
	}
	
	public Edge addNode(Graph graph, String name) {
		_edgeNodeLists.add(new EdgeNodeList(graph.getNode(name, true)));
		return this;
	}
	
	public Edge addNodes(Node ... nodes) {
		EdgeNodeList enl = new EdgeNodeList();
		_edgeNodeLists.add(enl);
		for(Node n: nodes) {
			enl.addNode(n);
		}
		return this;
	}
	
	public Edge addNodes(Graph graph, String ... names) {
		EdgeNodeList enl = new EdgeNodeList();
		_edgeNodeLists.add(enl);
		for(String name: names) {
			enl.addNode(graph.getNode(name, true));
		}
		return this;
	}

	public boolean isStyle() {
		return _edgeNodeLists.size() == 0;
	}
	
	public String toDot() {
		String dot;

		if(isStyle()) {
			dot = "edge";
		} else {
			List<String> l = new ArrayList<String>();
			for(EdgeNodeList enl: _edgeNodeLists) {
				l.add(enl.toDot());
			}

			if(getGraph().getType() == Graph.Type.digraph) {
				dot = Util.join(l, " -> ");
			} else {
				dot = Util.join(l, " -- ");
			}
		}
			
		if(getOptions().hasOptions()) {
			dot = dot + " [" + getOptions().getOptionsAsString() + "]\n";
		} else {
			dot = dot + "\n";
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
		back, forward, both, none
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

	private List<EdgeNodeList> _edgeNodeLists;
	private Graph _graph;
}
