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

public class Structs {

    public static void main(String[] args) {
        g().viewSvg();
    }

    public static Graph g() {
        Graph g = new Graph("structs");
        g.addNodes(
                new Node().setShape(Shape.record),
                new Node("struct1").setShape(Shape.record).setLabel("<f0> left|<f1> middle|<f2> right"),
                new Node("struct2").setShape(Shape.record).setLabel("<f0> one|<f1> two"),
                new Node("struct3").setShape(Shape.record).setLabel("hello\nworld |{ b |{c|<here> d|e}| f}| g | h"));
        g.addEdges(
                new Edge().addNode("struct1", "f1").addNode("struct2", "f0"),
                new Edge().addNode("struct1", "f2").addNode("struct3", "here"));
        return g;
    }
}
