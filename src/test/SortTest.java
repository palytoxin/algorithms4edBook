package test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.source.tree.AssertTree;

import cheaper2.Insertion;
import cheaper2.Merge;
import cheaper2.MergeBU;
import cheaper2.Quick;
import cheaper2.QuickInsertion;
import cheaper2.QuickThird;
import cheaper2.Selection;
import cheaper2.Shell;

@SuppressWarnings("rawtypes")
public class SortTest extends CommonMethods {
	Comparable[] a = null;

	@Before
	public void before() {
		a = ran();
	}

	@After
	public void after() {
		assertTrue("Sort Error", isSorted(a));
	}

	@Test
	public void testQI() {
		QuickInsertion.sort(a);
	}
	
	@Test
	public void testQuickThird(){
		QuickThird.sort(a);
	}

	@Test
	public void testInsertion() {
		Insertion.sort(a);
	}

	@Test
	public void testMerge() {
		Merge.sort(a);
	}

	@Test
	public void testMergeBU() {
		MergeBU.sort(a);
	}

	@Test
	public void testQuick() {
		Quick.sort(a);
	}

	@Test
	public void testSelection() {
		Selection.sort(a);
	}

	@Test
	public void testShell() {
		Shell.sort(a);
	}

}
