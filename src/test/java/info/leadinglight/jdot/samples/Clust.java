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
import info.leadinglight.jdot.enums.*;

public class Clust {

    public static void main(String[] args) {
        g().viewSvg();
    }

    public static Graph g() {
        Graph g = new Graph("G");
        g.addClusterGraph(
                new ClusterGraph("_0").setLabel("hello world").setColor(Color.X11.hotpink).addEdge("a", "b").addEdge("a", "c"));
        g.addClusterGraph(
                new ClusterGraph("_1").setLabel("MSDOT").setColor(Color.X11.purple).setStyle(Style.ClusterGraph.dashed).addEdge("x", "y").addEdge("x", "z").addEdge("y", "z").addEdge("y", "q"));
        g.addEdges(new Edge("top", "a"), new Edge("top", "y"), new Edge("y", "b"));
        return g;
    }
}
