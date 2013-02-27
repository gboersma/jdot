package org.leadinglight.jdot;

import java.util.ArrayList;
import java.util.List;

import org.leadinglight.jdot.enums.*;
import org.leadinglight.jdot.impl.*;

public class Edge extends AbstractElement {
	/**
	 * An Edge without a start or end is a style edge.
	 */
	public Edge() {
		_edgeNodeLists = new ArrayList<EdgeNodeList>();
	}
	
	public Edge(String name, String ... names) {
		_edgeNodeLists = new ArrayList<EdgeNodeList>();
		_edgeNodeLists.add(new EdgeNodeList(name));
		for(String n: names) {
			_edgeNodeLists.add(new EdgeNodeList(n));
		}
		_graph = null;
	}

	public Edge setGraph(AbstractGraph g) {
		_graph = g;
		return this;
	}
	
	public Edge addNode(String name) {
		return addNode(name, null);
	}
	
	public Edge addNode(String name, String label) {
		_edgeNodeLists.add(new EdgeNodeList().addNode(name, label));
		return this;
	}
	
	public Edge addNodes(String ... names) {
		EdgeNodeList enl = new EdgeNodeList();
		_edgeNodeLists.add(enl);
		for(String name: names) {
			enl.addNode(name);
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
			
			if(_graph instanceof Graph && ((Graph)_graph).getType() == GraphType.graph) {
				dot = Util.join(l, " -- ");
			} else {
				dot = Util.join(l, " -> ");
			}
		}
			
		if(getAttrs().has()) {
			dot = dot + " [" + getAttrs().getAsString() + "]\n";
		} else {
			dot = dot + "\n";
		}

		return dot;
	}
	
	private List<EdgeNodeList> _edgeNodeLists;
	private AbstractGraph _graph;
	
	// Attrs
	
	public Edge setLabel(String label) {
		getAttrs().set(Attrs.Key.label, label);
		return this;
	}
	
	/**
	 * Set the color of the node.
	 * @param color Name of the color as a string (http://www.graphviz.org/doc/info/colors.html).
	 */
	public Edge setColor(String color) {
		getAttrs().set(Attrs.Key.color, color);
		return this;
	}
	
	public Edge setColor(Color.X11 color) {
		getAttrs().set(Attrs.Key.color, color);
		return this;
	}

	public Edge setColor(Color.SVG color) {
		getAttrs().set(Attrs.Key.color, color);
		return this;
	}
	
	public Edge setFontSize(double fontsize) {
		getAttrs().set(Attrs.Key.fontsize, new Double(fontsize));
		return this;
	}
	
	public Edge setFontName(String fontname) {
		getAttrs().set(Attrs.Key.fontname, fontname);
		return this;
	}

	public Edge setFontColor(String fontcolor) {
		getAttrs().set(Attrs.Key.fontcolor, fontcolor);
		return this;
	}

	public Edge setFontColor(Color.X11 fontcolor) {
		getAttrs().set(Attrs.Key.fontcolor, fontcolor);
		return this;
	}
	
	public Edge setFontColor(Color.SVG fontcolor) {
		getAttrs().set(Attrs.Key.fontcolor, fontcolor);
		return this;
	}
	
	public Edge setDir(Dir dir) {
		getAttrs().set(Attrs.Key.dir, dir);
		return this;
	}
	
	public Edge setLabelDistance(double labeldistance) {
		getAttrs().set(Attrs.Key.labeldistance, labeldistance);
		return this;
	}
	
	public Edge setSameHead(String ahead) {
		getAttrs().set(Attrs.Key.samehead, ahead);
		return this;
	}
	
	public Edge setSameTail(String atail) {
		getAttrs().set(Attrs.Key.sametail, atail);
		return this;
	}

	public Edge setArrowHead(ArrowType arrowType) {
		getAttrs().set(Attrs.Key.arrowhead, arrowType);
		return this;
	}

	public Edge setArrowTail(ArrowType arrowType) {
		getAttrs().set(Attrs.Key.arrowtail, arrowType);
		return this;
	}
	
	public Edge setTailLabel(String label) {
		getAttrs().set(Attrs.Key.taillabel, label);
		return this;
	}

	public Edge setHeadLabel(String label) {
		getAttrs().set(Attrs.Key.headlabel, label);
		return this;
	}
	
	public Edge setStyle(Style.Edge style) {
		getAttrs().set(Attrs.Key.style, style);
		return this;
	}
	
	public Edge setMinLen(int len) {
		getAttrs().set(Attrs.Key.minlen, new Integer(len));
		return this;
	}
}
