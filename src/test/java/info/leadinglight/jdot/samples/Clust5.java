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
package info.leadinglight.jdot.samples;

import info.leadinglight.jdot.*;

public class Clust5 {

    public static void main(String[] args) {
        g().viewSvg();
    }

    public static Graph g() {
        Graph g = new Graph("G").setSize("6,6");
        g.addEdge(new Edge("a", "b", "c"));
        g.addClusterGraph(new ClusterGraph("cluster0").addEdge("x0", "y0").addEdge("x0", "z0"));
        g.addClusterGraph(new ClusterGraph("cluster1").addEdge("x1", "y1").addEdge("x1", "z1"));
        g.addClusterGraph(new ClusterGraph("cluster2").addEdges(new Edge("x2", "y2"), new Edge("x2", "z2")));
        g.addEdges(new Edge("a", "x0"), new Edge("b", "x1"), new Edge("b", "x2"), new Edge("a", "z2"), new Edge("c", "z1"));
        return g;
    }
}
