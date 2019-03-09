package study_file1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class MyTime {
    private short hour;
    private short minute;
    private short second;

    public MyTime(){
        Calendar c = Calendar.getInstance();
        this.hour = (short)c.get(Calendar.HOUR_OF_DAY);
        this.minute = (short)c.get(Calendar.MINUTE);
        this.minute = (short)c.get(Calendar.SECOND);
    }

    public MyTime(short hour, short minute, short second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        if (hour < 0 || hour > 23) {
            this.hour = 0;
        }
        if (minute < 0 || minute > 59) {
            this.minute = 0;
        }
        if (second < 0 || second > 59) {
            this.minute = 0;
        }
    }

    public String timeDifference(MyTime a){
        int dif = Math.abs((hour*3600 + minute*60 + second) - (a.hour*3600 + a.minute*60 + a.second));
        return dif/3600+":"+(dif%3600)/60+":"+dif%60;
    }

    @Override
    public String toString() {
        return hour+":"+minute+":"+second;
    }
}

class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MyTime time1 = new MyTime(input.nextShort(), input.nextShort(), input.nextShort());
        MyTime time2 = new MyTime();
        System.out.println("current time " + time2);
        System.out.println("input time " + time1);
        System. out .println("difference "+time1.timeDifference(time2));
    }
}
