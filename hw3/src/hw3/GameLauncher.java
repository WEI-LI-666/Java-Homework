/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class GameLauncher {

    /**
     * @param args the command line arguments
     * @param parttern Regular Expression for the number check
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String pattern = "^\\d+$";
        String min, max, limit;
        int nMin = 0;
        int nMax = 0;
        int nLimit = 0;
        char ch;
        boolean _run = true;
        List<String> guessList;

        while(_run) {
            System.out.println("********** Guess the Number **********");
            while (true) {
                System.out.printf("Minimum of the guessing range: ");
                min = scan.nextLine();
                if (!min.matches(pattern)) {
                    System.out.println("InputError! Please tpye it again!\n");
                } else {
                    nMin = Integer.parseInt(min);
                    break;
                }
            }
            while (true) {
                System.out.printf("Maximum of the guessing range: ");
                max = scan.nextLine();
                if (!max.matches(pattern) || Integer.parseInt(max) <= nMin) {
                    System.out.println("InputError! Please tpye it again!\n");
                } else {
                    nMax = Integer.parseInt(max);
                    break;
                }
            }
            while (true) {
                System.out.printf("How many times you can guess: ");
                limit = scan.nextLine();
                if (!limit.matches(pattern) || Integer.parseInt(limit) == 0) {
                    System.out.println("InputError! Please tpye it again!\n");
                } else {
                    nLimit = Integer.parseInt(limit);
                    break;
                }
            }

            /**
             * Create and start the game
             */
            Guess guess = new Guess(nMin, nMax, nLimit);
            System.out.println("************* Game Start *************");
            int count = 0;
            guessList = new ArrayList<>();
            while (true) {
                System.out.printf("Number Range: %d ~ %d\n", guess.getMin(), guess.getMax());
                System.out.printf("Number you wan't to guess: ");
                String nInput = scan.nextLine();
                if (!nInput.matches(pattern)) {
                    System.out.println("InputError! Please tpye it again!\n");
                    continue;
                } else {
                    guessList.add(nInput);
                    count++;
                    if (guess.isCorrect(Integer.parseInt(nInput))) {
                        System.out.println("congratulations! You're correct!");
                        break;
                    }
                    if (guess.isOverLimit(count)) {
                        System.out.println("Out of Guess Limit!");
                        break;
                    }
                }
            }
            System.out.println("************* Game Over **************");
            for(int i = 0; i < guessList.size(); i++){
                System.out.printf("Guess %d: %s\n", i + 1, guessList.get(i));
            }
            System.out.println("---");
            System.out.printf("Guess Limit: %d times\n", guess.getLimit());
            System.out.printf("%d time(s) you take\n", count);
            System.out.printf("Correct Number: %d \n", guess.getRand());
            while(true){
                System.out.println("********** Play Again(Y/N)? **********");
                ch = scan.nextLine().charAt(0);
                if(ch == 'N' || ch == 'n'){
                    _run = false;
                    break;
                } else if(ch == 'Y' || ch == 'y'){
                    System.out.println("");
                    break;
                } else {
                    System.out.println("Wrong Command!\n");
                }
            }
        }
    }

}
