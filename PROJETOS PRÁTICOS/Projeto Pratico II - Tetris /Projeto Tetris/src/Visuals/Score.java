package Visuals;

import Matrix.Board.Board;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Score Class
 * Defines the Score Visual Element, giving it a custom font and size.
 */
public class Score extends JLabel {
    private static InputStream myStream = null;
    private static Font BaseFont = null;
    private static Font Game_Font = null;

    public Score() throws IOException, FontFormatException {
        super("0", SwingConstants.CENTER);
        myStream = new BufferedInputStream(
                new FileInputStream("src/Visuals/Background_Elements/Px437_IBM_VGA_8x16.ttf"));
        BaseFont = Font.createFont(Font.TRUETYPE_FONT, myStream);
        Game_Font = BaseFont.deriveFont(Font.PLAIN, 40);
        this.setFont(Game_Font);
        this.setBackground(new Color(82,82,82));
        this.setForeground(new Color(191,191,191));
        this.setPreferredSize(new Dimension(160, 80));
        this.setBorder(BorderFactory.createLineBorder(new Color(82,82,82), 5));
    }

    /**
     * Updates the Score on the Info Panel.
     * @param B: Board
     */
    public void updateScore(Board B) {
        this.setText(Integer.toString(B.getScore()));
    }
}
