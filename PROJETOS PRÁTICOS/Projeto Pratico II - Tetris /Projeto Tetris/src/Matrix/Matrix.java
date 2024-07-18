/*
 * Matrix.java
 * 
 *
 * Ultima modificação: 10/05/2024
 *
 * Material utilizado para o Projeto Pratico 01 [Tetris] aula de MC322 - Programacao Orientada a Objetos
 */

package Matrix;

public abstract class Matrix {
    protected Color[][] form;
    protected int height;
    protected int width;


    public Matrix(int height, int width) {
        this.height = height;
        this.width = width;
        this.form = new Color[height][width];
    }

    public Color[][] getForm() {
        return form;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
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

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                out.append(form[i][j]);
            }
            out.append('\n');
        }
        return out.toString();
    }
}
