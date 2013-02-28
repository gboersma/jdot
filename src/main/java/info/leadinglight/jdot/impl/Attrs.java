package info.leadinglight.jdot.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Manage options associated with a GraphElement. 
 */
public class Attrs {
	public enum Key {
		Damping, K, URL, area, arrowhead, arrowsize, arrowtail, aspect, bb, bgcolor, center, charset, clusterrank, color, colorscheme, comment,
		compound, concentrate, constraint, decorate, defaultdist, dim, dimen, dir, diredgeconstraints, distortion, dpi, edgeURL, edgehref,
		edgetarget, edgetooltip, epsilon, esep, fillcolor, fixedsize, fontcolor, fontname, fontnames, fontpath, fontsize, forcelabels,
		gradientangle, group, headURL, head_lp, headclip, headhref, headlabel, headport, headtarget, headtooltip, height, href,
		id, image, imagepath, imagescale, label, labelURL, label_scheme, labelangle, labeldistance, labelfloat, labelfontcolor, labelfontname,
		labelfontsize, labelhref, labeljust, labelloc, labeltarget, labeltooltip, landscape, layer, layerlistsep, layers, layerselect,
		layersep, layout, len, levels, levelsgap, lhead, lheight, lp, ltail, lwidth, margin, maxiter, mclimit, mindist, minlen, mode, model,
		mosek, nodesep, nojustify, normalize, nslimit, nslimit1, ordering, orientation, outputorder, overlap, overlap_scaling,
		pack, packmode, pad, page, pagedir, pencolor, penwidth, peripheries, pin, pos, quadtree, quantum, rank, rankdir, ranksep,
		ratio, rects, regular, remincross, repulsiveforce, resolution, root, rotate, rotation, samehead, sametail, samplepoints,
		scale, searchsize, sep, shape, shapefile, showboxes, sides, size, skew, smoothing, sortv, splines, start, style, stylesheet,
		tailURL, tail_lp, tailclip, tailhref, taillabel, tailport, tailtarget, tailtooltip, target, tooltip, truecolor, vertices, 
		viewport, voro_margin, weight, width, xlabel, xlp, z
	}
	
	public Attrs() {
		_attrs = new HashMap<Key, Object>();
	}
	
	public Object get(Key key) {
		return _attrs.get(key);
	}
	
	public void set(Key key, Object value) {
		_attrs.put(key, value);
	}
	
	public boolean has() {
		return !_attrs.isEmpty();
	}
	
	public String getAttrString(Key key) {
		String str = "";
		Object value = get(key);
		if(value != null) {
			str = str + key.name() + "=";
			if(value instanceof String) {
				str = str + "\"" + (String)value + "\"";
			} else {
				str = str + value;
			}
		}
		return str;
	}
	
	public String getAsString() {
		List<String> l = new ArrayList<String>();
		for(Key key : _attrs.keySet()) {
			l.add(getAttrString(key));
		}
		return Util.join(l, " ");
	}
	
	public String toDot() {
		if(has()) {
			return "[" + getAsString() + "]";
		} else {
			return "";
		}
	}
	
	private Map<Key, Object> _attrs;
}
