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
package info.leadinglight.jdot.enums;

public class Style {

    public enum ClusterGraph {

        solid, dashed, dotted, bold, rounded, filled, striped, invis
    }

    public enum Edge {

        solid, dashed, dotted, bold, invis, tapered
    }

    public enum Node {

        solid, dashed, dotted, bold, rounded, diagonals, filled, striped, wedged, invis
    }

    public enum Graph {

        radial
    }
}
