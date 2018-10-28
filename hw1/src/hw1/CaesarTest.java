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
public class CaesarTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Plaintext: "); // input plaintext
        String plaintext = scanner.next();
        System.out.println("Enter key: "); // input offset
        String key = scanner.next();
        //create a caesar object
        Caesar caesar = new Caesar(plaintext, Integer.parseInt(key)); 
        // convert plain to cypher
        caesar.encrypt();
        System.out.printf("Cyphertext: %s\n", caesar.getCyphertext());
    }
}
