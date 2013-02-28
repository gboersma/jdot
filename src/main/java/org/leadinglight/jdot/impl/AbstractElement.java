package org.leadinglight.jdot.impl;

public abstract class AbstractElement {
	public AbstractElement() {
		_attrs = new Attrs();
	}
	
	public Attrs getAttrs() {
		return _attrs;
	}
	
	public abstract String toDot(boolean linefeed);
	
	public String toDot() {
		return toDot(false);
	}
	
	private Attrs _attrs;
}
