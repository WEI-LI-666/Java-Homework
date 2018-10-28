/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1;

import java.util.Scanner;

/**
 *
 * @author B10409009
 */
public class BookTest {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {

        //create first book from argument
        Book book1 = new Book(args[0], args[1], Double.parseDouble(args[2]));
        book1.getBookInfo();

        //wait for user input
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Second Book's Name: "); //bookName
        String bName = scanner.next();
        System.out.println("Enter Second Book's Code: "); //bookCode
        String bCode = scanner.next();
        System.out.println("Enter Second Book's Price: "); //bookPrice
        double bPrice = scanner.nextDouble();

        // create second book
        Book book2 = new Book(bName, bCode, bPrice);
        book2.getBookInfo();
    }
}
