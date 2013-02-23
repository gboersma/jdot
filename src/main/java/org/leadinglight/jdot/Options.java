package org.leadinglight.jdot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manage options associated with a GraphElement. 
 */
public class Options {
	public Options() {
		_options = new HashMap<String, Object>();
	}
	
	public Object getOption(String name) {
		return _options.get(name);
	}
	
	public void setOption(String name, Object value) {
		_options.put(name, value);
	}
	
	public boolean hasOptions() {
		return !_options.isEmpty();
	}
	
	public String getOptionAsString(String name) {
		String str = "";
		Object value = getOption(name);
		if(value != null) {
			str = str + name + "=";
			if(value instanceof String) {
				str = str + "\"" + value + "\"";
			} else {
				str = str + value;
			}
		}
		return str;
	}
	
	public String getOptionsAsString() {
		List<String> l = new ArrayList<String>();
		for(String key : _options.keySet()) {
			l.add(getOptionAsString(key));
		}
		return Util.join(l);
	}
	
	public String toDot() {
		if(hasOptions()) {
			return "[" + getOptionsAsString() + "]";
		} else {
			return "";
		}
	}
	
	private Map<String, Object> _options;
	
	// TODO Store options as enums rather than strings for more efficient storage.
}
