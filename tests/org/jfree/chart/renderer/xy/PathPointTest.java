package org.jfree.chart.renderer.xy;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PathPointTest {

    @Test
    public void zerosAreIdentical() throws Exception {
        final PathPoint first = new PathPoint(0d, 0d);
        final PathPoint second = new PathPoint(0d, 0d);
        assertTrue(first.isIdentical(second));
        assertTrue(second.isIdentical(first));
    }

    @Test
    public void shouldRecognizeAsIdenticalWithTwoDecimalPointsRounding() throws Exception {
        final PathPoint first = new PathPoint(20.011d, 20.0166d);
        final PathPoint second = new PathPoint(20.01d, 20.02d);
        assertTrue(first.isIdentical(second));
        assertTrue(second.isIdentical(first));
    }
}
