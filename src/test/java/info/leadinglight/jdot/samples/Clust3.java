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

public class Clust3 {

    public static void main(String[] args) {
        g().viewSvg();
    }

    public static Graph g() {
        Graph g = new Graph("G");
        g.addClusterGraph(new ClusterGraph("_c0").addEdge("a0", "a1", "a2", "a3"));
        g.addClusterGraph(new ClusterGraph("_c1").addEdge("b0", "b1", "b2", "b3"));
        g.addEdges(new Edge("x", "a0"), new Edge("x", "b0"), new Edge("a1", "b3"), new Edge("b1", "a3"));
        return g;
    }
}
