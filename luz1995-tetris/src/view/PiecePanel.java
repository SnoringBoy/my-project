
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import model.Block;
import model.MovableTetrisPiece;

/**
 * a class for next piece panel.
 * @author Zhou Lu
 * @version 12/3/2017
 */
public class PiecePanel extends JPanel implements Observer {
    
    /**
     * a generated ID.
     */
    private static final long serialVersionUID = -6388914396647242356L;

    /**
     * constant define size.
     */
    private static final Dimension DEFAULT_SIZE = new Dimension(90, 90);
    
    /**
     * a field to hold the shape.
     */
    private final List<RoundRectangle2D.Double> myShape;
    
    
    /**
     * a outerPanel to contain the piecePanel.
     */
    private final JPanel myOuterPanel;
    
    /**
     * a field to store the color.
     */
    private Color myColor;
    
    /**
     * a constructor.
     */
    public PiecePanel() {
        super();
        setPreferredSize(DEFAULT_SIZE);
        setBackground(Color.WHITE);
        myShape = new ArrayList<>();
        myColor = Color.BLACK;
        myOuterPanel = new JPanel();
        setUpPanels();
        
    }
    
    /**
     * set up display panel.
     */
    private void setUpPanels() {
        final int positionX = 1;
        final int positionY = 1;
        myOuterPanel.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.gridx = positionX;
        c.gridy = positionY;
        myOuterPanel.add(this);
    }
    
    /**
     * a get method for returning the outer panel.
     * @return myOuterPanel.
     */
    public JPanel getOuterPanel() {
        return myOuterPanel;
    }
    
    /**
     * a method to set block to the shape.
     * @param theBlock the block to check what type of block.
     */
    public void setShape(final Block theBlock) {
        
        if ("J".equals(theBlock.toString())) {          
            handleJ();
        }
        
        if ("I".equals(theBlock.toString())) {
            handleI();
        }
        
        if ("L".equals(theBlock.toString())) {
            handleL();
        }
        
        if ("O".equals(theBlock.toString())) {
            handleO();
        }
        
        if ("S".equals(theBlock.toString())) {
            handleS();
        }
        
        if ("T".equals(theBlock.toString())) {
            handleT();
        }
        
        if ("Z".equals(theBlock.toString())) {
            handleZ();
        }
    }
    
