
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import model.Block;
import model.Board;

/**
 *  a class for GameBoard display.
 * @author Zhou Lu
 * @version 11/29/2017
 */
public class GameBoard extends JPanel implements Observer {
    
    /**
     * a generated ID.
     */
    private static final long serialVersionUID = 7079077557873307801L;

    /**
     * define the game board size.
     */
    private static final Dimension BOARD_DEFAULT_SIZE = new Dimension(170, 340);
//
//    /**
//     * a constant define the timer delay.
//     */
//    private static final int DEFAULT_DELAY = 800;
    
    /**
     * constant define size.
     */
    private static final Dimension DEFAULT_SIZE = new Dimension(230, 260);
    
    /**
     * constant define padding.
     */
    private static final int DEFAULT_PADDING = 10;
    
    /**
     * constant define default size.
     */
    private static final int DEFAULT_COLUMN = 10;
    
    /**
     * constant define default size.
     */
    private static final int DEFAULT_ROW = 20;
    
    /**
     * show the game score.
     */
    private JLabel myScore;
    
    /**
     * a panel to see the next piece.
     */
    private final PiecePanel myNextPiece;
    
    /**
     * a container to contain game info.
     */
    private final JPanel myGameInfoPanel;
    
    /**
     * a field for Board class object.
     */
    private Board myBoard;
    
//    /**
//     * a field for timer for the whole class.
//     */
//    private Timer myTimer;
    
    /**
     * a field to count the complete row.
     */
    private int myCompleteRow;
    
    /**
     * a JLabel to display the line cleared. 
     */
    private JLabel myTotalLineClear;    
    
    /**
     * a JLabel to display the percentage to next level.
     */
    private JLabel myPercentage;
    
    /**
     * a field that store the how many units of the row of the game board.
     */
    private int myRow;
    
    /**
     * a field that store the how many units of the column of the game board.
     */
    private int myColumn;
    
    /**
     * a constructor to initialize field.
     */
    public GameBoard() {
        this(DEFAULT_COLUMN, DEFAULT_ROW);
    }
    
    /**
     * a overload constructor.
     * @param theUnitWidth the game board width.
     * @param theUnitHeight the game board height.
     */
    public GameBoard(final int theUnitWidth, final int theUnitHeight) {
        super();
        myRow = theUnitHeight;
        myColumn = theUnitWidth;
        setSize(BOARD_DEFAULT_SIZE);
        setBackground(Color.WHITE);
        myNextPiece = new PiecePanel();
        myGameInfoPanel = new JPanel();
        myBoard = new Board(myColumn, myRow);
        setUpThing();
    }
    
    /**
     * a helper method to stop the warning.
     */
    private void setUpThing() {
        gamePanelSetUp();
//        setUpTimer();
//        startGame();
        
    }
    /**
     * set up the game panel.
     */
    private void gamePanelSetUp() {
        final BoxLayout b = new BoxLayout(myGameInfoPanel, BoxLayout.PAGE_AXIS);
        myGameInfoPanel.setLayout(b);
        final JPanel innerTextPanel = new JPanel();
        innerTextPanel.setPreferredSize(DEFAULT_SIZE);
        
        final JLabel controlKey1 = new JLabel("Drop: \u2193 or S\n");
        final JLabel controlKey2 = new JLabel("Up: \u2191 or W\n");
        final JLabel controlKey3 = new JLabel("Left: \u2190 or A\n");   
        final JLabel controlKey4 = new JLabel("Right: \u2192 or D");
        final JLabel pauseKey = new JLabel("Pause Game: P");
        final JLabel resumeKey = new JLabel("Resume Game: R");
        final JLabel newKey = new JLabel("New Game: N");
        final JLabel endKey = new JLabel("End Game: E");
//        final JLabel totalLine = new JLabel("Line cleared: " + myCompleteRow);
        //final JLabel percentage = new JLabel(myCompleteRow + "% to complete current level");
        
        myScore = new JLabel("Score: 0");
        myTotalLineClear = new JLabel("Line Cleared: 0");
        myPercentage = new JLabel("0% to next level");
        innerTextPanel.add(myScore);
        innerTextPanel.add(myTotalLineClear);
        innerTextPanel.add(myPercentage);
        innerTextPanel.setLayout(new GridLayout(0, 1));
        innerTextPanel.add(controlKey1);
        innerTextPanel.add(controlKey2);
        innerTextPanel.add(controlKey3);
        innerTextPanel.add(controlKey4);
        innerTextPanel.add(pauseKey);
        innerTextPanel.add(resumeKey);
        innerTextPanel.add(newKey);
        innerTextPanel.add(endKey);
        
        final TitledBorder infoTitle = BorderFactory.createTitledBorder(null, "Your Info", 
                                                                        TitledBorder.CENTER, 
                                                                        TitledBorder.TOP);
        innerTextPanel.setBorder(infoTitle);
        final TitledBorder tetrisInfo = BorderFactory.createTitledBorder(null, "Preview",
                                                                         TitledBorder.CENTER,
                                                                         TitledBorder.TOP);
        myNextPiece.getOuterPanel().setBorder(tetrisInfo);
        myGameInfoPanel.add(myNextPiece.getOuterPanel());
        myGameInfoPanel.add(Box.createVerticalStrut(DEFAULT_PADDING));
        myGameInfoPanel.add(innerTextPanel);
    }
    
