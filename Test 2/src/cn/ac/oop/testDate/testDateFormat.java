package cn.ac.oop.testDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class testDateFormat {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss，ww") ;
        Date d = new Date(1232432442343353L);
        String str = df.format(d);
        System.out.println(str);
        String str2 = "3034-12,30  05:45:34";
        DateFormat df2 = new SimpleDateFormat("yyyy-MM,dd  hh:mm:ss");
        try{
            Date a = df2.parse(str2);
            System.out.println(df.format(a));
        }catch (ParseException e){
            e.printStackTrace();
        }

    }
}
