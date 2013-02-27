package org.leadinglight.jdot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.leadinglight.jdot.enums.*;
import org.leadinglight.jdot.impl.*;

/**
 * Graph structure to be laid out and drawn by Graphviz.
 */
public class Graph extends AbstractGraph {
	public Graph() {
		super();
		_type = GraphType.digraph;
		_strict = false;
	}
	
	public Graph(String name) {
		super(name);
		_type = GraphType.digraph;
		_strict = false;
	}
	
	public Graph addNode(Node n) {
		super.addNode(n);
		return this;
	}
	
	public Graph addNodes(Node ... nodes) {
		super.addNodes(nodes);
		return this;
	}
	
	public Graph addEdge(Edge e) {
		super.addEdge(e);
		return this;
	}
	
	public Graph addEdge(String name, String ... names) {
		super.addEdge(name, names);
		return this;
	}
	
	public Graph addEdges(Edge ... edges) {
		super.addEdges(edges);
		return this;
	}

	public Graph addSubGraph(SubGraph subGraph) {
		super.addGraph(subGraph);
		return this;
	}
	
	public Graph addClusterGraph(ClusterGraph clusterGraph) {
		super.addGraph(clusterGraph);
		return this;
	}

	public String toDot() {
		String dot = "";
		
		if(isStrict()) {
			dot = "strict ";
		}
		
		dot = dot + _type.name();
		
		if(getName() != null && getName().length() > 0) {
			dot = dot + " " + getName();
		}
		
		dot = dot + " {\n";

		if(getAttrs().has()) {
			dot = dot + "graph [" + getAttrs().getAsString() + "]\n";
		}
		
		for(AbstractElement e: getElements()) {
			dot = dot + e.toDot(); 
		}
		dot = dot + "}\n";
		return dot;
	}
	
	public void dot2svg() {
		try {
			File tfile = File.createTempFile("temp-file", ".svg");
			String svg = Util.sh("/usr/local/bin/dot -Tsvg", toDot());
			//System.out.println("SVG is " + svg);
			FileWriter w = new FileWriter(tfile);
			w.write(svg);
			w.flush();
			w.close();
			Util.sh(new String[]{"open", "-a", "Google Chrome.app", "file://" + tfile.toString()});
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

	private GraphType _type;
	private boolean _strict;

	// Options
	
	
	public Graph setType(GraphType type) {
		_type = type;
		return this;
	}
	
	public GraphType getType() {
		return _type;
	}
	
	public Graph setStrict(boolean strict) {
		_strict = strict;
		return this;
	}
	
	public boolean isStrict() {
		return _strict;
	}
	
	public Graph setSize(String size) {
		getAttrs().set(Attrs.Key.size, size);
		return this;
	}
	
	public Graph setOrdering(Ordering ordering) {
		getAttrs().set(Attrs.Key.ordering, ordering);
		return this;
	}
	
	public Graph setPage(String page) {
		getAttrs().set(Attrs.Key.page, page);
		return this;
	}
	
	public Graph setRatio(double ratio) {
		getAttrs().set(Attrs.Key.ratio, ratio);
		return this;
	}
	
	public Graph setRatio(Ratio ratio) {
		getAttrs().set(Attrs.Key.ratio, ratio);
		return this;
	}
	
	public Graph setRankDir(Rankdir rankdir) {
		getAttrs().set(Attrs.Key.rankdir, rankdir);
		return this;
	}
	
	public Graph setRankSep(double amount) {
		return setRankSep(amount, false);
	}
	
	public Graph setRankSep(boolean equally) {
		return setRankSep(Double.MAX_VALUE, equally);
	}
	
	public Graph setRankSep(double amount, boolean equally) {
		if(equally) {
			if(amount != Double.MAX_VALUE) {
				getAttrs().set(Attrs.Key.ranksep, Double.toString(amount) + " equally");
			} else {
				getAttrs().set(Attrs.Key.ranksep, "equally");
			}
		} else {
			if(amount != Double.MAX_VALUE) {
				getAttrs().set(Attrs.Key.ranksep, amount);
			}
		}
		return this;
	}
	
	public Graph setSplines(Splines splines) {
		getAttrs().set(Attrs.Key.splines, splines);
		return this;
	}
	
	public Graph setSplines(boolean splines) {
		getAttrs().set(Attrs.Key.splines, new Boolean(splines));
		return this;
	}

	public Graph setOverlap(Overlap overlap) {
		getAttrs().set(Attrs.Key.overlap, overlap);
		return this;
	}
	
	public Graph setOverlap(boolean overlap) {
		getAttrs().set(Attrs.Key.overlap, new Boolean(overlap));
		return this;
	}
	
	public Graph setCenter(boolean center) {
		getAttrs().set(Attrs.Key.center, new Boolean(center));
		return this;
	}

	public Graph setBgColor(String color) {
		getAttrs().set(Attrs.Key.bgcolor, color);
		return this;
	}

	public Graph setBgColor(Color.X11 color) {
		getAttrs().set(Attrs.Key.bgcolor, color);
		return this;
	}
	
	public Graph setBgColor(Color.SVG color) {
		getAttrs().set(Attrs.Key.bgcolor, color);
		return this;
	}
	
	public Graph setNodeSep(double nodesep) {
		getAttrs().set(Attrs.Key.nodesep, new Double(nodesep));
		return this;
	}		
} 
