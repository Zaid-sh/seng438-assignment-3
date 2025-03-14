package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeGetLengthTest {
	
	private Range Range_one;
	private Range Range_two;
	private Range Range_three;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception { 
		Range_one = new Range(-1, 1);
		Range_two = new Range(0, 0);
		Range_three = new Range(0, 2.3);
	}

	@After
	public void tearDown() throws Exception {	
	}

	@Test
	public void test() {
		assertEquals("The length of -1 and 1 should be 2",
				2, Range_one.getLength(), .000000001d);
		assertEquals("The length of 0 and 0 should be 0",
				0, Range_two.getLength(), .000000001d);
		assertEquals("The length of 0 and 2.3 should be 2.3",
				2.3, Range_three.getLength(), .000000001d);
	}

}