    /**
     * a helper method to handle the block I.
     */
    private void handleI() {
        // whatever the size of the panel is, divide it into  9 * 9;
        final int sideLength = (int) getSize().getWidth() / 9;
        // different block has different starting x, y to make sure the block is on center.
        //most top and left piece is the starting x, y.
        final int startingX = (int) (this.getSize().getWidth() / 9 * 2.5);
        final int startingY = (int) this.getSize().getHeight() / 9 * 4;
        
        final int arcHeight = 45;
        final int arcWidth = 45;
        myShape.add(new RoundRectangle2D.Double(startingX, 
                                                startingY, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + sideLength, 
                                                startingY, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + 2 * sideLength, 
                                                startingY, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + sideLength 
                                                + sideLength + sideLength, 
                                                startingY, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myColor = Color.CYAN;
//        System.out.print(startingX);
    }
    
    /**
     * a helper method to handle the block J.
     */
    private void handleJ() { 
        // whatever the size of the panel is, divide it into  9 * 9;
        final int sideLength = (int) getSize().getWidth() / 9;
        // different block has different starting x, y to make sure the block is on center.
        //most top and left piece is the starting x, y.
        final int startingX = (int) this.getSize().getWidth() / 3;
        final int startingY = (int) this.getSize().getHeight() / 2 - sideLength;
        
        final int arcHeight = 45;
        final int arcWidth = 45;
        myShape.add(new RoundRectangle2D.Double(startingX, 
                                                startingY, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX, 
                                                startingY + sideLength, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + sideLength, 
                                                startingY + sideLength, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + 2 * sideLength, 
                                                startingY + sideLength, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myColor = Color.BLUE;
//        System.out.print(startingX);
    }
    
    /**
     * a helper method to handle the block L.
     */
    private void handleL() {
        // whatever the size of the panel is, divide it into  9 * 9;
        final int sideLength = (int) getSize().getWidth() / 9;
        // different block has different starting x, y to make sure the block is on center.
        //most top and left piece is the starting x, y.
        final int startingX = (int) this.getSize().getWidth() / 3;
        final int startingY = (int) this.getSize().getHeight() / 2;
        
        final int arcHeight = 45;
        final int arcWidth = 45;
        myShape.add(new RoundRectangle2D.Double(startingX, 
                                                startingY, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + sideLength, 
                                                startingY, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + 2 * sideLength, 
                                                startingY, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + 2 * sideLength, 
                                                startingY - sideLength, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myColor = Color.ORANGE;
    }
    
    /**
     * a helper method to handle the block O.
     */
    private void handleO() {
        // whatever the size of the panel is, divide it into  9 * 9;
        final int sideLength = (int) getSize().getWidth() / 9;
        // different block has different starting x, y to make sure the block is on center.
        //most top and left piece is the starting x, y.
        final int startingX = (int) this.getSize().getWidth() / 2 - sideLength;
        final int startingY = (int) this.getSize().getHeight() / 2 - sideLength;
        
        final int arcHeight = 45;
        final int arcWidth = 45;
        myShape.add(new RoundRectangle2D.Double(startingX, 
                                                startingY, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + sideLength, 
                                                startingY, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX, 
                                                startingY + sideLength, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + sideLength, 
                                                startingY + sideLength, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myColor = Color.YELLOW;
    }
    
    /**
     * a helper method to handle the block S.
     */
    private void handleS() {
        // whatever the size of the panel is, divide it into  9 * 9;
        final int sideLength = (int) getSize().getWidth() / 9;
        // different block has different starting x, y to make sure the block is on center.
        //most top and left piece is the starting x, y.
        final int startingX = (int) this.getSize().getWidth() / 3;
        final int startingY = (int) this.getSize().getHeight() / 2;
        
        final int arcHeight = 45;
        final int arcWidth = 45;
        myShape.add(new RoundRectangle2D.Double(startingX, 
                                                startingY, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + sideLength, 
                                                startingY, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + sideLength, 
                                                startingY - sideLength, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + 2 * sideLength, 
                                                startingY - sideLength, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myColor = Color.GREEN;
    }
    
    /**
     * a helper method to handle the block T.
     */
    private void handleT() {
        // whatever the size of the panel is, divide it into  9 * 9;
        final int sideLength = (int) getSize().getWidth() / 9;
        // different block has different starting x, y to make sure the block is on center.
        //most top and left piece is the starting x, y.
        final int startingX = (int) this.getSize().getWidth() / 3;
        final int startingY = (int) this.getSize().getHeight() / 2;
        
        final Color purple = new Color(255, 0, 255);
        final int arcHeight = 45;
        final int arcWidth = 45;
        myShape.add(new RoundRectangle2D.Double(startingX, 
                                                startingY, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + sideLength, 
                                                startingY, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + sideLength, 
                                                startingY - sideLength, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + 2 * sideLength, 
                                                startingY, 
                                                sideLength, sideLength, 
    
                                                arcWidth, arcHeight));
        myColor = purple;
    }
    
    /**
     * a helper method to handle the block Z.
     */
    private void handleZ() {
        // whatever the size of the panel is, divide it into  9 * 9;
        final int sideLength = (int) getSize().getWidth() / 9;
        // different block has different starting x, y to make sure the block is on center.
        //most top and left piece is the starting x, y.
        final int startingX = (int) this.getSize().getWidth() / 3;
        final int startingY = (int) this.getSize().getHeight() / 2 - sideLength;
        
        
        final int arcHeight = 45;
        final int arcWidth = 45;
        myShape.add(new RoundRectangle2D.Double(startingX, 
                                                startingY, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + sideLength, 
                                                startingY, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + sideLength, 
                                                startingY + sideLength, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myShape.add(new RoundRectangle2D.Double(startingX + 2 * sideLength, 
                                                startingY + sideLength, 
                                                sideLength, sideLength, 
                                                arcWidth, arcHeight));
        myColor = Color.RED;
    }
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                             RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(myColor);
//        g2d.translate(20, 60);
        for (final Shape s : myShape) {
            g2d.fill(s);
        }
        myShape.clear();
    }

    @Override
    public void update(final Observable theObservable, final Object theArg) {
        if (theArg instanceof MovableTetrisPiece) { 
            setShape(((MovableTetrisPiece) theArg).getBlock());
            repaint();
        }      
    }
 
}
