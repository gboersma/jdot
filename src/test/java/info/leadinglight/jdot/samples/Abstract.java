/**
    Copyright 2013 Gerald Boersma <gerald dot boersma at gmail dot com>

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

import info.leadinglight.jdot.Edge;
import info.leadinglight.jdot.Graph;

public class Abstract {

    public static void main(String[] args) {
        g().viewSvg();
    }

    public static Graph g() {
        Graph g = new Graph("abstract").setSize("6,6");
        g.addEdges(new Edge("S24", "27"), new Edge("S24", "25"),
                new Edge("S1", "10"), new Edge("S1", "2"), new Edge(
                        "S35", "36"), new Edge("S35", "43"), new Edge(
                        "S30", "31"), new Edge("S30", "33"), new Edge(
                        "9", "42"), new Edge("9", "T1"), new Edge("25",
                        "T1"), new Edge("25", "26"),
                new Edge("27", "T24"), new Edge("2", "3"), new Edge(
                        "2", "16"), new Edge("2", "17"), new Edge("2",
                        "T1"), new Edge("2", "18"), new Edge("10", "11"),
                new Edge("10", "14"), new Edge("10", "T1"), new Edge(
                        "10", "13"), new Edge("10", "12"), new Edge("31",
                        "T1"), new Edge("31", "32"),
                new Edge("33", "T30"), new Edge("33", "34"), new Edge(
                        "42", "4"), new Edge("26", "4"), new Edge("3",
                        "4"), new Edge("16", "15"), new Edge("17", "19"),
                new Edge("18", "29"), new Edge("11", "4"), new Edge(
                        "14", "15"), new Edge("37", "39"), new Edge("37",
                        "41"), new Edge("37", "38"),
                new Edge("37", "40"), new Edge("13", "19"), new Edge(
                        "12", "29"), new Edge("43", "38"), new Edge("43",
                        "40"), new Edge("36", "19"),
                new Edge("32", "23"), new Edge("34", "29"), new Edge(
                        "39", "15"), new Edge("41", "29"), new Edge("38",
                        "4"), new Edge("40", "19"), new Edge("4", "5"),
                new Edge("19", "21"), new Edge("19", "20"), new Edge(
                        "19", "28"), new Edge("5", "6"), new Edge("5",
                        "T35"), new Edge("5", "23"),
                new Edge("21", "22"), new Edge("20", "15"), new Edge(
                        "28", "29"), new Edge("6", "7"), new Edge("15",
                        "T1"), new Edge("22", "23"),
                new Edge("22", "T35"), new Edge("29", "T30"), new Edge(
                        "7", "T8"), new Edge("23", "T24"), new Edge("23",
                        "T1"));
        return g;
    }
}
