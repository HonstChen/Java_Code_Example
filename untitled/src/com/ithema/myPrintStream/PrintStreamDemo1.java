package com.ithema.myPrintStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class PrintStreamDemo1 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //1.创建字节打印流的对象
        PrintStream ps = new PrintStream(new FileOutputStream("myfile\\aaa\\aq.txt"), true, "UTF-8");
        //2.写出数据
        ps.println(97);
        ps.println(98);
        ps.println(true);
        ps.close();
    }
}
