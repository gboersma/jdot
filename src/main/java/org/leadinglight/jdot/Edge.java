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
	
	public Edge setURL(String url) {
		getAttrs().set(Attrs.Key.URL, url);
		return this;
	}

	public Edge setArrowHead(ArrowType arrowType) {
		getAttrs().set(Attrs.Key.arrowhead, arrowType);
		return this;
	}
	
	public Edge setArrowHead(String val) {
		getAttrs().set(Attrs.Key.arrowhead, val);
		return this;
	}
	
	public Edge setArrowSize(double size) {
		getAttrs().set(Attrs.Key.arrowsize, new Double(size));
		return this;
	}

	public Edge setArrowTail(ArrowType arrowType) {
		getAttrs().set(Attrs.Key.arrowtail, arrowType);
		return this;
	}
	
	public Edge setArrowTail(String val) {
		getAttrs().set(Attrs.Key.arrowtail, val);
		return this;
	}
	
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
	
	public Edge setColorScheme(String scheme) {
		getAttrs().set(Attrs.Key.colorscheme, scheme);
		return this;
	}
	
	public Edge setComment(String comment) {
		getAttrs().set(Attrs.Key.comment, comment);
		return this;
	}
	
	public Edge setConstraint(boolean constraint) {
		getAttrs().set(Attrs.Key.constraint, new Boolean(constraint));
		return this;
	}
	
	public Edge setDecorate(boolean decorate) {
		getAttrs().set(Attrs.Key.decorate, new Boolean(decorate));
		return this;
	}
	
	public Edge setDir(Dir dir) {
		getAttrs().set(Attrs.Key.dir, dir);
		return this;
	}
	
	public Edge setEdgeURL(String url) {
		getAttrs().set(Attrs.Key.edgeURL, url);
		return this;
	}
	
	public Edge setEdgeHref(String val) {
		getAttrs().set(Attrs.Key.edgehref, val);
		return this;
	}

	public Edge setEdgeTarget(String val) {
		getAttrs().set(Attrs.Key.edgetarget, val);
		return this;
	}

	public Edge setEdgeTooltip(String val) {
		getAttrs().set(Attrs.Key.edgetooltip, val);
		return this;
	}

	public Edge setFillColor(String color) {
		getAttrs().set(Attrs.Key.fillcolor, color);
		return this;
	}
	
	public Edge setFillColor(Color.X11 color) {
		getAttrs().set(Attrs.Key.fillcolor, color);
		return this;
	}

	public Edge setFillColor(Color.SVG color) {
		getAttrs().set(Attrs.Key.fillcolor, color);
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
	
	public Edge setFontName(String fontname) {
		getAttrs().set(Attrs.Key.fontname, fontname);
		return this;
	}

	public Edge setFontSize(double fontsize) {
		getAttrs().set(Attrs.Key.fontsize, new Double(fontsize));
		return this;
	}
	
	public Edge setHeadURL(String val) {
		getAttrs().set(Attrs.Key.headURL, val);
		return this;
	}
	
	public Edge setHeadLp(String val) {
		getAttrs().set(Attrs.Key.head_lp, val);
		return this;
	}
	
	public Edge setHeadClip(boolean flag) {
		getAttrs().set(Attrs.Key.headclip, flag);
		return this;
	}
	
	public Edge setHeadHref(String val) {
		getAttrs().set(Attrs.Key.headhref, val);
		return this;
	}
	
	public Edge setHeadLabel(String label) {
		getAttrs().set(Attrs.Key.headlabel, label);
		return this;
	}
	
	public Edge setHeadPort(String val) {
		getAttrs().set(Attrs.Key.headport, val);
		return this;
	}
	
	public Edge setHeadTarget(String val) {
		getAttrs().set(Attrs.Key.headtarget, val);
		return this;
	}
	
	public Edge setHeadTooltip(String val) {
		getAttrs().set(Attrs.Key.headtooltip, val);
		return this;
	}
	
	public Edge setHref(String val) {
		getAttrs().set(Attrs.Key.href, val);
		return this;
	}
	
	public Edge setId(String val) {
		getAttrs().set(Attrs.Key.id, val);
		return this;
	}
	
	public Edge setLabel(String val) {
		getAttrs().set(Attrs.Key.label, val);
		return this;
	}
	
	public Edge setLabelUrl(String val) {
		getAttrs().set(Attrs.Key.labelURL, val);
		return this;
	}
	
	public Edge setLabelAngle(double val) {
		getAttrs().set(Attrs.Key.labelangle, new Double(val));
		return this;
	}
	
	public Edge setLabelDistance(double val) {
		getAttrs().set(Attrs.Key.labeldistance, new Double(val));
		return this;
	}
	
	public Edge setLabelFloat(boolean flag) {
		getAttrs().set(Attrs.Key.labelfloat, new Boolean(flag));
		return this;
	}
	
	public Edge setLabelFontColor(String fontcolor) {
		getAttrs().set(Attrs.Key.labelfontcolor, fontcolor);
		return this;
	}

	public Edge setLabelFontColor(Color.X11 fontcolor) {
		getAttrs().set(Attrs.Key.labelfontcolor, fontcolor);
		return this;
	}
	
	public Edge setLabelFontColor(Color.SVG fontcolor) {
		getAttrs().set(Attrs.Key.labelfontcolor, fontcolor);
		return this;
	}
	
	public Edge setLabelFontName(String fontname) {
		getAttrs().set(Attrs.Key.labelfontname, fontname);
		return this;
	}

	public Edge setLabelFontSize(double val) {
		getAttrs().set(Attrs.Key.labelfontsize, new Double(val));
		return this;
	}
	
	public Edge setLabelHref(String val) {
		getAttrs().set(Attrs.Key.labelhref, val);
		return this;
	}

	public Edge setLabelTarget(String val) {
		getAttrs().set(Attrs.Key.labeltarget, val);
		return this;
	}

	public Edge setLabelTooltip(String val) {
		getAttrs().set(Attrs.Key.labeltooltip, val);
		return this;
	}
	
	public Edge setLayer(String val) {
		getAttrs().set(Attrs.Key.layer, val);
		return this;
	}
	
	public Edge setLen(double val) {
		getAttrs().set(Attrs.Key.len, new Double(val));
		return this;
	}

	public Edge setLHead(String val) {
		getAttrs().set(Attrs.Key.lhead, val);
		return this;
	}
	
	public Edge setLp(String val) {
		getAttrs().set(Attrs.Key.lp, val);
		return this;
	}
	
	public Edge setTail(String val) {
		getAttrs().set(Attrs.Key.ltail, val);
		return this;
	}
	
	public Edge setMinLen(int len) {
		getAttrs().set(Attrs.Key.minlen, new Integer(len));
		return this;
	}
	
	public Edge setNoJustify(boolean flag) {
		getAttrs().set(Attrs.Key.nojustify, new Boolean(flag));
		return this;
	}

	public Edge setPenWidth(double val) {
		getAttrs().set(Attrs.Key.penwidth, new Double(val));
		return this;
	}
	
	public Edge setPos(String val) {
		getAttrs().set(Attrs.Key.pos, val);
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
	
	public Edge setShowBoxes(int val) {
		getAttrs().set(Attrs.Key.showboxes, new Integer(val));
		return this;
	}
	
	public Edge setStyle(Style.Edge style) {
		getAttrs().set(Attrs.Key.style, style);
		return this;
	}
	
	public Edge setTailURL(String val) {
		getAttrs().set(Attrs.Key.tailURL, val);
		return this;
	}
	
	public Edge setTailLp(String val) {
		getAttrs().set(Attrs.Key.tail_lp, val);
		return this;
	}
	
	public Edge setTailClip(boolean flag) {
		getAttrs().set(Attrs.Key.tailclip, new Boolean(flag));
		return this;
	}
	
	public Edge setTailHref(String val) {
		getAttrs().set(Attrs.Key.tailhref, val);
		return this;
	}
	
	public Edge setTailLabel(String label) {
		getAttrs().set(Attrs.Key.taillabel, label);
		return this;
	}
	
	public Edge setTailPort(String val) {
		getAttrs().set(Attrs.Key.tailport, val);
		return this;
	}

	public Edge setTailTarget(String val) {
		getAttrs().set(Attrs.Key.tailtarget, val);
		return this;
	}
	
	public Edge setTailTooltip(String val) {
		getAttrs().set(Attrs.Key.tailtooltip, val);
		return this;
	}
	
	public Edge setTarget(String val) {
		getAttrs().set(Attrs.Key.target, val);
		return this;
	}

	public Edge setToolTip(String val) {
		getAttrs().set(Attrs.Key.tooltip, val);
		return this;
	}
	
	public Edge setWeight(int val) {
		getAttrs().set(Attrs.Key.weight, new Integer(val));
		return this;
	}
	
	public Edge setWeight(double val) {
		getAttrs().set(Attrs.Key.weight, new Double(val));
		return this;
	}
	
	public Edge setXLabel(String val) {
		getAttrs().set(Attrs.Key.xlabel, val);
		return this;
	}

	public Edge setXlp(String val) {
		getAttrs().set(Attrs.Key.xlp, val);
		return this;
	}
}
