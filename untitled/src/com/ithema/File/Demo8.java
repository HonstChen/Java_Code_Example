package com.ithema.File;

import java.io.*;
import java.time.LocalTime;

public class Demo8 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        //创建对象
        FileInputStream fis = new FileInputStream("D:\\钉钉\\DingDing\\main\\current\\plugins\\tblive\\data\\conf_res\\background_res\\01.mp4");
        FileOutputStream fos = new FileOutputStream("myfile\\aaa\\copy.mp4");
        //记录时间，单位为毫秒

        //拷贝
        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }
        fos.close();
        fis.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
