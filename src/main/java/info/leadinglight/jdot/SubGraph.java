/**
    Copyright 2013 Gerald Boersma <gerald.boersma@gmail.com>

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 */
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
