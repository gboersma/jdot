package org.leadinglight.jdot;

import java.util.ArrayList;
import java.util.List;

import org.leadinglight.jdot.impl.Util;

public class EdgeNodeList {
	public EdgeNodeList(Node ...nodes) {
		_nodes = new ArrayList<Node>();
		for(Node n: nodes) {
			_nodes.add(n);
		}
	}
	
	public EdgeNodeList addNode(Node node) {
		_nodes.add(node);
		return this;
	}
	
	public List<Node> getNodes() {
		return _nodes;
	}
	
	public int size() {
		return _nodes.size();
	}
	
	public String toDot() {
		String dot = "";
		if (_nodes.size() == 1) {
			dot = dot + "\"" + _nodes.get(0).getName() + "\"";
		} else {
			List<String> l = new ArrayList<String>();
			for(Node n: _nodes) {
				l.add("\"" + n.getName() + "\"");
			}
			dot = dot + "{" + Util.join(l, "; ") + ";}";
		}
		return dot;
	}

	List<Node> _nodes;
}
