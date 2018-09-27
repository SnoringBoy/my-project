/*
* TCSS 305 Autumn 2017
* Assignment5 PowerPaint
*/

package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.PreviousDrawing;

/**
 * 
 * @author Zhou Lu
 * @version 11/11/2017
 */
public class GUIMenuBar extends JMenuBar implements PropertyChangeListener {

    /** a generated ID.*/
    private static final long serialVersionUID = 7942609664174632315L;
    
    /** major tick spacing for the slider. */ 
    private static final int MAJOR_TICK_SPACING = 5;

    /** minor tick spacing for the slider. */ 
    private static final int MINOR_TICK_SPACING = 1;

    /** maximum of the slider. */ 
    private static final int MAX_FRAMES = 25;

    /** initial start value of the slider.*/
    private static final int INITIAL_FRAMES = 5;
    
    /** a default color field.*/
    private static final Color UW_COLOR = new Color(51, 0, 111);
    
    /**
     * The default fill color.
     */
    private static final Color DEFAULT_FILL_COLOR = new Color(232, 211, 162);
    
    /** A button group for radio buttons. */
    private final ButtonGroup myGroup;
    
    /** A button to show the about JOptionPane. */
    private JMenuItem myAboutButton;
    
    /** A menuitem for the thickness. */
    private JMenu myThickness;
    
    /** A menuitem for the the Draw color. */
    private JMenuItem myDrawColor;
    
    /** A  to show the about JOptionPane. */
    private JMenuItem myFillColor;
    
    /** A  field for the checkbox. */
    private JCheckBox myFillCheck;
    
    /** A field for the clear button. */
    private JMenuItem myClear;
    
    /** a field for the option menu.*/
    private JMenu myOptionsMenu;
    
    /** a field for the tool menu.*/
    private JMenu myToolsMenu;
    
    /** a field for the help menu.*/
    private JMenu myHelpMenu;
   
    /** a field to refer to the panel.*/
    private final PaintPanel myPanel;
    
    /**
     * construct the menu bar.
     * @param theFrame the frame to use.
     * @param thePanel the Panel to draw. 
     */
    public GUIMenuBar(final JFrame theFrame, final PaintPanel thePanel) {
        super();

        myGroup = new ButtonGroup();
        myPanel = thePanel;
        setUpMenuItem();      
        setup(theFrame);
    }
    
    /** 
     * method to setUp all the menu item.
     */
    private void setUpMenuItem() {
        
        myAboutButton = new JMenuItem("About...");
        myDrawColor = new JMenuItem("Draw Color...");
        myFillColor = new JMenuItem("Fill Color...");
        myThickness = new JMenu("Thickness");
        myFillCheck = new JCheckBox("Fill");
        myClear = new JMenuItem("Clear");
//        myClear.setEnabled(false);
        
    }

    /**
     * Sets up the components of the menu.
     * @param theFrame the JFrame containing this menu.
     */
    private void setup(final JFrame theFrame) {
        myOptionsMenu = new JMenu("Options");
        myToolsMenu = new JMenu("Tools");
        myHelpMenu = new JMenu("Help");
        
        myAboutButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                
                
                final ImageIcon img = new ImageIcon("./src/resources/pubg.jpg");
                
                JOptionPane.showMessageDialog(null, "TCSS 305 PowerPaint\n"
                                + "Autumn 2017\n"
                                + "Zhou Lu", "About", JOptionPane.INFORMATION_MESSAGE, img);
            }
        });
             
        myOptionsMenu.add(myThickness);
        myOptionsMenu.addSeparator();
        myOptionsMenu.add(myDrawColor);
        myOptionsMenu.add(myFillColor);
        myOptionsMenu.addSeparator();
        myOptionsMenu.add(myFillCheck);
        myOptionsMenu.addSeparator();
        myOptionsMenu.add(myClear);
        myHelpMenu.add(myAboutButton);
        add(myOptionsMenu);
        add(myToolsMenu);
        add(myHelpMenu);
        setUpSlider();
        setUpDrawColor();
        setUpFillColor();
        setUpFillCheck();
        setUpClear();
        theFrame.pack();
    }

    /**
     * Creates a radio button menu item, associates an action with the button,
     * adds the button to a button group, adds the button to the View menu.
     * 
     * @param theAction the Action to associate with the new button being
     *            created
     */
    public void createMenuButton(final Action theAction) {
        final JRadioButtonMenuItem createdButton = new JRadioButtonMenuItem(theAction);
        myGroup.add(createdButton);
        myToolsMenu.add(createdButton);
    }
    
    /**
     * this method is for setting up the slider.
     */
    private void setUpSlider() {
        
        final JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, MAX_FRAMES,
                               INITIAL_FRAMES);
        slider.setMajorTickSpacing(MAJOR_TICK_SPACING);
        slider.setMinorTickSpacing(MINOR_TICK_SPACING);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener() {
            /** Called in response to slider events in this window. */
            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                final int value = slider.getValue();
                myPanel.setMyWidth(value);
            }
        });
        myThickness.add(slider);
    }
    
    /**
     * this method is for setting up the slider.
     */
    private void setUpDrawColor() {
        
        myDrawColor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
               
                final Color color = JColorChooser.showDialog(null, "Pick a color", UW_COLOR);
                myPanel.setMyColor(color);
                
            }
        });
    }
    
    /**
     * this method is for setting up the slider.
     */
    private void setUpFillColor() {
        
        myFillColor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
               
                final Color color = JColorChooser.showDialog(null, "Pick a fill color", 
                                                             DEFAULT_FILL_COLOR);
                myPanel.setMyFillColor(color);
                
            }
        });
    }
    
    /**
     * this method is for setting up the slider.
     */
    private void setUpFillCheck() {
        
        myFillCheck.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
       
                    myPanel.setMyFillOrNot(myFillCheck.isSelected());            
            }
        });
    }
    
    /**
     * this method is for setting up the clear.
     */
    private void setUpClear() {
        
        myClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
               
                myPanel.getMyPreviousShape().clear();
                myPanel.setMyClearOrNot(true);
                myPanel.repaint();
            }
        });
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("clearbutton".equals(theEvent.getPropertyName())) {
            System.out.println("hello");
            myClear.setEnabled(!myPanel.getMyPreviousShape().isEmpty());
        }
    }
}