    /**
     * a set method to set myBoard.
     * @param theBoard the board contains data this class need.
     */
    public void setMyBoard(final Board theBoard) {
        myBoard = theBoard;
    }
    
    /**
     * a get method for the total line clear.
     * @return myTotalLineClear.
     */
    public JLabel getMyTotalLineClear() {
        return myTotalLineClear; 
    }
    
    /**
     * a get method to get the container.
     * @return myGameInfo.
     */
    public JPanel getGamePanel() {
        return myGameInfoPanel;
    }
    
    /**
     * a get method for the myBoard.
     * @return myBoard.
     */
    public Board getMyBoard() {
        return myBoard;
    }
    
//    /**
//     * a get method for the timer.
//     * @return myTimer.
//     */
//    public Timer getMyTimer() {
//        return myTimer;
//    }
    
    /**
     * a get method for myPerentage.
     * @return myPercentage.
     */
    public JLabel getMyPercentage() {
        return myPercentage;
    }
    
    /**
     * a get method to get the complete line.
     * @return myCompleteRow.
     */
    public int getMyCompleteRow() {
        return myCompleteRow;
    }
    
    /**
     * a get method for the myScore.
     * @return myScore.
     */
    public JLabel getMyScore() {
        return myScore;
    }
    
    /**
     * a get method for the myNextPiece.
     * @return myNextPiece.
     */
    public PiecePanel getMyNextPiece() {
        return myNextPiece;
    }
    
//    /**
//     * a method to start game as the gameBoard is created.
//     */
//    private void startGame() {
//        myBoard.newGame();
////        startTimer();
//    }
    
//    /**
//     * a method to set up timer action.
//     */
//    private void setUpTimer() {
//        myTimer = new Timer(DEFAULT_DELAY, new ActionListener() {
//            
//            @Override
//            public void actionPerformed(final ActionEvent theEvent) {
//                myBoard.down();
//            }
//        });
//    }
    
//    /**
//     * a method to start the timer.
//     */
//    private void startTimer() {
//        myTimer.start();
//    }
    
    /**
     * a method turn string to shape.
     * @return a shape to draw.
     */
    public StoreShapeAndColor[][] stringToShape() {
        // a column of the board - 3 is always the grid width size of the board.
        final int columnConstant = 3;        
        // create 2d array only to store the position has letter.
        // the array is 20 by 10 as a tetris game board(by default).
        final String[][] boardData = new String[myRow][myColumn];
        final String stringBoard = myBoard.toString().
                        substring(5 * (myColumn + columnConstant) - 1);
//        System.out.print(stringBoard);
        // there are 20 rows for the gameboard toString(), and 13 columns.
        // actual game board is 10 columns.
        for (int rowIndex = 0; rowIndex < myRow; rowIndex++) {
            for (int columnIndex = 1; columnIndex < myColumn + 1; 
                            columnIndex++) {
                if ((stringBoard.charAt(rowIndex * (myColumn + columnConstant) 
                                        + columnIndex) != '\n') 
                                && (stringBoard.charAt(rowIndex * (myColumn + columnConstant) 
                                                       + columnIndex) != '|') 
                                && (stringBoard.charAt(rowIndex * (myColumn + columnConstant) 
                                                       + columnIndex) != '-')) {

                    boardData[rowIndex][columnIndex - 1] = 
                                    String.valueOf(stringBoard.charAt(rowIndex 
                                                    * (myColumn + columnConstant) 
                                                                      + columnIndex));
                    
                }
            }
        }
//        for (int rowIndex = 0; rowIndex < myRow; rowIndex++) {
//            for (int totalColumnIndex = 0; totalColumnIndex < myColumn + columnConstant; 
//                            totalColumnIndex++) {
//                int gridColumnIndex = 0;
//                if ((stringBoard.charAt(index) != '\n') 
//                                && (stringBoard.charAt(index) != '|') 
//                                && (stringBoard.charAt(index) != '-')) {
//
//                    boardData[rowIndex][gridColumnIndex] = 
//                                    String.valueOf(stringBoard.charAt(index));
//                    gridColumnIndex++;
//                    
//                }
////                if (index < stringBoard.length()) {
//                    index++;           
////                }
//            }
//        }
        
        
//        for (int a = 0; a < boardData.length; a++) {
//            for (int b = 0; b < boardData[a].length; b++) {
//                if (boardData[a][b] == null) {
//                    System.out.print(".");
//                } else {
//                    System.out.print(boardData[a][b]);                    
//                }
//            }
//            System.out.println("");
//        }
        return identifyStringToShape(boardData);
    }
    
