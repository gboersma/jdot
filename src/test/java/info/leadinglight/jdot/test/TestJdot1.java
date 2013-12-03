package info.leadinglight.jdot.test;

import info.leadinglight.jdot.*;
import info.leadinglight.jdot.impl.Util;
import info.leadinglight.jdot.samples.*;

import java.io.File;
import java.net.URL;

import junit.framework.Assert;
import org.junit.Test;


public class TestJdot1 {
	@Test
	public void testAbstract() {
		Graph g = Abstract.g();
		Assert.assertTrue(graphCompare(g, "abstract.gv"));
	}
	
	@Test
	public void testAlf() {
		Graph g = Alf.g();
		Assert.assertTrue(graphCompare(g, "alf.gv"));
	}
	
	@Test
	public void testClust() {
		Graph g = Clust.g();
		Assert.assertTrue(graphCompare(g, "clust.gv"));
	}

	@Test
	public void testClust1() {
		Graph g = Clust1.g();
		Assert.assertTrue(graphCompare(g, "clust1.gv"));
	}

	@Test
	public void testClust2() {
		Graph g = Clust2.g();
		Assert.assertTrue(graphCompare(g, "clust2.gv"));
	}

	@Test
	public void testClust3() {
		Graph g = Clust3.g();
		Assert.assertTrue(graphCompare(g, "clust3.gv"));
	}

	@Test
	public void testClust4() {
		Graph g = Clust4.g();
		Assert.assertTrue(graphCompare(g, "clust4.gv"));
	}
	
	@Test
	public void testClust5() {
		Graph g = Clust5.g();
		Assert.assertTrue(graphCompare(g, "clust5.gv"));
	}

	@Test
	public void testGrammar() {
		Graph g = Grammar.g();
		Assert.assertTrue(graphCompare(g, "grammar.gv"));
	}
	
	@Test
	public void testKW91() {
		Graph g = KW91.g();
		Assert.assertTrue(graphCompare(g, "KW91.gv"));
	}
	
	@Test
	public void testMike() {
		Graph g = Mike.g();
		Assert.assertTrue(graphCompare(g, "mike.gv"));
	}

	@Test
	public void testOldArrows() {
		Graph g = OldArrows.g();
		Assert.assertTrue(graphCompare(g, "oldarrows.gv"));
	}
	
	@Test
	public void testPmpipe() {
		Graph g = Pmpipe.g();
		Assert.assertTrue(graphCompare(g, "pmpipe.gv"));
	}

	@Test
	public void testRecord2() {
		Graph g = Record2.g();
		Assert.assertTrue(graphCompare(g, "record2.gv"));
	}
	
	@Test
	public void testRecords() {
		Graph g = Records.g();
		Assert.assertTrue(graphCompare(g, "records.gv"));
	}
	
	@Test
	public void testStructs() {
		Graph g = Structs.g();
		Assert.assertTrue(graphCompare(g, "structs.gv"));
	}
	
	@Test
	public void testSwitch() {
		Graph g = Switch.g();
		Assert.assertTrue(graphCompare(g, "switch.gv"));
	}

	@Test
	public void testTrapeziumlr() {
		Graph g = Trapeziumlr.g();
		Assert.assertTrue(graphCompare(g, "trapeziumlr.gv"));
	}
	
	@Test
	public void testTree() {
		Graph g = Tree.g();
		Assert.assertTrue(graphCompare(g, "tree.gv"));
	}
	
	@Test
	public void testViewfile() {
		Graph g = Viewfile.g();
		Assert.assertTrue(graphCompare(g, "viewfile.gv"));
	}

	@Test
	public void testWorld() {
		Graph g = World.g();
		Assert.assertTrue(graphCompare(g, "world.gv"));
	}
	
	private boolean graphCompare(Graph g, String filename) {
		//System.out.println(filename + ":\n" + g.toDot());
		String svg1 = g.dot2svg();
		String svg2 = dot2svg(filename);
		return svg1.equals(svg2);
	}
	
	private String dot2svg(String filename) {
		URL url = this.getClass().getResource("/" + filename);
		File testFile = new File(url.getFile());
		String dot = Util.fromFile(testFile);
		String svg = Graph.dot2out("svg", dot);
		return svg;
	}
}
