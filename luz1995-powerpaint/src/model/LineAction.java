package model;

import gui.PaintPanel;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;


/**
 * a class that for line drawing.
 * 
 * @author Zhou Lu
 * @version 11/11/2017
 */
public class LineAction extends AbstractAction {

    /** a generated ID.*/
    private static final long serialVersionUID = 3956036312438469711L;

    /** a field that stores the description of the action. */
    private static final String LINE_STRING = "Line";
    
    /** a field to store the PaintPanel. */
    private final PaintPanel myPanel;

    
    /**
     * construct the LineAction.
     * @param thePanel receive the Panel from the caller.
     */
    public LineAction(final PaintPanel thePanel) {
        super(LINE_STRING, new ImageIcon("/resources/line.gif"));
        myPanel = thePanel;
        putValue(Action.SHORT_DESCRIPTION, LINE_STRING);
        putValue(Action.SELECTED_KEY, "anything other than null!");
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(new LineTool());
    }
}
