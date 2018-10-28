/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;

/**
 *
 * @author User
 */
public class Guess {

    private int min;
    private int max;
    private int rand;   // Random number
    private int limit;  // Guess times limit

    /**
     * 
     * Initialize the Game
     */
    public Guess(int min, int max, int limit) {
        this.min = min;
        this.max = max;
        this.limit = limit;
        this.rand = (int) (Math.random() * (max - min + 1) + min);
    }
    
    /**
     * 
     * @param guess User's input
     * @return True if answer correct, else return false and refresh the status of the game
     */
    public boolean isCorrect(int guess) {
        if (guess < min || guess > max) {
            System.out.println("Wrong Guess! You are out of range!");
            return false;
        } else if (guess > rand) {
            System.out.println("Wrong Guess! Your number is larger than the answer!");
            this.max = guess - 1;
            return false;
        } else  if (guess < rand) {
            System.out.println("Wrong Guess! Your number is smaller than the answer!");
            this.min = guess + 1;
            return false;
        }else {
            return true;
        }
    }

    /**
     * 
     * @param count How many times user has guess
     * @return 
     */
    public boolean isOverLimit(int count) {
        if (count < limit) {
            return false;
        } else {
            return true;
        }
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getRand() {
        return rand;
    }

    public int getLimit() {
        return limit;
    }
    
    

}
