package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeBoundsGettersTest {
    private Range testRangeInt;
    private Range testRangeDec;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
        testRangeInt = new Range(3, 5);
        testRangeDec = new Range(-5.5, -2.5);
    }


    @Test
    public void boundGettersTest() {
        assertEquals("Lower bound of (-5.5, -2.5) should be -5.5", -5.5, testRangeDec.getLowerBound(), .000000001d);
        assertEquals("Upper bound of (-5.5, -2.5) should be -2.5", -2.5, testRangeDec.getLowerBound(), .000000001d);
        assertEquals("Lower bound of (3, 5) should be 3", 3, testRangeInt.getLowerBound(), .000000001d);
        assertEquals("Upper bound of (3, 5) should be 5", 5, testRangeInt.getLowerBound(), .000000001d);
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}