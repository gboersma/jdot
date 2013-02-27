package org.leadinglight.jdot.impl;

public class EdgeNode {
	public EdgeNode(String name) {
		_name = name;
		_label = null;
	}

	public EdgeNode(String name, String label) {
		_name = name;
		_label = label;
	}
	
	public String getName() {
		return _name;
	}
	
	public String getLabel() {
		return _label;
	}
	
	public String toDot() {
		String dot = "\"" + _name + "\"";
		if(_label != null) {
			dot = dot + ":" + "\""+ _label + "\"";
		}
		return dot;
	}
	
	private String _name;
	private String _label;
}
