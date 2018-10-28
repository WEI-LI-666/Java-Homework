/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class AccountTest {

    /**
     * @param args the command line arguments
     * @var select user's select
     */
    private static int select;

    public static void main(String[] args) {
        
        Scanner scanner;
        Account account = new Account();

        // do..while loop for not to finish the process every single command
        do {
            System.out.println("***Main Menu***");  // Main screen
            System.out.println("1) Open an account");
            System.out.println("2) Make a deposit");
            System.out.println("3) Make a withdraw");
            System.out.println("4) Account's Balance");
            System.out.println("0) Exit");

            System.out.printf("Please enter a number in[1, 2, 3, 4, 0]: ");

            try { // inputtype check
                scanner = new Scanner(System.in);
                select = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                select = -1;
            }

            if (select == -1) {
                System.out.println("Please type in correct format!\n");
            } else if (select < 0 || select > 4) {
                System.out.println("Number must betweem 0 to 4!\n");
            } else {
                account.setAccount(select);
            }

        } while (select != 0); // input 0 to finish

    }

}
