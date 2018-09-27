/*
* TCSS 305 Autumn 2017
* Assignment5 PowerPaint
*/

package gui;

import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
* Starts the power paint.
* 
* @author Zhou Lu
* @version 11/11/2017
*/
public final class GUIMain {

   /**
    * Private constructor to inhibit external instantiation.
    */
    private GUIMain() {
        throw new IllegalStateException();
    }

    
    /**
     * method set up for setting up the LookAndFeel.
     */
    private static void setLookAndFeel() {
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        
        } catch (final UnsupportedLookAndFeelException e) {
            System.out.println("UnsupportedLookAndFeelException");
        } catch (final ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        } catch (final InstantiationException e) {
            System.out.println("InstantiationException");
        } catch (final IllegalAccessException e) {
            System.out.println("IllegalAccessException");
        }
    }
    
    /**
     * The start point for the power paint program.
     * 
     * @param theArgs command line arguments - ignored
     */
    public static void main(final String... theArgs) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setLookAndFeel();
                new GUI(); // create the graphical user interface
            }
        });
    }
}