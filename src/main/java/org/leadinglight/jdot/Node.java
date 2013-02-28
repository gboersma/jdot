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
	
	public String toDot(boolean linefeed) {
		String dot = "";
		
		if (!isStyle()) {
			dot = "\"" + _name + "\"";
		} else {
			dot = _name; 
		}
		
		if(getAttrs().has()) {
			dot = dot + " [" + getAttrs().getAsString() + "]" + (linefeed ? "\n" : " ");
		} else {
			dot = dot + (linefeed ? "\n" : " ");
		}
		
		return dot;
	}

	private String _name;
	
	// Attrs
	
	public Node setURL(String url) {
		getAttrs().set(Attrs.Key.URL, url);
		return this;
	}
	
	public Node setArea(double area) {
		getAttrs().set(Attrs.Key.area, new Double(area));
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
	
	public Node setColorScheme(String scheme) {
		getAttrs().set(Attrs.Key.colorscheme, scheme);
		return this;
	}
	
	public Node setComment(String comment) {
		getAttrs().set(Attrs.Key.comment, comment);
		return this;
	}
	
	public Node setDistortion(double val) {
		getAttrs().set(Attrs.Key.distortion, new Double(val));
		return this;
	}
	
	public Node setFillColor(String color) {
		getAttrs().set(Attrs.Key.fillcolor, color);
		return this;
	}
	
	public Node setFillColor(Color.X11 color) {
		getAttrs().set(Attrs.Key.fillcolor, color);
		return this;
	}

	public Node setFillColor(Color.SVG color) {
		getAttrs().set(Attrs.Key.fillcolor, color);
		return this;
	}
	
	public Node setFixedSize(boolean val) {
		getAttrs().set(Attrs.Key.fixedsize, val);
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

	public Node setFontName(String fontname) {
		getAttrs().set(Attrs.Key.fontname, fontname);
		return this;
	}

	public Node setFontSize(double fontsize) {
		getAttrs().set(Attrs.Key.fontsize, new Double(fontsize));
		return this;
	}
	
	public Node setGradientAngle(int val) {
		getAttrs().set(Attrs.Key.gradientangle, new Integer(val));
		return this;
	}
	
	public Node setGroup(String val) {
		getAttrs().set(Attrs.Key.group, val);
		return this;
	}
	
	public Node setHeight(double height) {
		getAttrs().set(Attrs.Key.height, new Double(height));
		return this;
	}
	
	public Node setHref(String val) {
		getAttrs().set(Attrs.Key.href, val);
		return this;
	}
	
	public Node setId(String val) {
		getAttrs().set(Attrs.Key.id, val);
		return this;
	}
	
	public Node setImage(String val) {
		getAttrs().set(Attrs.Key.image, val);
		return this;
	}
	
	public Node setImageScale(String val) {
		getAttrs().set(Attrs.Key.imagescale, val);
		return this;
	}
	
	public Node setImageScale(boolean flag) {
		getAttrs().set(Attrs.Key.imagescale, new Boolean(flag));
		return this;
	}
	
	public Node setLabel(String label) {
		getAttrs().set(Attrs.Key.label, label);
		return this;
	}
	
	public Node setLabelLoc(Position.Y val) {
		getAttrs().set(Attrs.Key.labelloc, val);
		return this;
	}
	
	public Node setLayer(String val) {
		getAttrs().set(Attrs.Key.layer, val);
		return this;
	}
	
	public Node setMargin(double val) {
		getAttrs().set(Attrs.Key.margin, val);
		return this;
	}
	
	public Node setMargin(String val) {
		getAttrs().set(Attrs.Key.margin, val);
		return this;
	}

	public Node setNoJustify(boolean flag) {
		getAttrs().set(Attrs.Key.nojustify, new Boolean(flag));
		return this;
	}
	
	public Node setOrdering(Ordering ordering) {
		getAttrs().set(Attrs.Key.ordering, ordering);
		return this;
	}

	public Node setOrientation(double val) {
		getAttrs().set(Attrs.Key.orientation, new Double(val));
		return this;
	}

	public Node setPenWidth(double val) {
		getAttrs().set(Attrs.Key.penwidth, new Double(val));
		return this;
	}
	
	public Node setPeripheries(int val) {
		getAttrs().set(Attrs.Key.peripheries, new Integer(val));
		return this;
	}
	
	public Node setPin(boolean flag) {
		getAttrs().set(Attrs.Key.pin, new Boolean(flag));
		return this;
	}
	
	public Node setPos(String val) {
		getAttrs().set(Attrs.Key.pos, val);
		return this;
	}
	
	public Node setRects(String val) {
		getAttrs().set(Attrs.Key.rects, val);
		return this;
	}
	
	public Node setRegular(boolean flag) {
		getAttrs().set(Attrs.Key.regular, new Boolean(flag));
		return this;
	}
	
	public Node setRoot(String val) {
		getAttrs().set(Attrs.Key.root, val);
		return this;
	}
	
	public Node setRoot(boolean flag) {
		getAttrs().set(Attrs.Key.root, new Boolean(flag));
		return this;
	}
	
	public Node setSamplePoints(int val) {
		getAttrs().set(Attrs.Key.samplepoints, new Integer(val));
		return this;
	}
	
	public Node setShape(Shape shape) {
		getAttrs().set(Attrs.Key.shape, shape);
		return this;
	}
	
	public Node setShapeFile(String val) {
		getAttrs().set(Attrs.Key.shapefile, val);
		return this;
	}

	public Node setShowBoxes(int val) {
		getAttrs().set(Attrs.Key.showboxes, new Integer(val));
		return this;
	}
	
	public Node setSides(int val) {
		getAttrs().set(Attrs.Key.sides, new Integer(val));
		return this;
	}

	public Node setSkew(double val) {
		getAttrs().set(Attrs.Key.skew, new Double(val));
		return this;
	}
	
	public Node setSortV(int val) {
		getAttrs().set(Attrs.Key.sortv, new Integer(val));
		return this;
	}
	
	public Node setStyle(Style.Node style) {
		getAttrs().set(Attrs.Key.style, style);
		return this;
	}

	public Node setTarget(String val) {
		getAttrs().set(Attrs.Key.target, val);
		return this;
	}
	
	public Node setToolTip(String val) {
		getAttrs().set(Attrs.Key.tooltip, val);
		return this;
	}
	
	public Node setVertices(String val) {
		getAttrs().set(Attrs.Key.vertices, val);
		return this;
	}
	
	public Node setWidth(double width) {
		getAttrs().set(Attrs.Key.width, new Double(width));
		return this;
	}

	public Node setXLabel(String val) {
		getAttrs().set(Attrs.Key.xlabel, val);
		return this;
	}
	
	public Node setXlp(String val) {
		getAttrs().set(Attrs.Key.xlp, val);
		return this;
	}
	
	public Node setZ(double val) {
		getAttrs().set(Attrs.Key.z, new Double(val));
		return this;
	}
}
