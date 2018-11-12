/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw7;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author User
 */
public class TimeLengthTest {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TimeLength tL = new TimeLength();
        int select = 0;
        boolean _run = true;
        String in;
        String[] sin;
        Scanner scan = new Scanner(System.in);
        
        do{
            showMenu();
            System.out.printf("Please enter a number in [1,2,3,0]: ");
            in = scan.nextLine();
            if(inputCheck(in, 1) == 0){ System.out.println("Wrong command!\n");continue; }
            if(inputCheck(in, 1) == 1){
                select = Integer.parseInt(in);
                if(select == 0){
                    /* Exit */
                    _run = false;
                } else if(select == 3) {
                    /* Show out the time */
                    tL.showTimeInConverted();
                    tL.showTimeInHMS();
                    System.out.println("");
                } else {
                    /* Set or adjust the length of time. */
                    System.out.printf("Please enter a time (seconds or hh:mm:ss): ");
                    in = scan.nextLine();
                    if(inputCheck(in, 2) == 0){
                        System.out.println("Wrong Format!\n");
                        continue;
                    }
                    switch(select){
                        case 1: // Set time
                            if(inputCheck(in, 2) == 2) tL.setTime(Integer.parseInt(in));
                            if(inputCheck(in, 2) == 3) {
                                sin = in.split(":");
                                tL.setTime(Integer.parseInt(sin[0]), Integer.parseInt(sin[1]), Integer.parseInt(sin[2]));
                            }
                            System.out.printf("Time:%s\n\n", in);
                            break;
                        case 2: // Adjust time
                            if(inputCheck(in, 2) == 2) tL.adjustTime(Integer.parseInt(in));
                            if(inputCheck(in, 2) == 3) {
                                sin = in.split(":");
                                tL.adjustTime(Integer.parseInt(sin[0]), Integer.parseInt(sin[1]), Integer.parseInt(sin[2]));
                            }
                            System.out.printf("Time:%s\n\n", in);
                            break;
                        default:
                            // Never goes here
                            break;
                    }
                }
            }
            
            
        }while(_run == true);
    }
    
    public static void showMenu(){
        System.out.println("***Convert Length of Time***");
        System.out.println("1) Set the length of time.");
        System.out.println("2) Adjust the length of time.");
        System.out.println("3) Show the length of time in different units.");
        System.out.println("");
    }
    
    /**
     *
     * @param input User's input
     * @param type 1 - User's option
     *              2 - Time
     * @return Return True if format correct
     */
    public static int inputCheck(String input, int type){
        Pattern p1 = Pattern.compile("[0-3]");                      /* For user's option */
        Pattern p2 = Pattern.compile("\\-?[1-9]\\d*");               /* For converted to second format */
        Pattern p3 = Pattern.compile("\\-?\\d{2,}\\:\\d{2}\\:\\d{2}");  /* For hh:mm:ss format */
        
        if(p1.matcher(input).matches() && type == 1) return 1;
        if(p2.matcher(input).matches() && type == 2) return 2;
        if(p3.matcher(input).matches() && type == 2) return 3;
        
        return 0; /* Nothing matches */
    }
}
