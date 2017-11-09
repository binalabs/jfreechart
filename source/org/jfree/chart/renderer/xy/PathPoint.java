/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2017, by Roche Sequencing Solutions and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.]
 *
 * --------------
 * PathPoint.java
 * --------------
 * (C) Copyright 2017, Roche Sequencing Solutions.
 *
 * Original Author:  Maciej Pawlaczyk (for Roche Sequencing Solutions);
 * Contributor(s):   -;
 *
 */

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
