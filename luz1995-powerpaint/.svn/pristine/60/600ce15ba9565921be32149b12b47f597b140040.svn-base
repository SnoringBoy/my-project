package model;

import gui.PaintPanel;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;


/**
 * When Eclipse is chosen, the action perform.
 * 
 * @author Zhou Lu
 * @version 11/12/2017
 */
public class EllipseAction extends AbstractAction {

    /** a generated ID. */
    private static final long serialVersionUID = -3761367112560373809L;

    /** a field that stores the description of the action. */
    private static final String ELLIPSE_STRING = "Ecllipse";
    
    /** a field to store the PaintPanel. */
    private final PaintPanel myPanel;

    
    /**
     * construct the LineAction.
     * @param thePanel receive the Panel from the caller.
     */
    public EllipseAction(final PaintPanel thePanel) {
        super(ELLIPSE_STRING, new ImageIcon("./src/resources/ellipse.gif"));
        myPanel = thePanel;
        putValue(Action.SHORT_DESCRIPTION, ELLIPSE_STRING);
        putValue(Action.SELECTED_KEY, "anything other than null!");
    }


    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(new EllipseTool());
    }
}
