/*
 * Board.java
 * 
 *
 * Ultima modificação: 10/05/2024
 *
 * Material utilizado para o Projeto Pratico 01 [Tetris] aula de MC322 - Programacao Orientada a Objetos
 */

package Matrix.Board;
import Matrix.Matrix;
import Matrix.Pieces.Piece;
import Matrix.Color;

public class Board extends Matrix {
    private int score;
    private Piece fallingPiece;
    private Color[][] landed;

    public Board(int height, int width) {
        super(height, width);
        this.landed = new Color[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                form[i][j] = landed[i][j] = Color.WHITE;
            }
        }
        this.score = 0;
        this.fallingPiece = null;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        this.score += points;
    }

    public Piece getFallingPiece() {
        return fallingPiece;
    }
    
    public void setFallingPiece(Piece fallingPiece) {
        this.fallingPiece = fallingPiece;
    }

    public void clearPiece() {
        this.setFallingPiece(null);
    }

    public Color[][] getLanded() {
        return landed;
    }

    /*
     * Pinta o board de acordo com a posicao da peca.
     */
    public void update() {
        int x = fallingPiece.getX();
        int y = fallingPiece.getY();
        int m = fallingPiece.getHeight();
        int n = fallingPiece.getWidth();
        for (int i = y; i < y + m; i++) {
            for (int j = x; j < x + n; j++) {

                // Eh importante nao pintar uma celula BRANCA da peca sobre o board
                // Uma celula BRANCA da peca deve ser considerada "transparente"
                if (fallingPiece.getForm()[i - y][j - x] != Color.WHITE) {
                    form[i][j] = fallingPiece.getForm()[i - y][j - x];
                }
            }
        }
    }

    /*
     * Inversa da funcao update.
     * Limpa a peca atual do board.
     */
    public void clear() {
        int x = fallingPiece.getX();
        int y = fallingPiece.getY();
        int m = fallingPiece.getHeight();
        int n = fallingPiece.getWidth();
        for (int i = y; i < y + m; i++) {
            for (int j = x; j < x + n; j++) {
                if (this.getFallingPiece().getForm()[i - y][j - x] != Color.WHITE)
                    form[i][j] = Color.WHITE;
            }
        }
    }

    /*
     * Copia matriz-base para matriz landed
     */
    public void updateLanded() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (form[i][j] != Color.WHITE) {
                    Color Temp = form[i][j];
                    landed[i][j] = Temp;
                }
            }
            //System.arraycopy(form[i], 0, landed[i], 0, width);
        }
    }

    /*
     * Apaga a linha completa.
     */
    public void deleteLine(int y) {
        for (int j = y; j > 0; j--) {
            if (width >= 0) System.arraycopy(landed[j - 1], 0, landed[j], 0, width);
        }
        for (int x = 0; x < width; x++) {
            landed[0][x] = Color.WHITE;
        }
        for (int i = 0; i < height; i++) {
            System.arraycopy(landed[i], 0, form[i], 0, width);
        }
    }
}
