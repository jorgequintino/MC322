/*
* Piece.java
*
* Ultima modificação: 10/05/2024
*
* Material utilizado para o Projeto Prático 01 [Tetris] aula de MC322 - Programação Orientada a Objetos
*/

package Matrix.Pieces;

import Matrix.Board.Board;
import Matrix.Color;
import Matrix.Matrix;

import java.util.concurrent.ThreadLocalRandom;

/**
 *  Esta classe abstrata é o modelo para todas as peças do jogo;
 * Contém assim os atributos e métodos para a implementação delas.
 */
public abstract class Piece extends Matrix {
    protected int x;  // posicao do elemento [0][0] da peca no tabuleiro.
    protected int y;  // posicao do elemento [0][0] da peca no tabuleiro.
    protected int rotation;  // marca se a peça sofre rotação.


    public Piece(int height, int width, int origin, int bound) {
        super(height, width);
        this.spawn(origin, bound); // define x inicial randomico
        this.y = 0;
        this.rotation = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRotation() {
        return rotation;
    }

    public void setForm(Color[][] form) {
        this.form = form;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setRotation(int rotation) {
        this.rotation = (this.rotation + rotation) % 4;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }

    /**
    * A função adiciona i na posição x da peça.
    */
    public void addX(int i){
        x += i;
    }

    /**
     * A função adiciona i na posição y da peça.
     */
    public void addY(int i){
        y += i;
    }
    
    /**
     * A função movimenta a peça para esquerda.
     */
    public void moveLeft(){
        this.addX(-1);
    }

    /**
     * A função movimenta a peça para direita.
     */
    public void moveRight(){
        this.addX(1);
    }


    /**
     * Define x inicial da peca.
     * Chamada no construtor.
     */ 
    public void spawn(int origin, int bound) {
        x = ThreadLocalRandom.current().nextInt(origin, bound);
    }

    /*
     * Inverte os dados de linhas e coluna da matriz-peca.
     * Usado na rotacao.
     */
    private void switchHeightWidth() {
        int aux = height;
        height = width;
        width = aux;
    }


    /**
     * A função rotaciona a peça para a esquerda.
     *
     */
    public void rotateClockWise(Board B){
        B.clear();
        this.switchHeightWidth();
        Color[][] rotatedForm = new Color[height][width];
        //Check if out of bounds and move left
        while (x + width > B.getWidth()) {
            moveLeft();
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rotatedForm[i][j] = form[width - j - 1][i];
            }
        }
        this.setRotation(1);
        this.setForm(rotatedForm);
    }

    /**
     * A função rotaciona a peça para a direita.
     *
     */
    public void rotateCounterClockWise(){
        this.switchHeightWidth();
        Color[][] rotatedForm = new Color[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rotatedForm[i][j] = form[j][height - i - 1];
            }
        }
        this.setRotation(-1);
        this.setForm(rotatedForm);
    }
}
