package Visuals;

import javax.swing.*;
import java.awt.*;

/**
 * ExitButton Class
 * Defines a JButton that exits the game.
 */
public class ExitButton extends JButton {

    public ExitButton(JFrame W) {
        super();
        this.setIcon(new ImageIcon("src/Visuals/Block_Icons/ExitButton.png"));
        this.setPreferredSize(new Dimension(40,40));
        this.addActionListener(e -> closeWindow(W));
    }

    /**
     * Closes the program.
     * @param W: Window of the game.
     */
    private void closeWindow(JFrame W) {
        W.dispose();
        System.exit(1);
    }
}
