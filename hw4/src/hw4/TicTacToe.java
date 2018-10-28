/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class TicTacToe {

    /**
    * Enumerations for the seeds and cell contents.
    */
    public enum Seed {
        EMPTY, CROSS, NOUGHT
    }

    /**
    *  Enumerations for the various states of the game.
    */
    public enum GameState {
        PLAYING, DRAW, CROSS_WON, NOUGHT_WON
    }
    // Game boards and game status
    public static final int ROWS = 3, COLS = 3;
    public static Seed[][] board = new Seed[ROWS][COLS]; // game board in 2D array {EMPTY, CROSS, NOUGHT}
    public static GameState currentState; // current state of the game {PLAYING, DRAW, CROSS_WON, NOUGHT_WON}
    public static int currentRow, currentCol;
    public static Seed currentPlayer;

    public static Scanner scan = new Scanner(System.in);

    /**
     * Initialize the game board contents and states.
     */
    public void initGame() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = Seed.EMPTY;
            }
        }
        currentPlayer = Seed.CROSS;
        currentState = GameState.PLAYING;
    }

    /**
     * Player with the "theSeed" makes one move, with input validation Update
     * global variables "currentRow" and "currentCol".
     */
    public void playerMove(Seed theSeed) {
        String pattern = "^[1-3]\\,[1-3]$";
        String In; // User's input
        String[] sIn; // Separate User's input by comma
        int row = -1, col = -1;
        boolean validInput = false; // Input validation
        do {
            if (theSeed == Seed.CROSS) {
                System.out.printf("Player-X, enter your move (row[1-3],column[1-3]): ");
            } else if (theSeed == Seed.NOUGHT) {
                System.out.printf("Player-O, enter your move (row[1-3],column[1-3]): ");
            }
            In = scan.nextLine();
            if (In.matches(pattern)) {
                sIn = In.split(",");
                row = Integer.parseInt(sIn[0]) - 1;  // array index starts at 0 instead of 1
                col = Integer.parseInt(sIn[1]) - 1;
            }

            if (row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col] == Seed.EMPTY) {
                currentRow = row;
                currentCol = col;
                board[currentRow][currentCol] = theSeed;  // update game-board content
                validInput = true;  // input okay, exit loop
            } else {
                System.out.println("The value you entered is invalid! Please try again.");
                System.out.println("");
            }
        } while (!validInput);
    }

    /**
     * Update the "currentState" after the player with "theSeed" has placed on
     * (currentRow, currentCol).
     */
    public void updateGame(Seed theSeed, int currentRow, int currentCol) {
        if (hasWon(theSeed, currentRow, currentCol)) {
            currentState = (theSeed == Seed.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
        } else if (isDraw()) {   // Check the draw
            currentState = GameState.DRAW;
        }
        // Otherwise, no change to currentState, continue playing
    }

    /**
     * Return true if Draw.
     */
    public boolean isDraw() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] == Seed.EMPTY) {
                    return false; // an empty cell found, not draw, exit
                }
            }
        }
        return true;
    }

    /**
     * Return true if the player with "theSeed" has won after placing at
     * (currentRow, currentCol).
     */
    public boolean hasWon(Seed theSeed, int currentRow, int currentCol) {
        return (board[currentRow][0] == theSeed // 3-in-one-row
                    && board[currentRow][1] == theSeed
                    && board[currentRow][2] == theSeed
                || board[0][currentCol] == theSeed // 3-in-one-column
                    && board[1][currentCol] == theSeed
                    && board[2][currentCol] == theSeed
                || board[0][0] == theSeed // 3-in-one-diagonal
                    && board[1][1] == theSeed
                    && board[2][2] == theSeed
                || board[0][2] == theSeed // 3-in-one-opposite-diagonal
                    && board[1][1] == theSeed
                    && board[2][0] == theSeed);
    }

    /**
     * Print the game board.
     */
    public void printBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                // Print each of the cells
                printCell(board[row][col]);
                if (col != COLS - 1) {
                    System.out.printf("|"); // Print vertical partition
                }
            }
            if (row != ROWS - 1) {
                System.out.println("\n-----------"); // Print vertical partition
            }
        }
        System.out.println("");
    }

    /**
     * Print a cell with the specified "content".
     */
    public void printCell(Seed content) {
        switch (content) {
            case EMPTY:
                System.out.printf("   ");
                break;
            case NOUGHT:
                System.out.printf(" O ");
                break;
            case CROSS:
                System.out.printf(" X ");
                break;
            default:
                break; // Should never get here
        }
    }

}
