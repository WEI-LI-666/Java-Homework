/*
 * Copyright (c) 11.2018.  by Willy
 */

package hw9;

import java.util.Calendar;
import java.util.Date;

public class Time {
    String hh, mm, ss;

    public Time(String hh, String mm, String ss) {
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
    }

    public void countDown(){
        int ihh, imm, iss;
        ihh = Integer.parseInt(this.hh);
        imm = Integer.parseInt(this.mm);
        iss = Integer.parseInt(this.ss);

        /* Get current time and set alarm time */
        Calendar current = Calendar.getInstance();
        Calendar alarm = Calendar.getInstance();
        alarm.setTime(new Date());
        alarm.set(current.get(Calendar.YEAR), current.get(Calendar.MONTH), current.get(Calendar.DAY_OF_MONTH), ihh, imm, iss);

        long timeMS = alarm.getTime().getTime() - current.getTime().getTime();
        int timeS = (int) ((timeMS / 1000) % 60);
        int timeM = (int) ((timeMS / (60 * 1000)) % 60);
        int timeH = (int) (timeMS / (60 * 60 * 1000));

        /* Clock time offset */
        if(timeS < 0){
            timeS += 60;
            timeM -= 1;
        }
        if(timeM < 0){
            timeM += 60;
            timeH -= 1;
        }
        if(timeH < 0) timeH += 24;

        /* Output string */
        String output = "The alarm starts after ";

        if(timeH != 0) output += (timeH + " hours ");
        if(timeM != 0 && timeS != 0 || timeH == 0 && timeM != 0){
            output += (timeM + " minutes ");
        } else if (timeS == 0){
            output += (" and " + timeM + " minutes ");
        }
        if(timeH == 0 && timeM == 0){
            output += (timeS + " seconds ");
        } else {
            output += (" and " + timeS + " seconds ");
        }

        System.out.println(output);

    }
}
