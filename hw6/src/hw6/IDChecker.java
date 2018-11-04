/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw6;

import java.util.regex.*;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class IDChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Pattern p = Pattern.compile("[0-1]");
        ID idVer = new ID();

        while (true) {
            System.out.println("*************");
            System.out.printf("%1d.\tVerify ID\n", 1);
            System.out.printf("%1d.\tExit\n", 0);
            System.out.println("*************");
            System.out.printf("Please select: ");

            Scanner scan = new Scanner(System.in);
            String select = scan.nextLine();
            Matcher m = p.matcher(select);

            if (!m.matches()) {
                System.out.println("Wrong command! Please type it again!");
            } else if (select.equals("0")) {   // Select 0 then break 
                break;
            } else {    // Go into ID Verification
                System.out.printf("\nPlease enter the ID: ");
                String in = scan.nextLine();
                idVer.check(in);
            }
        }
    }
}
