package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeIntersectsTest {
    private Range testRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
        testRange = new Range(-2.5, 2.5);
    }


    @Test
    public void IntersectionTest() {
        assertTrue("Ranges (-2.5, 2.5) and (2, 4) should overlap", testRange.intersects(2, 4));
        assertFalse("Ranges (-2.5, 2.5) and (5, 8) should not overlap", testRange.intersects(5, 8));
        assertTrue("Ranges (-2.5, 2.5) and (-2.5, 2.5) should overlap", testRange.intersects(-2.5, 2.5));
        assertTrue("Ranges (-2.5, 2.5) and (-5.4, -2.4) should overlap", testRange.intersects(-5.4, -2.4));
        assertFalse("Ranges (-2.5, 2.5) and (-5.6, -2.6) should not overlap", testRange.intersects(-5.6, -2.6));
        assertTrue("Ranges (-2.5, 2.5) and (-3, 3) should overlap", testRange.intersects(-3, 3));
        assertTrue("Ranges (-2.5, 2.5) and (-2, 2) should overlap", testRange.intersects(-2, 2));
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}