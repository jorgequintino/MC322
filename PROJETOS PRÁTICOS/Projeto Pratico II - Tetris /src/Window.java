import Matrix.Board.Board;
import Visuals.Block;
import Visuals.ExitButton;
import Visuals.JPanelWithBackground;
import Visuals.Score;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Window Class
 * Defines the window for the game and all the subsequent containers, including
 * the game board layer and the info panel
 */
public class Window {
    protected JFrame Game_Window ;
    protected JPanel Game_Board;
    protected JPanelWithBackground Info_Panel;
    protected Score Score;
    protected ExitButton Exit;
    protected List<Block> Blocks = new ArrayList<Block>();

    public Window(Board B) throws IOException, FontFormatException {
        //Set Window
        Game_Window = new JFrame("Tetris");
        Game_Window.setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));
        Game_Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set Board Panel
        Game_Board = new JPanel();
        Game_Board.setPreferredSize(new Dimension(40*B.getWidth(), 40*B.getHeight()));
        Game_Board.setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));
        for (int i = 0; i < B.getHeight(); i++) {
            for (int j = 0; j < B.getWidth(); j++) {
                Block Block = new Block(B.getForm()[i][j]);
                Blocks.add(Block);
                Game_Board.add(Block.getBlock());
            }
        }

        //Set Info Panel
        //Info Panel Setup
        Info_Panel = new JPanelWithBackground("src/Visuals/Background_Elements/Background.png");
        Info_Panel.setPreferredSize(new Dimension(400, 40*B.getHeight()));
        SpringLayout springLayout = new SpringLayout();
        Info_Panel.setLayout(springLayout);
        //Score Tab Setup
        Score = new Score();
        Info_Panel.add(Score);
        springLayout.putConstraint(SpringLayout.NORTH, Score, 360, SpringLayout.NORTH, Info_Panel);
        springLayout.putConstraint(SpringLayout.WEST, Score, 40, SpringLayout.WEST, Info_Panel);
        //Exit Button Setup
        Exit = new ExitButton(Game_Window);
        Info_Panel.add(Exit);
        springLayout.putConstraint(SpringLayout.NORTH, Exit, 40, SpringLayout.NORTH, Info_Panel);
        springLayout.putConstraint(SpringLayout.WEST, Exit, 320, SpringLayout.WEST, Info_Panel);

        //Start Window
        Game_Window.getContentPane().add(Game_Board);
        Game_Window.getContentPane().add(Info_Panel);
        Game_Window.pack();
        Game_Window.setVisible(true);

        //Key Bindings
        //LEFT
        Action LEFT_MOVE = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Engine.MoveLeft(B, B.getFallingPiece());
            }
        };
        Game_Board.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "LEFT_MOVE");
        Game_Board.getActionMap().put("LEFT_MOVE", LEFT_MOVE);
        //RIGHT
        Action RIGHT_MOVE = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Engine.MoveRight(B, B.getFallingPiece());
            }
        };
        Game_Board.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "RIGHT_MOVE");
        Game_Board.getActionMap().put("RIGHT_MOVE", RIGHT_MOVE);
        //DROP DOWN
        Action DROP_DOWN = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Engine.DropDown(B, B.getFallingPiece());
            }
        };
        Game_Board.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "DROP_DOWN");
        Game_Board.getActionMap().put("DROP_DOWN", DROP_DOWN);
        //ROTATE
        Action ROTATE = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Engine.Rotate(B);
            }
        };
        Game_Board.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "ROTATE");
        Game_Board.getActionMap().put("ROTATE", ROTATE);
    }


    /**
     * Updates the cells on the Game Board.
     * @param B: Board
     */
    public void update_Widow(Board B) {
        for (int i = 0; i < B.getHeight(); i++) {
            for (int j = 0; j < B.getWidth(); j++) {
                Blocks.get(i*B.getWidth() + j).UpdateBlock(B.getForm()[i][j]);
            }
        }
        Score.updateScore(B);
        Game_Board.revalidate();
        Game_Board.repaint();
    }

}
