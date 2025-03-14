package org.jfree.data.test;

import static org.junit.Assert.*; 

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeConstrainTest {

	private Range Range_one;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Range_one = new Range(-1, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("-1 should be the closest (in-range) value to -3", -1, Range_one.constrain(-3), .000000001d);
		assertEquals("1 should be the closest (in-range) value to 4", 1, Range_one.constrain(4), .000000001d);
		assertEquals("0.1 should be returned as it is in range of -1 and 1", 0.1, Range_one.constrain(0.1), .000000001d);
	}

}