package org.leadinglight.jdot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.leadinglight.jdot.impl.GraphElement;
import org.leadinglight.jdot.impl.Options;
import org.leadinglight.jdot.impl.Util;

/**
 * Graph structure to be laid out and drawn by Graphviz.
 */
public class Graph extends GraphElement {
	public Graph() {
		_name = null;
		_type = Type.digraph;
		_strict = false;
		_nodeLists = new ArrayList<NodeList>();
		_nodeLists.add(new NodeList(this));
		_edgeLists = new ArrayList<EdgeList>();
		_edgeLists.add(new EdgeList(this));
	}
	
	public Graph(String name) {
		_name = name;
		_type = Type.digraph;
		_strict = false;
		_nodeLists = new ArrayList<NodeList>();
		_nodeLists.add(new NodeList(this));
		_edgeLists = new ArrayList<EdgeList>();
		_edgeLists.add(new EdgeList(this));
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

	public Graph addNode(Node n) {
		getNodeList().addNode(n);
		return this;
	}
	
	public Graph addNodes(Node ... nodes) {
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

	public Graph addEdge(Edge e) {
		getEdgeList().addEdge(e);
		return this;
	}
	
	public Graph addEdges(Edge ... edges) {
		for(Edge e: edges) {
			addEdge(e);
		}
		return this;
	}
	
	public String toDot() {
		String dot = "";
		
		if(isStrict()) {
			dot = "strict ";
		}
		
		dot = dot + _type.name();
		
		if(_name != null && _name.length() > 0) {
			dot = dot + " " + _name;
		}
		
		dot = dot + " {\n";
		
		if(getOptions().hasOptions()) {
			dot = dot + "graph [" + getOptions().getOptionsAsString() + "];\n";
		}

		if(_nodeLists.size() > 1) {
			for (NodeList nl : _nodeLists) {
				dot = dot + "{\n" + nl.toDot() + "}\n";
			}
		} else {
			dot = dot + getNodeList().toDot();
		}
		
		boolean first = true;
		for (EdgeList el : _edgeLists) {
			if(first) {
				dot = dot + el.toDot() + "\n";
			} else {
				dot = dot + "{\n" + el.toDot() + "}\n";
			}
			first = false;
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

	public Graph setName(String name) {
		_name = name;
		return this;
	}
	
	public String getName() {
		return _name;
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

	private String _name;
	private Type _type;
	private List<NodeList> _nodeLists;
	private List<EdgeList> _edgeLists;
	private boolean _strict;
} 
