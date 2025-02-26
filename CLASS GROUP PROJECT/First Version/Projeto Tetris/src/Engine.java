import Matrix.Board.*;
import Matrix.Color;
import Matrix.Pieces.*;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Engine Class
 * Defines all the function to make the Tetris game work, including Collision Checking,
 * Row Completion Checks and the main Run function.
 * (#WIP) ADD SCORES
 */
public class Engine {
    /**
     * Clears the terminal screen.
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Checks if a landed piece will overflow over the board.
     * @param P: Piece
     * @param B : Board
     * @return True if it will overflow the board upper limit, False otherwise
     */
    public static boolean CheckCollisionOver(Piece P, Board B) {
        int piece_height = P.getForm().length;
        int piece_width = P.getForm()[0].length;
        int piece_y = P.getY();
        int piece_x = P.getX();
        //Checks every cell of the form[][] of the piece
        for (int y = piece_y; y < piece_y + piece_height; y++) {
            for (int x = piece_x; x < piece_x + piece_width; x++) {
                //If there are a piece part on the cell, checks for overflown
                if (P.getForm()[y - piece_y][x - piece_x] != Color.WHITE) {
                    //Piece overflowed the board
                    if (y - 1 < 0)
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if a piece will colide with another piece or the board limits under it.
     * @param P: Piece
     * @param B : Board
     * @return True if it will colide under it, False otherwise
     */
    public static boolean CheckCollisionUnder(Piece P, Board B) {
        int piece_height = P.getForm().length;
        int piece_width = P.getForm()[0].length;
        int piece_y = P.getY();
        int piece_x = P.getX();
        //Checks every cell of the form[][] of the piece
        for (int y = piece_y; y < piece_y + piece_height; y++) {
            for (int x = piece_x; x < piece_x + piece_width; x++) {
                //If there are a piece part on the cell, checks for collision
                if (P.getForm()[y - piece_y][x - piece_x] != Color.WHITE) {
                    //Out of bounds collision
                    if (y + 1 >= B.getHeight())
                        return true;
                    //Piece to piece collision
                    if (B.getLanded()[y + 1][x] != Color.WHITE)
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if a piece will colide with another piece or the board limits left of it.
     * @param P: Piece
     * @param B : Board
     * @return True if it will colide left of it, False otherwise
     */
    public static boolean CheckCollisionLeft(Piece P, Board B) {
        int piece_height = P.getForm().length;
        int piece_width = P.getForm()[0].length;
        int piece_y = P.getY();
        int piece_x = P.getX();
        //Checks every cell of the form[][] of the piece
        for (int y = piece_y; y < piece_y + piece_height; y++) {
            for (int x = piece_x; x < piece_x + piece_width; x++) {
                //If there are a piece part on the cell, checks for collision
                if (P.getForm()[y - piece_y][x - piece_x] != Color.WHITE) {
                    //Out of bounds collision
                    if (x - 1 < 0)
                        return true;
                    //Piece to piece collision
                    if (B.getLanded()[y][x-1] != Color.WHITE)
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if a piece will colide with another piece or the board limits right of it.
     * @param P: Piece
     * @param B : Board
     * @return True if it will colide right of it, False otherwise
     */
    public static boolean CheckCollisionRight(Piece P, Board B) {
        int piece_height = P.getForm().length;
        int piece_width = P.getForm()[0].length;
        int piece_y = P.getY();
        int piece_x = P.getX();
        //Checks every cell of the form[][] of the piece
        for (int y = piece_y; y < piece_y + piece_height; y++) {
            for (int x = piece_x; x < piece_x + piece_width; x++) {
                //If there are a piece part on the cell, checks for collision
                if (P.getForm()[y - piece_y][x - piece_x] != Color.WHITE) {
                    //Out of bounds collision
                    if (x + 1 >= B.getWidth())
                        return true;
                    //Piece to piece collision
                    if (B.getLanded()[y][x+1] != Color.WHITE)
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if a row is completed with Tetrominoes
     * @param B: Board
     * @param y: Position of the row to check for completion
     * @return true if row is complete, otherwise false
     */
    public static boolean CheckRowCompletion(Board B, int y) {
        for (int x = 0; x < B.getWidth(); x++) {
            if (B.getLanded()[y][x] == Color.WHITE)
                return false;
        }
        return true;
    }

    /**
     * Piece Drop Down functions, when used, immediately drops the piece to the lowest possible space
     * @param B: Board
     * @param P: Piece
     */
    public static void DropDown(Board B, Piece P) {
        while (!CheckCollisionUnder(P, B)) {
            P.addY(1);
        }
    }

    /**
     * Runs the game with the specified conditions
     * @param B: Board to run the game
     */
    public static void run(Board B) {
        //Tick counter
        double t = 0;
        //Delta Time, defines the Frame Rate: dt = 1000 ms / FPS
        double dt = 1000.0/30.0;
        //Piece that the player controls, start as null value
        Piece P = B.getFallingPiece();
        //Game loop. Exits only when a piece overflows the board, triggering a break
        while (true) {
            //Piece Checks
            //Piece Existence check
            if (B.getFallingPiece() == null) {
                int rand_piece = ThreadLocalRandom.current().nextInt(1, 8);
                if (rand_piece == 1) {
                    P = new Ipiece();
                    P.spawn(0, 10);
                    B.setFallingPiece(P);
                }
                else if (rand_piece == 2) {
                    P = new Opiece();
                    P.spawn(0, 9);
                    B.setFallingPiece(P);
                }
                else if (rand_piece == 3) {
                    P = new Lpiece();
                    P.spawn(0, 9);
                    B.setFallingPiece(P);
                }
                else if (rand_piece == 4) {
                    P = new Tpiece();
                    P.spawn(0, 8);
                    B.setFallingPiece(P);
                }
                else if (rand_piece == 5) {
                    P = new Zpiece();
                    P.spawn(0, 8);
                    B.setFallingPiece(P);
                }
                else if (rand_piece == 6) {
                    P = new Jpiece();
                    P.spawn(0, 9);
                    B.setFallingPiece(P);
                }
                else if (rand_piece == 7) {
                    P = new Spiece();
                    P.spawn(0, 8);
                    B.setFallingPiece(P);
                }
            }
            //Overflown Check (Stoppage)
            /*if (CheckCollisionOver(P, B)) {
                break;
            }*/

            //Piece Side Movement
            // (#WIP) Needs Sniffer for User Input, only available when using Graphics

            //Piece Movement
            if (t % 1 == 0) {
                //If the piece collides with another, updates the landed matrix and clear piece
                if (CheckCollisionUnder(P, B)) {
                    B.updateLanded();
                    if (CheckCollisionOver(P, B)) {
                        clearScreen();
                        System.out.println(B);
                        break;
                    }
                    B.clearPiece();
                }
                else {
                    B.clear();
                    P.addY(1);
                    B.update();
                }
            }

            //Print Statements
            clearScreen();
            System.out.println(B);

            //Check if there are any row Deletions to be made
            for (int i = 0; i < B.getHeight(); i++) {
                if (CheckRowCompletion(B, i))
                    B.deleteLine(i);
            }


            //Engine Runtime Organization
            //Tick Updater
            t++;
            //Sleep Function to regulate the game run speed
            try {
                Thread.sleep((int) dt);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
