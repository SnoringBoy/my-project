package model;

import gui.PaintPanel;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;


/**
 * 
 * @author Zhou Lu
 * @version 11/11/2017
 */
public class RectangleAction extends AbstractAction {

    /** A generated serialization ID.*/
    private static final long serialVersionUID = 2738994100249051606L;
    
    /** a field that stores the description of the action. */
    private static final String RECTANGLE_STRING = "Rectangle";

    /** a field to store the PaintPanel. */
    private final PaintPanel myPanel;

    
    /**
     * construct the LineAction.
     * @param thePanel receive the Panel from the caller.
     */
    public RectangleAction(final PaintPanel thePanel) {
        super(RECTANGLE_STRING, new ImageIcon("./src/resources/rectangle.gif"));
        myPanel = thePanel;
        putValue(Action.SHORT_DESCRIPTION, RECTANGLE_STRING);
        putValue(Action.SELECTED_KEY, "anything other than null!");
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(new RectangleTool());
    }

}
