package com.ithema.myPrintStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintStreamDemo3 {
    //打印流不操作数据，只能操作目的地
    public static void main(String[] args) throws IOException {
        //1.创建字符打印流的对象
        PrintWriter pw = new PrintWriter(new FileWriter("myfile\\aaa\\b.txt"), true);
        //写出数据
        pw.println("你好你好!");
        pw.close();

        //打印流的应用场景, System是最终类
        //特殊打印流，系统的标准输出流
        PrintStream out = System.out;
        //调用打印流的方法
        //写出数据，自动换行，自动刷新
        out.println("123");
    }
}
