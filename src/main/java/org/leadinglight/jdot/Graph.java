package org.leadinglight.jdot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.leadinglight.jdot.enums.*;
import org.leadinglight.jdot.impl.*;

/**
 * Graph structure to be laid out and drawn by Graphviz.
 * TODO Support for colorList attr type.
 * TODO Support for point(s) attr type.
 * TODO Support for arrow shapes (new).
 * TODO Support for portPos attr type.
 * TODO Support for layerList attr type.
 * TODO Support for layerSelect attr type.
 * TODO Support for packMode attr type.
 * TODO Support for splineType attr type.
 * TODO Support for rect attr type.
 * TODO Support for addDouble attr type.
 * TODO Support for addPoint attr type.
 * TODO Support for startType attr type.
 * TODO Support for viewPort attr type.
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

	public String toDot() {
		String dot = "";
		
		if(isStrict()) {
			dot = "strict ";
		}
		
		dot = dot + _type.name();
		
		if(getName() != null && getName().length() > 0) {
			dot = dot + " " + getName();
		}
		
		dot = dot + " { ";

		if(getAttrs().has()) {
			dot = dot + "graph [" + getAttrs().getAsString() + "] ";
		}
		
		for(AbstractElement e: getElements()) {
			dot = dot + e.toDot(); 
		}
		dot = dot + "} ";
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

	// Attrs
	
	public Graph setDamping(double damping) {
		getAttrs().set(Attrs.Key.Damping, new Double(damping));
		return this;
	}

	public Graph setK(double k) {
		getAttrs().set(Attrs.Key.K, new Double(k));
		return this;
	}
	
	public Graph setURL(String url) {
		getAttrs().set(Attrs.Key.URL, url);
		return this;
	}
	
	public Graph setAspect(double ratio) {
		getAttrs().set(Attrs.Key.aspect, Double.toString(ratio));
		return this;
	}
	
	public Graph setAspect(double ratio, int maxPass) {
		getAttrs().set(Attrs.Key.aspect, Double.toString(ratio) + "," + Integer.toString(maxPass));
		return this;
	}
	
	public Graph setBb(double llx, double lly, double urx, double ury) {
		getAttrs().set(Attrs.Key.bb, "\"" + Double.toString(llx) + "," + Double.toString(lly) + "," + Double.toString(urx) + "," + Double.toString(ury) + "\"");
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
	
	public Graph setCenter(boolean center) {
		getAttrs().set(Attrs.Key.center, new Boolean(center));
		return this;
	}

	public Graph setCharSet(String charset) {
		getAttrs().set(Attrs.Key.charset, charset);
		return this;
	}

	public Graph setClusterRank(ClusterMode mode) {
		getAttrs().set(Attrs.Key.clusterrank, mode);
		return this;
	}
	
	public Graph setColorScheme(String scheme) {
		getAttrs().set(Attrs.Key.colorscheme, scheme);
		return this;
	}
	
	public Graph setComment(String comment) {
		getAttrs().set(Attrs.Key.comment, comment);
		return this;
	}
	
	public Graph setCompound(boolean compound) {
		getAttrs().set(Attrs.Key.compound, new Boolean(compound));
		return this;
	}

	public Graph setConcentrate(boolean concentrate) {
		getAttrs().set(Attrs.Key.compound, new Boolean(concentrate));
		return this;
	}

	public Graph setDefaultDist(double dist) {
		getAttrs().set(Attrs.Key.defaultdist, new Double(dist));
		return this;
	}

	public Graph setDim(int dim) {
		getAttrs().set(Attrs.Key.dim, new Double(dim));
		return this;
	}
	
	public Graph setDimen(int dimen) {
		getAttrs().set(Attrs.Key.dimen, new Double(dimen));
		return this;
	}
	
	public Graph setDirEdgeConstraints(boolean flag) {
		getAttrs().set(Attrs.Key.diredgeconstraints, new Boolean(flag));
		return this;
	}
	
	public Graph setDirEdgeConstraints(String val) {
		getAttrs().set(Attrs.Key.diredgeconstraints, val);
		return this;
	}

	public Graph setDpi(double val) {
		getAttrs().set(Attrs.Key.dpi, new Double(val));
		return this;
	}
	
	public Graph setEpsilon(double val) {
		getAttrs().set(Attrs.Key.epsilon, new Double(val));
		return this;
	}
	
	public Graph setESep(double val) {
		getAttrs().set(Attrs.Key.esep, new Double(val));
		return this;
	}

	public Graph setESep(String val) {
		getAttrs().set(Attrs.Key.esep, val);
		return this;
	}

	public Graph setFontColor(String fontcolor) {
		getAttrs().set(Attrs.Key.fontcolor, fontcolor);
		return this;
	}

	public Graph setFontColor(Color.X11 fontcolor) {
		getAttrs().set(Attrs.Key.fontcolor, fontcolor);
		return this;
	}
	
	public Graph setFontColor(Color.SVG fontcolor) {
		getAttrs().set(Attrs.Key.fontcolor, fontcolor);
		return this;
	}
	
	public Graph setFontName(String fontname) {
		getAttrs().set(Attrs.Key.fontname, fontname);
		return this;
	}

	public Graph setFontNames(String val) {
		getAttrs().set(Attrs.Key.fontnames, val);
		return this;
	}
	
	public Graph setFontPath(String val) {
		getAttrs().set(Attrs.Key.fontpath, val);
		return this;
	}
	
	public Graph setFontSize(double fontsize) {
		getAttrs().set(Attrs.Key.fontsize, new Double(fontsize));
		return this;
	}

	public Graph setForceLabels(boolean flag) {
		getAttrs().set(Attrs.Key.forcelabels, new Boolean(flag));
		return this;
	}
	
	public Graph setGradientAngle(int val) {
		getAttrs().set(Attrs.Key.gradientangle, new Integer(val));
		return this;
	}
	
	public Graph setHref(String val) {
		getAttrs().set(Attrs.Key.href, val);
		return this;
	}
	
	public Graph setId(String val) {
		getAttrs().set(Attrs.Key.id, val);
		return this;
	}
	
	public Graph setImagePath(String val) {
		getAttrs().set(Attrs.Key.imagepath, val);
		return this;
	}
	
	public Graph setLabel(String label) {
		getAttrs().set(Attrs.Key.label, label);
		return this;
	}
	
	public Graph setLabelScheme(int val) {
		getAttrs().set(Attrs.Key.label_scheme, new Integer(val));
		return this;
	}
	
	public Graph setLabelJust(Position.X val) {
		getAttrs().set(Attrs.Key.labeljust, val);
		return this;
	}
	
	public Graph setLabelLoc(Position.Y val) {
		getAttrs().set(Attrs.Key.labelloc, val);
		return this;
	}
	
	public Graph setLandscape(boolean flag) {
		getAttrs().set(Attrs.Key.landscape, new Boolean(flag));
		return this;
	}
	
	public Graph setLayerListSep(String val) {
		getAttrs().set(Attrs.Key.layerlistsep, val);
		return this;
	}
	
	public Graph setLayers(String val) {
		getAttrs().set(Attrs.Key.layers, val);
		return this;
	}
	
	public Graph setLayerSelect(String val) {
		getAttrs().set(Attrs.Key.layerselect, val);
		return this;
	}
	
	public Graph setLayerSep(String val) {
		getAttrs().set(Attrs.Key.layersep, val);
		return this;
	}

	public Graph setLayout(String val) {
		getAttrs().set(Attrs.Key.layout, val);
		return this;
	}

	public Graph setLevels(int val) {
		getAttrs().set(Attrs.Key.levels, new Integer(val));
		return this;
	}
	
	public Graph setLevelsGap(double val) {
		getAttrs().set(Attrs.Key.levelsgap, new Double(val));
		return this;
	}
	
	public Graph setLHeight(double val) {
		getAttrs().set(Attrs.Key.lheight, new Double(val));
		return this;
	}
	
	public Graph setLp(String val) {
		getAttrs().set(Attrs.Key.lp, val);
		return this;
	}
	
	public Graph setLWidth(double val) {
		getAttrs().set(Attrs.Key.lwidth, new Double(val));
		return this;
	}

	public Graph setMargin(double val) {
		getAttrs().set(Attrs.Key.margin, val);
		return this;
	}
	
	public Graph setMargin(String val) {
		getAttrs().set(Attrs.Key.margin, val);
		return this;
	}
	
	public Graph setMaxiter(int val) {
		getAttrs().set(Attrs.Key.maxiter, new Integer(val));
		return this;
	}
	
	public Graph setMclimit(double val) {
		getAttrs().set(Attrs.Key.mclimit, new Double(val));
		return this;
	}
	
	public Graph setMinDist(double val) {
		getAttrs().set(Attrs.Key.mindist, new Double(val));
		return this;
	}
	
	public Graph setMode(String val) {
		getAttrs().set(Attrs.Key.mode, val);
		return this;
	}
	
	public Graph setModel(String val) {
		getAttrs().set(Attrs.Key.model, val);
		return this;
	}
	
	public Graph setMosek(boolean flag) {
		getAttrs().set(Attrs.Key.mosek, new Boolean(flag));
		return this;
	}
	
	public Graph setNodeSep(double nodesep) {
		getAttrs().set(Attrs.Key.nodesep, new Double(nodesep));
		return this;
	}

	public Graph setNoJustify(boolean flag) {
		getAttrs().set(Attrs.Key.nojustify, new Boolean(flag));
		return this;
	}
	
	public Graph setNormalize(boolean flag) {
		getAttrs().set(Attrs.Key.normalize, new Boolean(flag));
		return this;
	}
	
	public Graph setNsLimit(double val) {
		getAttrs().set(Attrs.Key.nslimit, new Double(val));
		return this;
	}
	
	public Graph setNsLimit1(double val) {
		getAttrs().set(Attrs.Key.nslimit1, new Double(val));
		return this;
	}

	public Graph setOrdering(Ordering ordering) {
		getAttrs().set(Attrs.Key.ordering, ordering);
		return this;
	}
	
	public Graph setOrientation(String val) {
		getAttrs().set(Attrs.Key.orientation, val);
		return this;
	}
	
	public Graph setOutputOrder(OutputMode val) {
		getAttrs().set(Attrs.Key.outputorder, val);
		return this;
	}
	
	public Graph setOverlap(boolean overlap) {
		getAttrs().set(Attrs.Key.overlap, new Boolean(overlap));
		return this;
	}
	
	public Graph setOverlap(Overlap overlap) {
		getAttrs().set(Attrs.Key.overlap, overlap);
		return this;
	}
	
	public Graph setOverlapScaling(double val) {
		getAttrs().set(Attrs.Key.overlap_scaling, new Double(val));
		return this;
	}
	
	public Graph setPack(boolean flag) {
		getAttrs().set(Attrs.Key.pack, new Boolean(flag));
		return this;
	}
	
	public Graph setPack(int val) {
		getAttrs().set(Attrs.Key.pack, new Integer(val));
		return this;
	}
	
	public Graph setPackMode(String val) {
		getAttrs().set(Attrs.Key.packmode, val);
		return this;
	}
	
	public Graph setPad(double val) {
		getAttrs().set(Attrs.Key.pad, new Double(val));
		return this;
	}
	
	public Graph setPad(String val) {
		getAttrs().set(Attrs.Key.pad, val);
		return this;
	}
	
	public Graph setPage(double val) {
		getAttrs().set(Attrs.Key.page, new Double(val));
		return this;
	}
	
	public Graph setPage(String val) {
		getAttrs().set(Attrs.Key.page, val);
		return this;
	}
	
	public Graph setPageDir(PageDir val) {
		getAttrs().set(Attrs.Key.pagedir, val);
		return this;
	}
	
	public Graph setQuadTree(QuadType val) {
		getAttrs().set(Attrs.Key.quadtree, val);
		return this;
	}
	
	public Graph setQuadTree(boolean flag) {
		getAttrs().set(Attrs.Key.quadtree, new Boolean(flag));
		return this;
	}
	
	public Graph setQuantum(double val) {
		getAttrs().set(Attrs.Key.quantum, new Double(val));
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
	
	public Graph setRankSep(String val) {
		getAttrs().set(Attrs.Key.ranksep, val);
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
	
	public Graph setReminCross(boolean flag) {
		getAttrs().set(Attrs.Key.remincross, new Boolean(flag));
		return this;
	}
	
	public Graph setRepulsiveForce(double val) {
		getAttrs().set(Attrs.Key.repulsiveforce, new Double(val));
		return this;
	}
	
	public Graph setResolution(double val) {
		getAttrs().set(Attrs.Key.resolution, new Double(val));
		return this;
	}
	
	public Graph setRoot(String val) {
		getAttrs().set(Attrs.Key.root, val);
		return this;
	}
	
	public Graph setRoot(boolean flag) {
		getAttrs().set(Attrs.Key.root, new Boolean(flag));
		return this;
	}
	
	public Graph setRotate(int val) {
		getAttrs().set(Attrs.Key.rotate, new Integer(val));
		return this;
	}
	
	public Graph setRotation(double val) {
		getAttrs().set(Attrs.Key.rotation, new Double(val));
		return this;
	}
	
	public Graph setScale(double val) {
		getAttrs().set(Attrs.Key.scale, new Double(val));
		return this;
	}
	
	public Graph setScale(String val) {
		getAttrs().set(Attrs.Key.scale, val);
		return this;
	}
	
	public Graph setSearchSize(int val) {
		getAttrs().set(Attrs.Key.searchsize, new Integer(val));
		return this;
	}
	
	public Graph setSep(String val) {
		getAttrs().set(Attrs.Key.sep, val);
		return this;
	}
	
	public Graph setShowBoxes(int val) {
		getAttrs().set(Attrs.Key.showboxes, new Integer(val));
		return this;
	}
	
	public Graph setSize(String size) {
		getAttrs().set(Attrs.Key.size, size);
		return this;
	}
	
	public Graph setSize(double val) {
		getAttrs().set(Attrs.Key.size, new Double(val));
		return this;
	}
	
	public Graph setSmoothing(SmoothType val) {
		getAttrs().set(Attrs.Key.smoothing, val);
		return this;
	}
	
	public Graph setSortV(int val) {
		getAttrs().set(Attrs.Key.sortv, new Integer(val));
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
	
	public Graph setStart(String val) {
		getAttrs().set(Attrs.Key.start, val);
		return this;
	}
	
	public Graph setStyle(Style.Graph style) {
		getAttrs().set(Attrs.Key.style, style);
		return this;
	}
	
	public Graph setStyleSheet(String val) {
		getAttrs().set(Attrs.Key.stylesheet, val);
		return this;
	}
	
	public Graph setTarget(String val) {
		getAttrs().set(Attrs.Key.target, val);
		return this;
	}
	
	public Graph setTrueColor(boolean val) {
		getAttrs().set(Attrs.Key.truecolor, new Boolean(val));
		return this;
	}
	
	public Graph setViewport(String val) {
		getAttrs().set(Attrs.Key.viewport, val);
		return this;
	}
	
	public Graph setVoroMargin(double val) {
		getAttrs().set(Attrs.Key.voro_margin, new Double(val));
		return this;
	}
} 
