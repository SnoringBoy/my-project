/*
* TCSS 305 Autumn 2017
* Assignment5 PowerPaint
*/

package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import model.LineTool;
import model.PencilTool;
import model.PreviousDrawing;
import model.Tool;



/**
 * A painting panel.
 * 
 * @author Zhou Lu
 * @version 11/11/2017
 */
public class PaintPanel extends JPanel {
    

    /**
     * The panel width.
     */
    public static final int WIDTH = 400;
    
    /**
     * The panel height.
     */
    public static final int HEIGHT = 400;
    
    /**
     * The default width.
     */
    public static final int DEFAULT_WIDTH = 5;
    
    /**
     * The default fill color.
     */
    public static final Color DEFAULT_FILL_COLOR = new Color(232, 211, 162);
    
    /**
     * The default fill color.
     */
    public static final Color DEFAULT_COLOR = new Color(51, 0, 111);
    
    /**
     * a generated id.
     */
    private static final long serialVersionUID = 4910397799338910759L;

    /**
     * The background color of the panel.
     */
    private Color myColor;

    /**
     * The color to paint with.
     */
    private Color myFillColor;

    /** a value to indicate the shape is filled or not.*/
    private boolean myFillOrNot;
    
    /**
     * The line width.
     */
    private int myWidth;
    
    /** a field to refer to current tool.*/
    private Tool myCurrentTool;
    
    /** a field for star point in panel.*/
    private Point myStartPoint;
    
    /** a field for end point in panel.*/
    private Point myEndPoint;
    
    /** a array list to have the previous drawing shape.*/
    private final List<PreviousDrawing> myPreviousShape;
    
    /** a boolean value to indicate clear or not.*/
    private boolean myClearOrNot;
    
    // Constructor

    /**
     * Constructs a new general path panel.
     */
    public PaintPanel() {
        super();
        myPreviousShape = new ArrayList<>();
        myCurrentTool = new LineTool();
        myWidth = DEFAULT_WIDTH;
        myFillColor = DEFAULT_FILL_COLOR;
        myColor = DEFAULT_COLOR;
        myFillOrNot = false;
        myClearOrNot = false;
        setUpPanel();
    }
    
    /**
     * a set method to change the field myWidth.
     * @param theWidth the width to set myWidth.
     */
    public void setMyWidth(final int theWidth) {
        myWidth = theWidth;
    }
    
    /**
     * a set method to change the field myColor.
     * @param theColor the color to set myColor.
     */
    public void setMyColor(final Color theColor) {
        myColor = theColor;
    }
    
    /**
     * a set method to change the field myFillColor.
     * @param theColor the color to set myFillColor.
     */
    public void setMyFillColor(final Color theColor) {
        myFillColor = theColor;
    }
    
    /**
     * a set method to change the myFillOrNot.
     * @param theFillOrNot theFillOrNot set to myFillOrNot.
     */
    public void setMyFillOrNot(final boolean theFillOrNot) {
        myFillOrNot = theFillOrNot;
    }
    
    /**
     * a get method to see the myFillOrNot.
     * @return return myFillOrNot
     */
    public boolean isMyFillOrNot() {
        return myFillOrNot;
    }
    
    /**
     * a set method to set the clear or not also set the propertyChange.
     * @param theClearOrNot the clearOrNot to set to myClearOrNot.
     */
    public void setMyClearOrNot(final boolean theClearOrNot) {
        
        myClearOrNot = theClearOrNot;
    }
    
    /**
     * a get method to see the clear or not.
     * @return return myClearOrNot.
     */
    public boolean isClearOrNot() {
        return myClearOrNot;
    }
    
    /**
     * a get method to get the myPreviousShape.
     * @return return myPreviousShape.
     */
    public List<PreviousDrawing> getMyPreviousShape() {
        return myPreviousShape;
    } 
    
    /**
     * set up the paint panel.
     */
    private void setUpPanel() {
        
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        
        final MouseInputAdapter mouseHandler = new MyMouseHandler();
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
        
    }
    
    /**
     * to set the current tool to the panel.
     * @param theTool the tool currently being used.
     */
    public void setCurrentTool(final Tool theTool) {
        myCurrentTool = theTool;
    }

    /**
     * Paints the current path.
     * @param theGraphics The graphics context to use for painting.
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        
        firePropertyChange("clearbutton", null, !myPreviousShape.isEmpty());
        
        for (final PreviousDrawing s : myPreviousShape) {            
            g2d.setPaint(s.getColor());
            g2d.setStroke(new BasicStroke(s.getWidth()));
            g2d.draw(s.getShape());
            if (s.isFillOrNot() && !(s.getShape() instanceof Line2D.Double)
                                && !(s.getShape() instanceof GeneralPath)) {
                g2d.setPaint(s.getFillColor());
                g2d.fill(s.getShape());
            }
        }
        
        if (!myClearOrNot) {
            g2d.setPaint(myColor);
            g2d.setStroke(new BasicStroke(myWidth));
            g2d.draw(myCurrentTool.getShape());
            if (isMyFillOrNot() && !(myCurrentTool instanceof LineTool)
                            && !(myCurrentTool instanceof PencilTool)) {
                g2d.setPaint(myFillColor);
                g2d.fill(myCurrentTool.getShape());
            }
        }
        
    }

    // Inner Class

    /**
     * Listens for mouse clicks, to draw on our panel.
     */
    private class MyMouseHandler extends MouseInputAdapter {
        
        @Override
        public void mousePressed(final MouseEvent theEvent) {
            myStartPoint = theEvent.getPoint();
            myEndPoint = myStartPoint;
            myCurrentTool.setStartPoint(myStartPoint);
            setMyClearOrNot(false);
            
        }
        
        @Override
        public void mouseReleased(final MouseEvent theEvent) {
            myEndPoint = theEvent.getPoint();
            myPreviousShape.add(new PreviousDrawing(myCurrentTool.getShape(),
                                                    myWidth, myColor, 
                                                    myFillColor, myFillOrNot));
            repaint();
        }
        
        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            myEndPoint = theEvent.getPoint();
            myCurrentTool.setEndPoint(myEndPoint);
            repaint();
        }
    }
}
