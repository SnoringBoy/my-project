
package view;

import java.awt.EventQueue;

/**
 * run tetris by instantiating and starting the GUI.
 * @author Zhou Lu
 * @version 11/29/2017
 */
public final class GUIMain {

    /**
     * private constructor.
     */
    private GUIMain() {
        throw new IllegalStateException();
    }
    
    /**
     * the main method, invokes the GUI.
     * @param theArgs command line arguments.
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });
    }
}
