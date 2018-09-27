/*
* TCSS 305 Autumn 2017
* Assignment5 PowerPaint
*/

package model;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;


/**
 * a class for the Rectangle drawing.
 * 
 * @author Zhou Lu
 * @version 11/12/2017
 */
public class RectangleTool extends AbstractTool {

    @Override
    public Shape getShape() {
        
        final Rectangle2D.Double rectangle = new Rectangle.Double();
        final Point start = getStartPoint();
        final Point end =  getEndPoint();
        rectangle.setFrameFromDiagonal(start, end);
        return rectangle;
    }
 
}