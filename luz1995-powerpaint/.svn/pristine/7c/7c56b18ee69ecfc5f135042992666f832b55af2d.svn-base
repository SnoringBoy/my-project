/*
* TCSS 305 Autumn 2017
* Assignment5 PowerPaint
*/

package model;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;



/**
 * a class for the Ellipse drawing.
 * 
 * @author Zhou Lu
 * @version 11/12/2017
 */
public class EllipseTool extends AbstractTool {

    @Override
    public Shape getShape() {
        
        final Ellipse2D.Double ellipse = new Ellipse2D.Double();
        final Point start = getStartPoint();
        final Point end =  getEndPoint();
        ellipse.setFrameFromDiagonal(start, end);
        return ellipse;
    }
 
}