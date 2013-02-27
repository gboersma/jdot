package org.leadinglight.jdot.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Manage options associated with a GraphElement. 
 */
public class Attrs {
	public enum Key {
		color, label, shape, style, size, fontsize, fontname, fontcolor, width, dir, page, ratio,
		rankdir, ranksep, splines, overlap, labeldistance, samehead, sametail, arrowhead, arrowtail,
		taillabel, headlabel, center, bgcolor, height, minlen, nodesep, ordering;
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
