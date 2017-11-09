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
 * PathPointTest.java
 * --------------
 * (C) Copyright 2017, Roche Sequencing Solutions.
 *
 * Original Author:  Maciej Pawlaczyk (for Roche Sequencing Solutions);
 * Contributor(s):   -;
 *
 */

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
