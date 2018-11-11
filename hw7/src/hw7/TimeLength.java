/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw7;

/**
 *
 * @author User
 */
public class TimeLength {
    
    private int second = 0; /* Seconds in "hh:mm:ss" format */ 
    private int minute = 0; /* Minutes in "hh:mm:ss" format */
    private int hour = 0;   /* Hours in "hh:mm:ss" format */
    private int cSec = 0;   /* Seconds in converted seconds format */
    
    /**
     *
     * @param ss - converted seconds
     */
    public void setTime(int ss){
        this.cSec = ss;
        if(this.cSec < 0){
            this.second = Math.abs(this.cSec) % 60;
            this.minute = (Math.abs(this.cSec) / 60) % 60;
            this.hour = this.cSec / 3600;
        } else {
            this.second = this.cSec % 60;
            this.minute = (this.cSec / 60) % 60;
            this.hour = this.cSec / 3600;
        }
    }
    
    /**
     *
     * @param hh
     * @param mm
     * @param ss
     */
    public void setTime(int hh, int mm , int ss){
        this.hour = hh;
        this.minute = mm;
        this.second = ss;
        if(this.hour < 0){
            if(this.second > 59){
                this.minute++;
                this.second  = this.second % 60;
            }
            if(this.minute > 59){
                this.hour--;
                this.minute  = this.minute % 60;
            }
            cSec = Math.negateExact(this.second + this.minute * 60 + Math.abs(this.hour) * 3600);
        } else {
            if(this.second > 59){
                this.minute++;
                this.second  = this.second % 60;
            }
            if(this.minute > 59){
                this.hour++;
                this.minute  = this.minute % 60;
            }
            cSec = this.second + this.minute * 60 + this.hour * 3600;
        }
    }
    
    /**
     *
     * @param ss converted seconds
     */
    public void adjustTime(int ss){
        this.cSec += ss;
        setTime(this.cSec);
    }
    
    /**
     *
     * @param hh
     * @param mm
     * @param ss
     */
    public void adjustTime(int hh, int mm , int ss){
        int fix_time = Math.abs(hh) * 3600 + mm * 60 + ss;
        if(hh < 0){
            this.cSec -= fix_time;
            setTime(this.cSec);
        } else {
            this.cSec += fix_time;
            setTime(this.cSec);
        }
    }
    
    public void showTimeInConverted(){
        System.out.printf("The current length of time (seconds): %d\n", this.cSec);
    }
    
    public void showTimeInHMS(){
        if(this.cSec < 0){
            System.out.printf("The current length of time (hh:mm:ss): -%02d:%02d:%02d\n", Math.abs(this.hour), this.minute, this.second);
        } else {
            System.out.printf("The current length of time (hh:mm:ss): %02d:%02d:%02d\n", Math.abs(this.hour), this.minute, this.second);
        }
    }
}
