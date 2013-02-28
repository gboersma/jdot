package info.leadinglight.jdot.impl;

public abstract class AbstractElement {
	public AbstractElement() {
		_attrs = new Attrs();
	}
	
	public Attrs getAttrs() {
		return _attrs;
	}
	
	public abstract String toDot();
	
	private Attrs _attrs;
}
