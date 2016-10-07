package info.leadinglight.jdot;

import info.leadinglight.jdot.enums.*;
import info.leadinglight.jdot.impl.*;

public class SubGraph extends AbstractGraph {

    public SubGraph() {
        super();
    }

    public SubGraph(String name) {
        super(name);
    }

    @Override
    public SubGraph addNode(Node n) {
        super.addNode(n);
        return this;
    }

    @Override
    public SubGraph addNodes(Node... nodes) {
        super.addNodes(nodes);
        return this;
    }

    @Override
    public SubGraph addEdge(Edge e) {
        super.addEdge(e);
        return this;
    }

    @Override
    public SubGraph addEdge(String name, String... names) {
        super.addEdge(name, names);
        return this;
    }

    @Override
    public SubGraph addEdges(Edge... edges) {
        super.addEdges(edges);
        return this;
    }

    public SubGraph addSubGraph(SubGraph subGraph) {
        super.addGraph(subGraph);
        return this;
    }

    public SubGraph addClusterGraph(ClusterGraph clusterGraph) {
        super.addGraph(clusterGraph);
        return this;
    }

    @Override
    public String toDot() {
        String dot = "";

        if (getName() != null && getName().length() > 0) {
            dot = dot + "subgraph " + getName() + " ";
        }

        dot = dot + "{ ";

        if (getAttrs().has()) {
            dot = dot + "graph [" + getAttrs().getAsString() + "] ";
        }

        if (_rank != null) {
            dot = dot + "rank=" + _rank + " ";
        }
        for (AbstractElement e : getElements()) {
            dot = dot + e.toDot();
        }
        dot = dot + "} ";
        return dot;
    }

    // Attrs
    private Rank _rank = null;

    public SubGraph setOrdering(Ordering ordering) {
        getAttrs().set(Attrs.Key.ordering, ordering);
        return this;
    }

    public SubGraph setRank(Rank rank) {
        _rank = rank;
        return this;
    }
}
