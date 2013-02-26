package org.leadinglight.jdot;

import java.util.ArrayList;
import java.util.List;

import org.leadinglight.jdot.impl.Util;

public class EdgeNodeList {
	public EdgeNodeList(Node ... nodes) {
		_edgeNodes = new ArrayList<EdgeNode>();
		for(Node n: nodes) {
			_edgeNodes.add(new EdgeNode(n));
		}
	}
	
	public List<EdgeNode> getNodes() {
		return _edgeNodes;
	}
	
	public EdgeNodeList addNode(Node node) {
		return addNode(node, null);
	}
	
	public EdgeNodeList addNode(Node node, String label) {
		_edgeNodes.add(new EdgeNode(node, label));
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
