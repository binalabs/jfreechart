package org.jfree.chart.renderer.xy;

import java.math.BigDecimal;

/**
 * Represents already drawn point in the graphics.
 * Every (x, y) has scale of 2 and is rounded half up.
 */
public class PathPoint {

    private final BigDecimal x;
    private final BigDecimal y;

    public PathPoint(double x, double y) {
        this.x = round(x);
        this.y = round(y);
    }

    public boolean isIdentical(PathPoint point) {
        BigDecimal z = point.x;
        BigDecimal v = point.y;
        return (z.compareTo(x) == 0) && (v.compareTo(y) == 0);
    }

    private BigDecimal round(double x) {
        return BigDecimal.valueOf(x).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
