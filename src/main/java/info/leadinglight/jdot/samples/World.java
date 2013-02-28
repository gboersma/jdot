package info.leadinglight.jdot.samples;

import info.leadinglight.jdot.*;
import info.leadinglight.jdot.enums.*;


public class World {
	public static void main(String[] args) {
		g().viewSvg();
	}

	public static Graph g() {
		Graph g = new Graph("world").setSize("7,7");
		g.addSubGraph(new SubGraph().setRank(Rank.same).addNodes(
				new Node("S8"), new Node("S24"), new Node("S1"), new Node("S35"), new Node("S30")));
		g.addSubGraph(new SubGraph().setRank(Rank.same).addNodes(
				new Node("T8"), new Node("T24"), new Node("T1"), new Node("T35"), new Node("T30")));
		g.addSubGraph(new SubGraph().setRank(Rank.same).addNodes(
				new Node("43"), new Node("37"), new Node("36"), new Node("10"), new Node("2")));
		g.addSubGraph(new SubGraph().setRank(Rank.same).addNodes(
				new Node("25"), new Node("9"), new Node("38"), new Node("40"), new Node("13"), 
				new Node("17"), new Node("12"), new Node("18")));
		g.addSubGraph(new SubGraph().setRank(Rank.same).addNodes(
				new Node("26"), new Node("42"), new Node("11"), new Node("3"), new Node("33"), 
				new Node("19"), new Node("39"), new Node("14"), new Node("16")));
		g.addSubGraph(new SubGraph().setRank(Rank.same).addNodes(
				 new Node("4"), new Node("31"), new Node("34"), new Node("21"), new Node("41"),
				 new Node("28"), new Node("20")));
		g.addSubGraph(new SubGraph().setRank(Rank.same).addNodes(
				new Node("27"), new Node("5"), new Node("22"), new Node("32"), new Node("29"), new Node("15")));
		g.addSubGraph(new SubGraph().setRank(Rank.same).addNodes(
				new Node("6"), new Node("23")));
		g.addSubGraph(new SubGraph().setRank(Rank.same).addNodes(
				new Node("7")));
		
		g.addEdges(
				new Edge("S8", "9"),
				new Edge("S24", "25"),
				new Edge("S24", "27"),
				new Edge("S1", "2"),
				new Edge("S1", "10"),
				new Edge("S35", "43"),
				new Edge("S35", "36"),
				new Edge("S30", "31"),
				new Edge("S30", "33"),
				new Edge("9", "42"),
				new Edge("9", "T1"),
				new Edge("25", "T1"),
				new Edge("25", "26"),
				new Edge("27", "T24"),
				// Note: It is important for the edges to be constructed like this.
				// I am not sure why they cannot be separated. If they are, it produces a different result.
				// Perhaps something to do with the ranking?
				new Edge("2").addNodes("3", "16", "17", "T1", "18"),
				new Edge("10").addNodes("11", "14", "T1", "13", "12"),
				new Edge("31", "T1"),
				new Edge("31", "32"),
				new Edge("33", "T30"),
				new Edge("33", "34"),
				new Edge("42", "4"),
				new Edge("26", "4"),
				new Edge("3", "4"),
				new Edge("16", "15"),
				new Edge("17", "19"),
				new Edge("18", "29"),
				new Edge("11", "4"),
				new Edge("14", "15"),
				new Edge("37").addNodes("39", "41", "38", "40"),				
				new Edge("13", "19"),
				new Edge("12", "29"),
				new Edge("43", "38"),
				new Edge("43", "40"),
				new Edge("36", "19"),
				new Edge("32", "23"),
				new Edge("34", "29"),
				new Edge("39", "15"),
				new Edge("41", "29"),
				new Edge("38", "4"),
				new Edge("40", "19"),
				new Edge("4", "5"),
				new Edge("19").addNodes("21", "20", "28"),
				new Edge("5").addNodes("6", "T35", "23"),
				new Edge("21", "22"),
				new Edge("20", "15"),
				new Edge("28", "29"),
				new Edge("6", "7"),
				new Edge("15", "T1"),
				new Edge("22", "T35"),
				new Edge("22", "23"),
				new Edge("29", "T30"),
				new Edge("7", "T8"),
				new Edge("23", "T24"),
				new Edge("23", "T1"));
		return g;
	}
}