    /**
     *  a helper method to change the letter into round rectangle shape.    
     * @param theBoardData the boardData is string type and convert it to shape.
     * @return return a 2d array.
     */
    public StoreShapeAndColor[][] identifyStringToShape(final String[][] theBoardData) {
        final int arcwidth = 45;
        final int archeight = 45;
        final int row = myRow;
        final int column = myColumn;
        final int length = 15;
        final int increment = 15;
        // this line up with the starting x of the game board in the JFrame.
        final int startingX = 15;
        // this line up with the starting y of the game board in the JFrame.
        final int startingY = 15;
        // a color for the t piece.
//        final Color purple = new Color(255, 0, 255);
        final StoreShapeAndColor[][] result = new StoreShapeAndColor[row][column];
        
        for (int a = 0; a < row; a++) {
            for (int b = 0; b < column; b++) {
                for (final Block block : Block.values()) {
                    if (block.toString().equals(theBoardData[a][b])) {
                        result[a][b] = new StoreShapeAndColor(new RoundRectangle2D.Double(
                                                         startingX + b * increment,
                                                         startingY + a * increment, 
                                                         length, length, 
                                                         arcwidth, archeight),
                                                         determineColor(block.toString()));
                    }
                }                
            }
        }
        
        return result;
    }
    
    /**
     * a helper method to return color.
     * @param theType type of the block.
     * @return color object.
     */
    private Color determineColor(final String theType) {
        final Color purple = new Color(255, 0, 255);
        Color result = Color.CYAN;
        if ("J".equals(theType)) {
            result = Color.BLUE;
        } else if ("L".equals(theType)) {
            result = Color.ORANGE;
        } else if ("O".equals(theType)) {
            result = Color.YELLOW;
        } else if ("S".equals(theType)) {
            result = Color.GREEN;
        } else if ("T".equals(theType)) {
            result = purple;
        } else if ("Z".equals(theType)) {
            result = Color.RED;
        }
        
        return result;      
    }
        
    @Override
    public void paintComponent(final Graphics theGraphic) {
        super.paintComponent(theGraphic);
        final Graphics2D g2d = (Graphics2D) theGraphic;
        final StoreShapeAndColor[][] boardData = stringToShape();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        
        // do calculation on scratch paper. 10 by 20 game board. 
        //one tetris piece is 15 pixels for default.
        // so got this length and width of the boarder.
        final Line2D.Double northBoarder = new Line2D.Double(15, 15, 15 * (myColumn + 1), 15);
        final Line2D.Double westBoarder = new Line2D.Double(15, 15, 15, 15 * (myRow + 1));
        final Line2D.Double eastBoarder = new Line2D.Double(15 * (myColumn + 1), 
                                                            15, 15 * (myColumn + 1), 
                                                            15 * (myRow + 1));
        final Line2D.Double southBoarder = new Line2D.Double(15, 15 * (myRow + 1), 
                                                             15 * (myColumn + 1), 
                                                             15 * (myRow + 1));
        g2d.draw(northBoarder);
        g2d.draw(westBoarder);
        g2d.draw(eastBoarder);
        g2d.draw(southBoarder);
        for (int row = 0; row < boardData.length; row++) {
            for (int column = 0; column < boardData[row].length; column++) {
                if (boardData[row][column] != null) {
                    g2d.setPaint(boardData[row][column].getColor());
                    g2d.fill(boardData[row][column].getShape());
                }
            }
        }
        
    }
    
    @Override
    public void update(final Observable theObservable, final Object theArg) {
        repaint();
//        if (theArg instanceof Integer[]) { 
//            final int level = myCompleteRow;
//            final int levelInterval = 5;
//            final int levelDifference = 100;
//            if (DEFAULT_DELAY - levelDifference * Math.floor(level / levelInterval) > 0) {
//                myTimer.setDelay((int) (DEFAULT_DELAY 
//                                - levelDifference * Math.floor(level / levelInterval)));
//            }
//            myCompleteRow +=  ((Integer []) theArg).length;
//            myScore.setText("Score: " + Integer.toString(myCompleteRow));
//            myTotalLineClear.setText("Line Cleared: " + myCompleteRow);
//            myPercentage.setText((double) (myCompleteRow % levelInterval) 
//                                 / levelInterval * levelDifference + "% to next level");
//        }
//        System.out.print(myBoard.toString());
    }
}
