//TCSS 305 Autumn 2017
//Assignment powerpaint

package model;

import java.awt.Point;
import java.awt.Shape;

/**
 * 
 * @author Zhou Lu
 * @version 11/22/2017
 */
public interface Tool {

    /**
     * return the shape the current tool using.
     * @return return shape.
     */
    Shape getShape();
    
    /**
     * set thePoint to the starting point.
     * @param thePoint set to Starting Point.
     */
    void setStartPoint(Point thePoint);
    
    /**
     * set thePoint to the ending point.
     * @param thePoint set to Ending Point.
     */
    void setEndPoint(Point thePoint);
}
