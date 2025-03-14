package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeExpandToIncludeTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_Null() {
		Range nil = Range.expandToInclude(null, 1);
		assertEquals(1, nil.getLowerBound(), .000000001d);
		assertEquals(1, nil.getUpperBound(), .000000001d);
	}
	
	@Test
	public void test_LessThan() {
		Range range = new Range(1, 4);
		Range xpand = Range.expandToInclude(range, 0);
		assertEquals(0, xpand.getLowerBound(), .000000001d);
		assertEquals(4, xpand.getUpperBound(), .000000001d);
	}
	
	@Test
	public void test_MoreThan() {
		Range range = new Range(1, 4);
		Range xpand = Range.expandToInclude(range, 8);
		assertEquals(1, xpand.getLowerBound(), .000000001d);
		assertEquals(8, xpand.getUpperBound(), .000000001d);
		}
	
	@Test
	public void test_InRange() {
		Range range = new Range(1, 4);
		Range xpand = Range.expandToInclude(range, 2);
		assertEquals(1, xpand.getLowerBound(), .000000001d);
		assertEquals(4, xpand.getUpperBound(), .000000001d);
	}
	
}
