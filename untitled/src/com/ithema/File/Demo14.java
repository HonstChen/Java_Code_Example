package com.ithema.File;

import java.io.*;

public class Demo14 {
    //1.创建字符缓冲输入流的对象
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Java_Code\\untitled\\myfile\\aaa\\a.txt"));
        String line1 = br.readLine();
        System.out.println(line1);

        //1.创建字符缓冲输出流的对象
        BufferedWriter bw=new BufferedWriter(new FileWriter("b.txt"));
        //2.写出数据
        bw.write("123");
        bw.newLine();
        bw.write("456");
        bw.close();
        //缓冲流自带8192的缓冲区
        //可以显著提高字节流的读写性能
        //字符缓冲流有两个特有的方法
        //字符缓冲输入流，readLine
        //字符缓冲输出流:newLine
    }
}
