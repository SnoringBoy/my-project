/*
* TCSS 305 Autumn 2017
* Assignment5 PowerPaint
*/

package model;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;

/**
 * a class for the Line drawing.
 * 
 * @author Zhou Lu
 * @version 11/12/2017
 */
public class PencilTool extends AbstractTool {

    /** a path field.*/
    private Path2D myPath;
      
    /** since this class has a field, need to have a constructor.*/
    public PencilTool() {
        super();
        myPath = new GeneralPath();
        
    }
    
    @Override
    public void setStartPoint(final Point thePoint) {
        myPath = new GeneralPath();
        myPath.moveTo(thePoint.getX(), thePoint.getY());
       
    }
    
    @Override
    public Shape getShape() {
        myPath.setWindingRule(GeneralPath.WIND_EVEN_ODD);

        myPath.lineTo(getEndPoint().getX(), getEndPoint().getY());
        return myPath;   
        
    }
 
}
