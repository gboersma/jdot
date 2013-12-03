package info.leadinglight.jdot.impl;

public class EdgeNode extends AbstractElement {

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

    @Override
    public String toDot() {
        String dot = "\"" + _name + "\"";
        if (_label != null) {
            dot = dot + ":" + "\"" + _label + "\"";
        }
        return dot;
    }

    private final String _name;
    private final String _label;
}
