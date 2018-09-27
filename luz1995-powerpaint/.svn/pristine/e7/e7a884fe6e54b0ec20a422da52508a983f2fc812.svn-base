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
public class PencilAction extends AbstractAction {

    /** A generated serialization ID.*/
    private static final long serialVersionUID = -3582869610604795939L;

    /** a field that stores the description of the action. */
    private static final String PENCIL_STRING = "Pencil";
    
    /** a field to store the PaintPanel. */
    private final PaintPanel myPanel;

    
    /**
     * construct the LineAction.
     * @param thePanel receive the Panel from the caller.
     */
    public PencilAction(final PaintPanel thePanel) {
        super(PENCIL_STRING, new ImageIcon("./src/resources/pencil.gif"));
        myPanel = thePanel;
        putValue(Action.SHORT_DESCRIPTION, PENCIL_STRING);
        putValue(Action.SELECTED_KEY, "anything other than null!");
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(new PencilTool());
    }

}