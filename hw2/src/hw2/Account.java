/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

import java.util.Scanner;

/**
 *
 * @author B10409009
 */
public class Account {

    /**
     * @var account status check for open an account
     * @var amount amount of deposit or withdraw
     * @var balance account balance
     */
    private boolean account = false;
    private double balance;
    private int amount;
    Scanner scanner;

    public boolean isOpened() {
        return this.account;
    }

    public void setAccount(int select) {
        if(isOpened()){            
            switch(select){
                case 1: //check did account exist
                    System.out.println("Account already exists!\n");
                case 2: // make a deposit
                    try {  // inputtype check
                        System.out.printf("Deposit amount: ");
                        scanner = new Scanner(System.in);
                        amount = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Deposit Failed! Please input amount!\n");
                        break;
                    }
                    // amount must be non-negative number
                    if(amount<0){
                        System.out.println("Deposit Failed! Please input non-negative number!\n");
                    } else {
                        this.balance += amount;
                    }
                    break;
                case 3: // ask for balance
                    System.out.printf("Your Balance: $%.2f \n\n", this.balance);
                    break;
                case 4: // make a withdraw
                    try {  // inputtype check
                        System.out.printf("Withdraw amount: ");
                        scanner = new Scanner(System.in);
                        amount = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Withdraw Failed! Please input amount!\n");
                        break;
                    }
                    // amount must be non-negative number
                    if(amount<0){
                        System.out.println("Withdraw Failed! Please input non-negative number!\n");
                    } else if(amount > this.balance){
                        System.out.println("Withdraw Failed! Withdraw amount is larger than balance!\n");
                    } else {
                        this.balance -= amount;
                    }
                    break;
                default:
                    // you won't and shouldn't get here
                    break;
            }
        } else if(select == 1 && !isOpened()){ // If user didn't open an accound, then let user open 
            try {  // inputtype check
                System.out.printf("Account opening amount: ");
                scanner = new Scanner(System.in);
                amount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Account opening Failed! Please input amount!\n");
            }
            if(amount < 1000){
                System.out.println("Account opening Failed! Account opening amount should more or equal than 1000 dollars!\n");
            } else {
                this.account = true;
                this.balance = amount;
                System.out.println("Account opening success! \n");
            }
        } else {
            System.out.println("Please open an account first!\n");
        }
        
    }

}
