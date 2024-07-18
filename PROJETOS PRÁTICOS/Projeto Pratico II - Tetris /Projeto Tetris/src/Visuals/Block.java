package Visuals;

import Matrix.Color;

import javax.swing.*;

/**
 * Block Class
 * Defines the block visual element that represents either a blank space on a cell, a piece cell or an Info Panel cell,
 * it uses a JLabel with an ImageIcon to represent these cells visually.
 */
public class Block extends JLabel {
    protected JLabel Block;
    protected ImageIcon Black_Block = new ImageIcon("src/Visuals/Block_Icons/Black_Background.png");
    protected ImageIcon Black_Block_Grid = new ImageIcon("src/Visuals/Block_Icons/Black_Background_2.png");
    protected ImageIcon White_Block = new ImageIcon("src/Visuals/Block_Icons/White_Block.png");
    protected ImageIcon Blue_Block = new ImageIcon("src/Visuals/Block_Icons/Blue_Block.png");
    protected ImageIcon Yellow_Block = new ImageIcon("src/Visuals/Block_Icons/Yellow_Block.png");
    protected ImageIcon Green_Block = new ImageIcon("src/Visuals/Block_Icons/Green_Block.png");
    protected ImageIcon Red_Block = new ImageIcon("src/Visuals/Block_Icons/Red_Block.png");
    protected ImageIcon Orange_Block = new ImageIcon("src/Visuals/Block_Icons/Orange_Block.png");
    protected ImageIcon Pink_Block = new ImageIcon("src/Visuals/Block_Icons/Pink_Block.png");
    protected ImageIcon Cyan_Block = new ImageIcon("src/Visuals/Block_Icons/Cyan_Block.png");

    public Block(Color c) {
        if (c == Color.WHITE)
            Block = new JLabel(White_Block);
        else
            Block = new JLabel(Black_Block);
    }

    public JLabel getBlock() {
        return Block;
    }

    /**
     * Updates the block to the desired color.
     * @param c: Color of the cell on the Game Board.
     */
    public void UpdateBlock(Color c) {
        if (c == Color.BLUE)
            Block.setIcon(Blue_Block);
        else if (c == Color.YELLOW)
            Block.setIcon(Yellow_Block);
        else if (c == Color.GREEN)
            Block.setIcon(Green_Block);
        else if (c == Color.RED)
            Block.setIcon(Red_Block);
        else if (c == Color.ORANGE)
            Block.setIcon(Orange_Block);
        else if (c == Color.PINK)
            Block.setIcon(Pink_Block);
        else if (c == Color.CYAN)
            Block.setIcon(Cyan_Block);
        else
            Block.setIcon(Black_Block);
    }
}
