
package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *  a class for GUI display.
 * @author Zhou Lu
 * @version 11/29/2017
 */
public class GUI extends JFrame implements Observer {
    
    /**
     * a default width of the JFrame.
     */
    private static final int DEFAULT_WIDTH = 400;
    
    /**
     * a default height of the JFrame.
     */
    private static final int DEFAULT_HEIGHT = 400;
    
    /**
     * a constant define the timer delay.
     */
    private static final int DEFAULT_DELAY = 800;
    
    /**
     * a generated ID.
     */
    private static final long serialVersionUID = -7174075501199373132L;

    /**
     * a GameBoard class object.
     */
    private final GameBoard myGameBoard;
   
    /**
     * a boolean field for checking the pause.
     */
    private boolean myPause;
    
    /**
     * a boolean field for checking the end.
     */
    private boolean myEnd;

    /**
     * a field of timers.
     */
    private Timer myTimer;
    
    /**
     * a field of complete row.
     */
    private int myCompleteRow;
    
//    /**
//     * a field for the board object.
//     */
//    private Board myBoard;

//    /**
//     * a field to display current level.
//     */
//    private String myLevel;
    
    /**
     * a constructor.
     */
    public GUI() {    
        this(10, 20);
    }
    
    /**
     * a overload constructor.
     * @param theUnitWidth the JFrame Width.
     * @param theUnitHeight the JFrame Height.
     */
    public GUI(final int theUnitWidth, final int theUnitHeight) {
        super("13 X 23 Tetris");
        myGameBoard = new GameBoard(theUnitWidth, theUnitHeight);
        myPause = true;
        myEnd = false;
        setLayout(new GridLayout(1, 2));
        setLocationRelativeTo(null);
        setUpToReduceLine();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        myGameBoard.getMyBoard().newGame();
    }
    
    /**
     * a helper method for constructor not exceed 10 lines.
     */
    private void setUpToReduceLine() {
        setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setUpAllThing();
    }
    /**
     * a helper method call all the set up method.
     */
    private void setUpAllThing() {
        setUpLeftSide();
        setUpRightSide();
        setUpKeyControl();
        setUpJMenu();
        addObserver();
        setUpTimer();
        
        startTimer();
    }
    
    
    
    /** 
     * a method to set up JMenu.
     */
    private void setUpJMenu() {
        final JMenuBar menuBar = new JMenuBar();
        final JMenu about = new JMenu("About");
        final JMenu gridSize = new JMenu("Choose Size");
        about.add(setUpScoreAlgorithm());
        gridSize.add(setUpGridSizeButton());
        gridSize.add(setUpDefaultSizeButton());
        menuBar.add(gridSize);
        menuBar.add(about);
//        setJMenuIsSelected(menuBar);

        setJMenuBar(menuBar);        
    }
    
//    /**
//     * set up an action when one of the JMens is selected.
//     * @param theBar the bar contains all JMenus.
//     */
//    private void setJMenuIsSelected(final JMenuBar theBar) {
//        if (theBar.isSelected()) {
//            myPause = false;
//            myGameBoard.getMyTimer().stop();
//            JOptionPane.showMessageDialog(null, "Game is paused, to resume press R");
//        }
//    }
    
    /**
     * a method to set up the frame title indicate total line cleared and current level.
     * also indicate percentage to the next level.
     */
    private void setUpCurrentInfo() {
        final int lineClear = myCompleteRow;
        final int levelInterval = 5;
        final int levelDifference = 100;
        myGameBoard.getMyScore().setText("Score: " + Integer.toString(myCompleteRow));
        myGameBoard.getMyTotalLineClear().setText("Line Cleared: " + myCompleteRow);
        myGameBoard.getMyPercentage().setText((double) (myCompleteRow % levelInterval) 
                             / levelInterval * levelDifference + "% to next level");
        setTitle("Current Level is: " + (int) Math.floor(lineClear / levelInterval));
    }
    
