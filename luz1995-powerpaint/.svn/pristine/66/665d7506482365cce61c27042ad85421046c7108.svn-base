/*
* TCSS 305 Autumn 2017
* Assignment5 PowerPaint
*/

package model;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;



/**
 * a class for the Round Rectangle drawing.
 * 
 * @author Zhou Lu
 * @version 11/12/2017
 */
public class RRectangleTool extends AbstractTool {
    
    /** The height of the arc that rounds off the corners.*/
    private static final double  ARCHEIGHT = 37;
    
    /** The width of the arc that rounds off the corners.*/
    private static final double  ARCWIDTH = 37;
    
    @Override
    public Shape getShape() {       
        final RoundRectangle2D.Double roundRectangle 
             = new RoundRectangle2D.Double(getStartPoint().getX(), 
                                      getStartPoint().getY(), 
                                      getStartPoint().getX() - getEndPoint().getX(),
                                      getStartPoint().getY() - getEndPoint().getY(),
                                      ARCHEIGHT, ARCWIDTH);
        final Point start = getStartPoint();
        final Point end =  getEndPoint();
        roundRectangle.setFrameFromDiagonal(start, end);
        return roundRectangle;
    }
 
}