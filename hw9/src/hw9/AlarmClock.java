/*
 * Copyright (c) 11.2018.  by Willy
 */

package hw9;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AlarmClock {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Time time;
        String[] input = new String[0];
        boolean isFormatCorrect = true;
        Pattern pH = Pattern.compile("[0-2]\\d");   // Hour's regex
        Pattern pMS = Pattern.compile("[0-5]\\d");  // Minute's and Second's regex

        do{
            showDateTime();
            System.out.printf("Please set alarm time(hh:mm:ss): ");
            try{
                input = scan.nextLine().split(":");
                isFormatCorrect = true;
                if(!pH.matcher(input[0]).matches()){
                    throw new TimeFormatException("TimeFormatException: Invalid hour format");
                }
                if(!pMS.matcher(input[1]).matches()){
                    throw new TimeFormatException("TimeFormatException: Invalid minute format");
                }
                if(!pMS.matcher(input[2]).matches()){
                    throw new TimeFormatException("TimeFormatException: Invalid second format");
                }
            }catch (TimeFormatException tfe){
                System.out.println(tfe.getMessage() + "\n");
                isFormatCorrect = false;
            }
        }while (!isFormatCorrect);

        time = new Time(input[0], input[1], input[2]);
        showDateTime();
        time.countDown();
    }

    public static void showDateTime() {
        Calendar current = Calendar.getInstance();
        System.out.println(current.getTime());
    }
}
