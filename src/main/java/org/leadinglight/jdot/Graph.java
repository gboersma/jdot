package org.leadinglight.jdot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.leadinglight.jdot.impl.AbstractGraph;
import org.leadinglight.jdot.impl.Options;
import org.leadinglight.jdot.impl.Util;

/**
 * Graph structure to be laid out and drawn by Graphviz.
 */
public class Graph extends AbstractGraph {
	public Graph() {
		super();
		_type = Type.digraph;
		_strict = false;
	}
	
	public Graph(String name) {
		super(name);
		_type = Type.digraph;
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
		
		dot = dot + super.toDot();
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

	private Type _type;
	private boolean _strict;

	// Options
	
	public enum Type {
		graph, digraph
	}
	
	public enum Ratio {
		fill, compress, expand, auto
	}
	
	public enum Rankdir {
		LR
	}
	
	public enum Splines {
		none, line, polyline, curved, ortho, spline;
	}
	
	public enum Overlap {
		scale, prism, voronoi, scalexy, compress, vpsc, True, False; 
	}
	
	public Graph setType(Type type) {
		_type = type;
		return this;
	}
	
	public Type getType() {
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
		getOptions().setOption(Options.Key.size, size);
		return this;
	}
	
	public Graph setOrdering(NodeList.Ordering ordering) {
		getNodeList().setOrdering(ordering);
		return this;
	}
	
	public Graph setPage(String page) {
		getOptions().setOption(Options.Key.page, page);
		return this;
	}
	
	public Graph setRatio(double ratio) {
		getOptions().setOption(Options.Key.ratio, ratio);
		return this;
	}
	
	public Graph setRatio(Ratio ratio) {
		getOptions().setOption(Options.Key.ratio, ratio);
		return this;
	}
	
	public Graph setRankDir(Rankdir rankdir) {
		getOptions().setOption(Options.Key.rankdir, rankdir);
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
				getOptions().setOption(Options.Key.ranksep, Double.toString(amount) + " equally");
			} else {
				getOptions().setOption(Options.Key.ranksep, "equally");
			}
		} else {
			if(amount != Double.MAX_VALUE) {
				getOptions().setOption(Options.Key.ranksep, amount);
			}
		}
		return this;
	}
	
	public Graph setSplines(Splines splines) {
		getOptions().setOption(Options.Key.splines, splines);
		return this;
	}
	
	public Graph setSplines(boolean splines) {
		getOptions().setOption(Options.Key.splines, new Boolean(splines));
		return this;
	}

	public Graph setOverlap(Overlap overlap) {
		getOptions().setOption(Options.Key.overlap, overlap);
		return this;
	}
	
	public Graph setOverlap(boolean overlap) {
		getOptions().setOption(Options.Key.overlap, new Boolean(overlap));
		return this;
	}
	
	public Graph setCenter(boolean center) {
		getOptions().setOption(Options.Key.center, new Boolean(center));
		return this;
	}

	public Graph setBgColor(String color) {
		getOptions().setOption(Options.Key.bgcolor, color);
		return this;
	}

	public Graph setBgColor(Color.X11 color) {
		getOptions().setOption(Options.Key.bgcolor, color);
		return this;
	}
	
	public Graph setBgColor(Color.SVG color) {
		getOptions().setOption(Options.Key.bgcolor, color);
		return this;
	}
	
	public Graph setNodeSep(double nodesep) {
		getOptions().setOption(Options.Key.nodesep, new Double(nodesep));
		return this;
	}		
} 
