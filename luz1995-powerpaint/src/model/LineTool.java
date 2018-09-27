/*
* TCSS 305 Autumn 2017
* Assignment5 PowerPaint
*/

package model;

import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 * a class for the Line drawing.
 * 
 * @author Zhou Lu
 * @version 11/12/2017
 */
public class LineTool extends AbstractTool {

    @Override
    public Shape getShape() {
        return new Line2D.Double(getStartPoint(), getEndPoint());      
    }
 
}
