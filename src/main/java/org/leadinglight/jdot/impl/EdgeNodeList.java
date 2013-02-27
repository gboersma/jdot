package org.leadinglight.jdot.impl;

import java.util.ArrayList;
import java.util.List;

public class EdgeNodeList {
	public EdgeNodeList(String ... names) {
		_edgeNodes = new ArrayList<EdgeNode>();
		for(String name: names) {
			_edgeNodes.add(new EdgeNode(name));
		}
	}
	
	public List<EdgeNode> getNodes() {
		return _edgeNodes;
	}
	
	public EdgeNodeList addNode(String name) {
		return addNode(name, null);
	}
	
	public EdgeNodeList addNode(String name, String label) {
		_edgeNodes.add(new EdgeNode(name, label));
		return this;
	}
	
	public int size() {
		return _edgeNodes.size();
	}
	
	public String toDot() {
		String dot = "";
		if (_edgeNodes.size() == 1) {
			dot = dot + _edgeNodes.get(0).toDot();
		} else {
			List<String> l = new ArrayList<String>();
			for(EdgeNode en: _edgeNodes) {
				l.add(en.toDot());
			}
			dot = dot + "{" + Util.join(l, " ") + "}";
		}
		return dot;
	}

	List<EdgeNode> _edgeNodes;
}
