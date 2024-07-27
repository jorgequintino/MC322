/*
* Color.java
*
* última modificação: 10/05/2024
*
* Material utilizado para o Projeto Prático 01 [Tetris] aula de MC322 - Programação Orientada a Objetos
*/

package Matrix;

public enum Color {
    WHITE,
    BLACK,
    RED,
    ORANGE,
    GREEN,
    YELLOW,
    BLUE,
    PURPLE,
    CYAN,
    PINK;

    /*
     * Retorna o codigo ANSI correspondente a cor.
     * Sufixo RESET para resetar apos cada celula.
     */
    @Override
    public String toString() {
        String RESET = "\u001B[0m";
        switch (this) {
            case WHITE:
                return "\033[48;5;15m" + "  " + RESET;
            case BLACK:
                return "\033[48;5;0m" + "  " + RESET;
            case RED:
                return "\033[48;5;160m" + "  " + RESET;
            case ORANGE:
                return "\033[48;5;208m" + "  " + RESET;
            case GREEN:
                return "\033[48;5;46m" + "  " + RESET;
            case YELLOW:
                return "\033[48;5;220m" + "  " + RESET;
            case BLUE:
                return "\033[48;5;21m" + "  " + RESET;
            case PURPLE:
                return "\033[48;5;5m" + "  " + RESET;
            case CYAN:
                return "\033[48;5;45m" + "  " + RESET;
            case PINK:
                return "\033[48;5;170m" + "  " + RESET;
            default:
                return RESET;
        }
    }
}

