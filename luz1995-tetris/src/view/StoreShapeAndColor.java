
package view;

import java.awt.Color;
import java.awt.geom.RoundRectangle2D;

/**
 *  a class for StoreShapeAndColor.
 * @author Zhou Lu
 * @version 11/29/2017
 */
public class StoreShapeAndColor {
    
    /**
     * a field to hold the shape.
     */
    private final RoundRectangle2D.Double myShape;
    
    /**
     * a field to hold the color.
     */
    private final Color myColor;
    
    /**
     * a constructor take shape and color.
     * @param theShape set theShape to myShape.
     * @param theColor set theColor to myColor.
     */
    public StoreShapeAndColor(final RoundRectangle2D.Double theShape, final Color theColor) {
        myShape = theShape;
        myColor = theColor;    
    }
    
    /**
     * a get method to get the shape of the object.
     * @return myShape.
     */
    public RoundRectangle2D.Double getShape() {
        return myShape;
    }
    
    /**
     * a get method to get the color of the object.
     * @return myColor.
     */
    public Color getColor() {
        return myColor;
    }
}
