package org.leadinglight.jdot;

import org.leadinglight.jdot.enums.*;
import org.leadinglight.jdot.impl.*;

public class Node extends AbstractElement {
	/**
	 * A Node without a name specified is a style node.
	 */
	public Node() {
		_name = "node";
	}
	
	public Node(String name) {
		_name = name;
	}
	
	public boolean isStyle() {
		return _name.equals("node");
	}
	
	public String getName() {
		return _name;
	}
	
	public String toDot() {
		String dot = "";
		
		if (!isStyle()) {
			dot = "\"" + _name + "\"";
		} else {
			dot = _name; 
		}
		
		if(getAttrs().has()) {
			dot = dot + " [" + getAttrs().getAsString() + "]\n";
		} else {
			dot = dot + "\n";
		}
		
		return dot;
	}
	
	// Options
	
	public Node setLabel(String label) {
		getAttrs().set(Attrs.Key.label, label);
		return this;
	}
	
	public Node setColor(String color) {
		getAttrs().set(Attrs.Key.color, color);
		return this;
	}
	
	public Node setColor(Color.X11 color) {
		getAttrs().set(Attrs.Key.color, color);
		return this;
	}

	public Node setColor(Color.SVG color) {
		getAttrs().set(Attrs.Key.color, color);
		return this;
	}
	
	public Node setShape(Shape shape) {
		getAttrs().set(Attrs.Key.shape, shape);
		return this;
	}
	
	public Node setStyle(Style.Node style) {
		getAttrs().set(Attrs.Key.style, style);
		return this;
	}
	
	public Node setFontSize(double fontsize) {
		getAttrs().set(Attrs.Key.fontsize, new Double(fontsize));
		return this;
	}
	
	public Node setFontName(String fontname) {
		getAttrs().set(Attrs.Key.fontname, fontname);
		return this;
	}

	public Node setFontColor(String fontcolor) {
		getAttrs().set(Attrs.Key.fontcolor, fontcolor);
		return this;
	}

	public Node setFontColor(Color.X11 fontcolor) {
		getAttrs().set(Attrs.Key.fontcolor, fontcolor);
		return this;
	}
	
	public Node setFontColor(Color.SVG fontcolor) {
		getAttrs().set(Attrs.Key.fontcolor, fontcolor);
		return this;
	}

	public Node setWidth(String width) {
		getAttrs().set(Attrs.Key.width, width);
		return this;
	}
	
	public Node setWidth(double width) {
		getAttrs().set(Attrs.Key.width, new Double(width));
		return this;
	}

	public Node setHeight(String height) {
		getAttrs().set(Attrs.Key.height, height);
		return this;
	}
	
	public Node setHeight(double height) {
		getAttrs().set(Attrs.Key.height, new Double(height));
		return this;
	}
	
	public Node setOrdering(Ordering ordering) {
		getAttrs().set(Attrs.Key.ordering, ordering);
		return this;
	}

	private String _name;
}
