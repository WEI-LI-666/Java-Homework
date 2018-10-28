/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;

import java.util.Scanner;
import hw4.TicTacToe.*;

/**
 *
 * @author User
 */
public class GameLauncher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
        Scanner scan = new Scanner(System.in);
        char ch;
        boolean _run = true;

        do {
            ttt.initGame();
            System.out.println("********** Game Start **********");
            do {
                ttt.playerMove(ttt.currentPlayer);
                ttt.updateGame(ttt.currentPlayer, ttt.currentRow, ttt.currentCol);
                ttt.printBoard();
                // Print messege
                if (ttt.currentState == GameState.CROSS_WON) {
                    System.out.println("Player-X is the winner!");
                } else if (ttt.currentState == GameState.NOUGHT_WON) {
                    System.out.println("Player-O is the winner!");
                } else if (ttt.currentState == GameState.DRAW) {
                    System.out.println("It's a Draw!");
                }

                // Switch player
                ttt.currentPlayer = (ttt.currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
            } while (ttt.currentState == GameState.PLAYING);

            System.out.println("********** Game Over **********");
            while (true) {
                System.out.println("********** Play again(Y/N)? **********");
                String line = scan.nextLine();
                if (line.isEmpty() || line == null) {
                    System.out.println("Wrong Command!\n");
                } else {
                    ch = line.charAt(0);
                    if (ch == 'N' || ch == 'n') {
                        _run = false;
                        break;
                    } else if (ch == 'Y' || ch == 'y') {
                        break;
                    } else {

                    }
                }
            }
        } while (_run);
    }

}
