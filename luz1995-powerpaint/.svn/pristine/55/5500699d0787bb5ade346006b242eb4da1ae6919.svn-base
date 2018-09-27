/*
* TCSS 305 Autumn 2017
* Assignment5 PowerPaint
*/

package model;

import java.awt.Point;

/**
 * abstract class all tools need to extend.
 * 
 * @author Zhou Lu
 * @version 11/12/2017
 */

public abstract class AbstractTool implements Tool {
    
    /** A point outside the drawing area. */
    public static final Point NULL_POINT = new Point(-100, -100);
    
    /** A point to be the starting point.*/
    private Point myStartPoint;
    
    /** A point to be the ending point.*/
    private Point myEndPoint;
    
    /** A constructor.*/
    protected AbstractTool() {
        myStartPoint = NULL_POINT;
        myEndPoint = NULL_POINT;
    }
    
    /**
     * this method set the point to the start point.
     */
    @Override
    public void setStartPoint(final Point thePoint) {
        myStartPoint = (Point) thePoint.clone();
    }
    
    /**
     * this method set the point to the end point.
     */
    @Override
    public void setEndPoint(final Point thePoint) {
        myEndPoint = (Point) thePoint.clone();
    }
    
    /**
     * this method is to get start point. It is protected, 
     * limit other class to change the myStartPoint.
     * @return get the current tool start point.
     */
    protected Point getStartPoint() {
        return myStartPoint;
    }
    
    /**
     * this method is to get end point. It is protected, 
     * limit other class to change the myEndPoint.
     * @return get the current tool end point.
     */
    protected Point getEndPoint() {
        return myEndPoint;
    }
}
