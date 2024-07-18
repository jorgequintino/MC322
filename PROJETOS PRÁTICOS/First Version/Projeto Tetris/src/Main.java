import Matrix.Board.Board;
import Matrix.Pieces.Ipiece;
import Matrix.Pieces.Jpiece;
import Matrix.Pieces.Piece;

public class Main {
    public static void main(String[] args) {
        Board B = new Board(20, 10);
        System.out.println("This is checking movements of a piece on the board.");
        PieceMovements(B);
        Engine.clearScreen();
        System.out.println("This is deleting a line full of pieces.");
        deletefullline(B);
        Engine.clearScreen();
        System.out.println("This is simulating a functional run of the games without proper graphics");
        Engine.run(B);
        Engine.clearScreen();
    }
    /**
     * Shows all the movements available for a piece
     * @param B: Board
     */
    public static void PieceMovements(Board B) {

        Piece p = new Jpiece();
        p.setX(5);
        p.setY(10);

        B.setFallingPiece(p);

        //Shows the piece on its original position on the board
        B.update();
        System.out.println(B);
        B.clear();

        p.moveLeft();
        B.update();
        System.out.println(B);
        B.clear();

        p.moveRight();
        B.update();
        System.out.println(B);
        B.clear();

        p.rotateClockWise();
        B.update();
        System.out.println(B);
        B.clear();

        p.rotateCounterClockWise();
        B.update();
        System.out.println(B);
        B.clear();

        Engine.DropDown(B, p);
        B.update();
        System.out.println(B);
        B.clear();
    }
    /**
     * This function creates three different pieces to turn the last line full. 
     * It then deletes said line. 
     * @param B: Board
     */
    public static void deletefullline(Board B){
        System.out.println(B);

        Piece I = new Ipiece();
        I.setX(0);
        I.setY(0);

        //Mostra a peça no tabuleiro
        B.setFallingPiece(I);
        B.update();
        System.out.println(B);
        B.clear();

        //Rotacionar
        I.rotateClockWise();
        B.update();
        System.out.println(B);
        B.clear();

        //Drop down
        Engine.DropDown(B, I);
        B.update();
        System.out.println(B);
        B.updateLanded();
        B.clearPiece();


        Piece J = new Jpiece();
        J.setX(4);
        J.setY(0);
        //Mostra a peça no tabuleiro
        B.setFallingPiece(J);
        B.update();
        System.out.println(B);
        B.clear();

        //Drop down
        Engine.DropDown(B, J);
        B.update();
        System.out.println(B);
        B.updateLanded();
        //B.clear();
        B.clearPiece();

        Piece M = new Ipiece();
        M.setX(6);
        M.setY(0);

        //Mostra a peça no tabuleiro
        B.setFallingPiece(M);
        B.update();
        System.out.println(B);
        B.clear();

        //Rotacionar
        M.rotateClockWise();
        B.update();
        System.out.println(B);
        B.clear();

        //Drop down
        Engine.DropDown(B, M);
        B.update();
        System.out.println(B);
        B.updateLanded();
        B.clearPiece();


        B.deleteLine(19);
        System.out.println(B);
        }
}



