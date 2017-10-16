package org.jfree.chart.renderer.xy;

import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

/**
 * This renderer generates only {@link Path2D} objects.
 * <p>
 * It implements "sampling" feature. It draws only points that
 * are not identical with previous. Points comparison is based
 * on assumption that drawn point has scale 2 and is rounded half up.
 * This statement is made here: {@link PathPoint#isIdentical(PathPoint)}.
 */
public class XYPathsRenderer extends XYLineAndShapeRenderer {

    private PathPoint last = new PathPoint(-1d, -1d);

    public XYPathsRenderer(boolean lines, boolean shapes) {
        super(lines, shapes);
        this.setDrawSeriesLineAsPath(true);
    }

    @Override
    protected void drawPrimaryLineAsPath(XYItemRendererState state, Graphics2D g2, XYPlot plot, XYDataset dataset, int pass, int series, int item, ValueAxis domainAxis, ValueAxis rangeAxis, Rectangle2D dataArea) {
        RectangleEdge xAxisLocation = plot.getDomainAxisEdge();
        RectangleEdge yAxisLocation = plot.getRangeAxisEdge();

        // get the data point...
        double x1 = dataset.getXValue(series, item);
        double y1 = dataset.getYValue(series, item);
        double transX1 = domainAxis.valueToJava2D(x1, dataArea, xAxisLocation);
        double transY1 = rangeAxis.valueToJava2D(y1, dataArea, yAxisLocation);
        final PathPoint newPoint = new PathPoint(transX1, transY1);
        if (!last.isIdentical(newPoint)) {
            super.drawPrimaryLineAsPath(state, g2, plot, dataset, pass, series, item, domainAxis, rangeAxis, dataArea);
            last = newPoint;
        }
    }

}
