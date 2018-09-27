/*
* TCSS 305 Autumn 2017
* Assignment5 PowerPaint
*/

package gui;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * tool bar class for the power paint program.
 * @author Zhou Lu
 * @version 11/11/2017
 */
public class GUIToolBar extends JToolBar {
    
    /** A generated ID.*/
    private static final long serialVersionUID = -8892071970020001223L;
    
    /** a field that is ButtonGroup object.*/
    private final ButtonGroup myButtonGroup;
    
    /**
     * 
     */
    public GUIToolBar() {
        super();
        myButtonGroup = new ButtonGroup();
    }
    
    /**
     * method to create JToggleButton for the tool bar.
     * @param theAction action received from the caller.
     */
    public void createToolBarButton(final Action theAction) {
        final JToggleButton toggleButton = new JToggleButton(theAction);
        myButtonGroup.add(toggleButton);
        myButtonGroup.clearSelection();
        add(toggleButton);       
    }
    
    

}
