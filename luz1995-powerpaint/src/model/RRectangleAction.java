package model;

import gui.PaintPanel;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;


/**
 * 
 * @author Zhou Lu
 *  @version 11/11/2017
 */
public class RRectangleAction extends AbstractAction {

    /** a generated ID. */
    private static final long serialVersionUID = 6884740257865269903L;

    /** a field that stores the description of the action. */
    private static final String RRECTANGLE_STRING = "RoundRectangle";

    /** a field to store the PaintPanel. */
    private final PaintPanel myPanel;

    
    /**
     * construct the LineAction.
     * @param thePanel receive the Panel from the caller.
     */
    public RRectangleAction(final PaintPanel thePanel) {
        super(RRECTANGLE_STRING, new ImageIcon("./src/resources/roundrectangle.gif"));
        myPanel = thePanel;
        putValue(Action.SHORT_DESCRIPTION, RRECTANGLE_STRING);
        putValue(Action.SELECTED_KEY, "anything other than null!");
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(new RRectangleTool());
    }
}
