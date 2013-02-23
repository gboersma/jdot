package org.leadinglight.jdot;

public class Edge extends GraphElement {
	public Edge(Node start, Node end) {
		_start = start;
		_end = end;
	}
	
	public Node getStart() {
		return _start;
	}
	
	public Node getEnd() {
		return _end;
	}
	
	public String toDot() {
		String dot;

		if(getGraph().getType() == GraphType.digraph) {
			dot = _start.getName() + " -> " + _end.getName();
		} else {
			dot = _start.getName() + " -- " + _end.getName();
		}
			
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
		getOptions().setOption(Options.Key.label, label);
	}
	
	public void setColor(String color) {
		getOptions().setOption(Options.Key.color, color);
	}
	
	private Node _start;
	private Node _end;
	private Graph _graph;
	
	// TODO Colors as enumerated type.
}
