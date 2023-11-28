package com.ithema.Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo1 {
    public static void main(String[] args) throws ParseException {
        //1.可以通过2000-11-11进行解析，解析成一个Date对象
        String str = "2000-11-11";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date date = sdf.parse(str);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年mm月dd日");
        System.out.println(sdf1.format(date));
    }
}
