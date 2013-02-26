package org.leadinglight.jdot.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Manage options associated with a GraphElement. 
 */
public class Options {
	public enum Key {
		color, label, shape, style, size, fontsize, fontname, fontcolor, width, dir, page, ratio,
		rankdir, ranksep, splines, overlap, labeldistance, samehead, sametail, arrowhead, arrowtail,
		taillabel, headlabel, center, bgcolor, height;
	}
	
	public Options() {
		_options = new HashMap<Key, Object>();
	}
	
	public Object getOption(Key key) {
		return _options.get(key);
	}
	
	public void setOption(Key key, Object value) {
		_options.put(key, value);
	}
	
	public boolean hasOptions() {
		return !_options.isEmpty();
	}
	
	public String getOptionAsString(Key key) {
		String str = "";
		Object value = getOption(key);
		if(value != null) {
			str = str + key.name() + "=";
			if(value instanceof String) {
				str = str + "\"" + Util.escape((String)value) + "\"";
			} else {
				str = str + value;
			}
		}
		return str;
	}
	
	public String getOptionsAsString() {
		List<String> l = new ArrayList<String>();
		for(Key key : _options.keySet()) {
			l.add(getOptionAsString(key));
		}
		return Util.join(l, " ");
	}
	
	public String toDot() {
		if(hasOptions()) {
			return "[" + getOptionsAsString() + "]";
		} else {
			return "";
		}
	}
	
	private Map<Key, Object> _options;
}
