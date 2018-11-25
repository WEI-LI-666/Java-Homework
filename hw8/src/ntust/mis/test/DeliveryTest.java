/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntust.mis.test;

import java.util.Scanner;
import java.util.regex.Pattern;
import ntust.mis.oo.*;

/**
 *
 * @author User
 */
public class DeliveryTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Delivery delivery = null;
        Person sender = null;
        Person receiver = null;
        Goods goods = null;
        char ch = 'y';
        Scanner scan = new Scanner(System.in);
        String sName, rName;
        String sPhone, rPhone;
        String sAddress, rAddress;
        String gName, gWeight, gType;
        double currentWeight = 0.0;
        
        do {
            /* Sender's info */
            System.out.printf("Please enter the sender's name: ");
            sName = scan.nextLine();
            do {
                System.out.printf("Please enter the sender's phone: ");
                sPhone = scan.nextLine();
            } while (!inputCheck(sPhone, 1));
            do {
                System.out.printf("Please enter the sender's address(Please Enter 1-5)\n"
                        + "(1)Taipei (2)Taichung (3)Kaohsiung (4)Hsinchu (5)Hualien: ");
                sAddress = scan.nextLine();
            } while (!inputCheck(sAddress, 2));
            System.out.println("\n");
            sender = new Person(sName, sPhone, City.values()[Integer.parseInt(sAddress) - 1]);
            
            /* Reveiver's info */
            System.out.printf("Please enter the reveiver's name: ");
            rName = scan.nextLine();
            do {
                System.out.printf("Please enter the reveiver's phone: ");
                rPhone = scan.nextLine();
            } while (!inputCheck(rPhone, 1));
            do {
                System.out.printf("Please enter the reveiver's address(Please Enter 1-5)\n"
                        + "(1)Taipei (2)Taichung (3)Kaohsiung (4)Hsinchu (5)Hualien: ");
                rAddress = scan.nextLine();
            } while (!inputCheck(rAddress, 2));
            System.out.println("\n");
            receiver = new Person(rName, rPhone, City.values()[Integer.parseInt(rAddress) - 1]);
            
            /* Good's info */
            System.out.printf("Please enter the good's name: ");
            gName = scan.nextLine();
            do {
                System.out.printf("Please enter the good's weight: ");
                gWeight = scan.nextLine();
            } while (!inputCheck(gWeight, 4));
            do {
                System.out.printf("Please enter the good's type\n"
                        + "(1)Business (2)Personal: ");
                gType = scan.nextLine();
            } while (!inputCheck(gType, 3));
            System.out.println("\n");
            goods = new Goods(gName, Double.parseDouble(gWeight), Type.values()[Integer.parseInt(gType) - 1]);
            
            /* Do delivery */
            delivery = new Delivery(sender, receiver, goods);
            Delivery.currentWeight = currentWeight;
            delivery.send(); 
            if(delivery.getAvaliableWeight() == 0.0) break;
            currentWeight = Delivery.currentWeight;
            do {
                System.out.printf("Do you want to continue? (y/n)\n");
                ch = scan.nextLine().charAt(0);
            } while (!inputCheck(ch + "", 5));
        } while (ch == 'y' || ch == 'Y');
        
    }
    
    public static boolean inputCheck(String input, int type){
        Pattern p1 = Pattern.compile("\\d{6,}");   // Phone number
        Pattern p2 = Pattern.compile("[1-5]");   // Address
        Pattern p3 = Pattern.compile("[1-2]");   // Good's type
        Pattern p4 = Pattern.compile("[1-9]\\d*");   // Good's weight
        Pattern p5 = Pattern.compile("[y|Y|n|N]");   // continue : y or n
        
        if (p1.matcher(input).matches() && type == 1) return true;
        if (p2.matcher(input).matches() && type == 2) return true;
        if (p3.matcher(input).matches() && type == 3) return true;
        if (p4.matcher(input).matches() && type == 4) return true;
        if (p5.matcher(input).matches() && type == 5) return true;
        
        return false;
    }
    
}
