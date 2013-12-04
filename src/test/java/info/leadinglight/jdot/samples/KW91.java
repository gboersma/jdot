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

public class KW91 {

    public static void main(String[] args) {
        g().viewSvg();
    }

    public static Graph g() {
        Graph g = new Graph("G");
        ClusterGraph sg = new ClusterGraph("_outer").setStyle(Style.ClusterGraph.bold).addEdges(
                new Edge("Act_1", "Act_21"), new Edge("Act_1", "Act_23"), new Edge("Act_25", "Act_3"));
        g.addClusterGraph(sg);

        ClusterGraph sg2 = new ClusterGraph("_inner").setLabel("                          Act_2");
        sg2.addSubGraph(new SubGraph().addEdge(new Edge("Act_21", "Act_22").setMinLen(2)).setRank(Rank.same));
        sg2.addEdges(new Edge("Act_22", "Act_23"), new Edge("Act_22", "Act_24"));
        sg2.addSubGraph(new SubGraph().addEdge(new Edge("Act_23", "Act_24").setMinLen(2)).setRank(Rank.same));
        sg2.addEdges(new Edge("Act_23", "Act_25"), new Edge("Act_24", "Act_25"));
        sg.addClusterGraph(sg2);
        g.addEdges(new Edge("Ext_1", "Act_1"), new Edge("Act_3", "Ext_2"), new Edge("Ext_3", "Act_24"));
        return g;
    }
}
