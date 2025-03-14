package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeContainsTest {
	
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
		assertTrue("-1 should be in the range of -1, 1", Range_one.contains(-1));
		assertTrue("1 should be in the range of -1, 1", Range_one.contains(1));
		assertTrue("0.7 should be in the range of -1, 1", Range_one.contains(0.7));
		assertFalse("2 shouldn't be in the range of -1, 1", Range_one.contains(2));
	}

}