    /**
     * a helper method to set up the default size button.
     * @return default size button.
     */
    private JButton setUpDefaultSizeButton() {
        final JButton defaultSize = new JButton("10 X 20");
        final int width = 10;
        final int height = 20;
        defaultSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                dispose();
                new GUI(width, height);
            }
        });
        return defaultSize;
    }
    
    /**
     * a method to set up the jbutton to change the grid size.
     * @return a JButton.
     */
    private JButton setUpGridSizeButton() {
        final JButton size = new JButton("13 X 23");
        final int width = 13;
        final int height = 23;
        size.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                dispose();
                new GUI(width, height);
            }
        });
        return size;
    }
    
    /**
     * a helper method to set up the scoreAlgorithm button.
     * @return a button with listener.
     */
    private JButton setUpScoreAlgorithm() {
        final JButton scoreAlgorithm = new JButton("About...");
        scoreAlgorithm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(null, "Level 1: LineClear 1 - 5\n"
                                + "Level 2: LineClear 6 - 10\n"
                                + "Level 3: LineClear 11 - 15\n"
                                + "and So on.");
            }
        });
        return scoreAlgorithm;
    }
    
    /**
     * a method to start the timer.
     */
    private void startTimer() {
        myTimer.start();
    }
     
    /**
     * a method to set up timer action.
     */
    private void setUpTimer() {
        myTimer = new Timer(DEFAULT_DELAY, new ActionListener() {
            
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myGameBoard.getMyBoard().down();
            }
        });
    }
    
    /**
     * a helper method to do the adding observer.
     */
    private void addObserver() {
        myGameBoard.getMyBoard().addObserver(this);
        myGameBoard.getMyBoard().addObserver(myGameBoard.getMyNextPiece());
        myGameBoard.getMyBoard().addObserver(myGameBoard);
    }
    
    /**
     * a method to set up left side of the gui.
     */
    private void setUpLeftSide() {        
        add(myGameBoard);
    }
    
    /**
     * a method set up the right side of the gui.
     */
    private void setUpRightSide() {
        add(myGameBoard.getGamePanel());
    }    
    
    /**
     * a method to set up key control.
     */
    private void setUpKeyControl() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent theEvent) {
                handleKey(theEvent.getKeyCode());  
            }
        });
    }
    
    /**
     * a helper method to handler the key.
     * @param theKey the key that user press.
     */
    private void handleKey(final int theKey) {
        if (!myEnd) {
            checkKeyIsUp(theKey);
            checkKeyIsLeft(theKey);
            checkKeyIsRight(theKey);
            checkKeyIsDown(theKey);
            checkKeyIsSpace(theKey);
            checkKeyIsPause(theKey);
            checkKeyIsResume(theKey);
        }
        checkKeyIsNew(theKey);
        checkKeyIsEnd(theKey);
    }
    
    /**
     * helper method when the key is w or up arrow.
     * @param theKey theKey to be checked.
     */
    private void checkKeyIsUp(final int theKey) {
        if (((theKey == KeyEvent.VK_UP) || (theKey == KeyEvent.VK_W)) && myPause) {
            myGameBoard.getMyBoard().rotate();
        }
    }
    
    /**
     * helper method when the key is a or left arrow.
     * @param theKey theKey to be checked.
     */
    private void checkKeyIsLeft(final int theKey) {
        if (((theKey == KeyEvent.VK_LEFT) || (theKey == KeyEvent.VK_A)) && myPause) {
            myGameBoard.getMyBoard().left();
        }
    }
    /**
     * helper method when the key is d or right arrow.
     * @param theKey theKey to be checked.
     */
    private void checkKeyIsRight(final int theKey) {
        if (((theKey == KeyEvent.VK_RIGHT) || (theKey == KeyEvent.VK_D)) && myPause) {
            myGameBoard.getMyBoard().right();
        }
    }
    
    /**
     * helper method when the key is s or down arrow.
     * @param theKey theKey to be checked.
     */
    private void checkKeyIsDown(final int theKey) {
        if (((theKey == KeyEvent.VK_DOWN) || (theKey == KeyEvent.VK_S)) && myPause) {
            myGameBoard.getMyBoard().down();
        }
    }
    
    /**
     * helper method when the key is up or up arrow.
     * @param theKey theKey to be checked.
     */
    private void checkKeyIsSpace(final int theKey) {
        if (theKey == KeyEvent.VK_SPACE && myPause) {
            myGameBoard.getMyBoard().drop();
        }
    }
    
    /**
     * helper method when the key is p.
     * @param theKey to be checked.
     */
    private void checkKeyIsPause(final int theKey) {
        if (theKey == KeyEvent.VK_P && myPause) {
            myPause = false;
            myTimer.stop();
            JOptionPane.showMessageDialog(null, "game has been paused, To resume press R");
        }
    }
    
    /**
     * helper method when the key is r.
     * @param theKey to be checked.
     */
    private void checkKeyIsResume(final int theKey) {
        if (theKey == KeyEvent.VK_R) {
            myPause = true;
            myTimer.start();
        }
    }
    
    /**
     * helper method when the key is n.
     * @param theKey to be checked.
     */
    private void checkKeyIsNew(final int theKey) {
        if (theKey == KeyEvent.VK_N) {
            myCompleteRow = 0;
            myPause = true;
            myEnd = false;
            myTimer.start();
            myGameBoard.getMyBoard().newGame();
            JOptionPane.showMessageDialog(null, "new game");
            myTimer.setDelay(DEFAULT_DELAY);
        }
    }
    
    /**
     * helper method when the key is e.
     * @param theKey to be checked.
     */
    private void checkKeyIsEnd(final int theKey) {
        if (theKey == KeyEvent.VK_E) {
            myPause = false;
            myEnd = true;
            myTimer.stop();
            JOptionPane.showMessageDialog(null, "game is ended, To start new game press N");
        }
    }
    
    @Override
    public void update(final Observable theObservable, final Object theArg) {
        if (theArg instanceof Boolean && (boolean) theArg) {         
            myPause = false;
            myEnd = true;
            myTimer.stop();
            JOptionPane.showMessageDialog(null, 
                                          "Game Over, To start new game press N");
        }
        if (theArg instanceof Integer[]) { 
            System.out.print(myCompleteRow);
            final int level = myCompleteRow;
            final int levelInterval = 5;
            final int levelDifference = 100;
            if (DEFAULT_DELAY - levelDifference * Math.floor(level / levelInterval) > 0) {
                myTimer.setDelay((int) (DEFAULT_DELAY 
                                - levelDifference * Math.floor(level / levelInterval)));
            }
            myCompleteRow +=  ((Integer []) theArg).length;
//            myGameBoard.getMyScore().setText("Score: " + Integer.toString(myCompleteRow));
//            myGameBoard.getMyTotalLineClear().setText("Line Cleared: " + myCompleteRow);
//            myGameBoard.getMyPercentage().setText((double) (myCompleteRow % levelInterval) 
//                                 / levelInterval * levelDifference + "% to next level");
        }
        setUpCurrentInfo();
    }
}
