package org.leadinglight.jdot;

public class EdgeNode {
	public EdgeNode(Node node) {
		_node = node;
		_label = null;
	}

	public EdgeNode(Node node, String label) {
		_node = node;
		_label = label;
	}
	
	public Node getNode() {
		return _node;
	}
	
	public String getLabel() {
		return _label;
	}
	
	public String toDot() {
		String dot = "\"" + _node.getName() + "\"";
		if(_label != null) {
			dot = dot + ":" + "\""+ _label + "\"";
		}
		return dot;
	}
	
	private Node _node;
	private String _label;
}
