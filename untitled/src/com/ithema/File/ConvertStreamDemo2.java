package com.ithema.File;

import java.io.*;
import java.nio.charset.Charset;

public class ConvertStreamDemo2 {
    public static void main(String[] args) throws IOException {
        //1.创建转换流的对象
        /*OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("myfile\\aaa\\b1.txt"),"GBK");
        //2.写出数据
        osw.write("你好你好");
        osw.close();
*/
        /*FileWriter fw=new FileWriter("myfile\\aaa\\b1.txt", Charset.forName("GBK"));
        fw.write("你好！");
        fw.close();*/

        FileReader fr=new FileReader("myfile\\aaa\\b1.txt",Charset.forName("GBK"));
        FileWriter fw=new FileWriter("myfile\\aaa\\b2.txt",Charset.forName("UTF-8"));
        int b;
        while ((b=fr.read())!=-1){
            fw.write(b);
        }
        fw.close();
        fr.close();
    }
}
