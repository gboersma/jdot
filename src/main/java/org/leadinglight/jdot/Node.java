package org.leadinglight.jdot;

public class Node extends GraphElement {
	public Node(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}
	
	public String toDot() {
		String dot = _name;
		if(getOptions().hasOptions()) {
			dot = dot + " " + getOptions().getOptionsAsString() + ";\n";
		} else {
			dot = dot + ";\n";
		}
		return dot;
	}
	
	public void setGraph(Graph graph) {
		_graph = graph;
	}
	
	public Graph getGraph() {
		return _graph;
	}

	public void setLabel(String label) {
		getOptions().setOption("label", label);
	}
	
	public void setColor(String color) {
		getOptions().setOption("color", color);
	}
	
	public void setShape(String shape) {
		getOptions().setOption("shape", shape);
	}

	private String _name;
	private Graph _graph;
	
	// TODO Options color and shape as enums.
}
