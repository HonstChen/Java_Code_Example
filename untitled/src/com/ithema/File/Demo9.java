package com.ithema.File;

import java.io.*;

public class Demo9 {
    public static void main(String[] args) throws IOException {
        //数据流过大的时候，一次只读取一个字节的时候，读取的速度太慢
        //一次只读取一个字节数组的数据，每次读取都尽可能会把数组装满
        long star = System.currentTimeMillis();
        //1.创建对象
        FileInputStream fis = new FileInputStream("D:\\QQ_Download\\MobileFile\\hustzc-master\\3.数据表示实验\\演示效果\\汉字显示实验演示效果.mp4");
        FileOutputStream fos = new FileOutputStream("myfile\\aaa\\copy1.mp4");
        //2.读取数据
        byte[] bytes = new byte[1024 * 1024 * 5];
        //一次读取多个字节数据，具体读多少，和数组的长度有关
        int len;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        fis.close();
        fos.close();

        /*int len;
        while ((len = fis.read()) != -1) {
            fos.write(len);
        }*/
        long end = System.currentTimeMillis();
        System.out.println(end - star);
    }
}
