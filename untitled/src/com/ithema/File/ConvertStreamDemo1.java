package com.ithema.File;

import java.io.*;
import java.nio.charset.Charset;

public class ConvertStreamDemo1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(new FileInputStream("myfile\\aaa\\gbkfile.txt"),"GBK");
        /*int ch;
        while ((ch=isr.read())!=-1){
            System.out.println((char) ch);
        }
        isr.close();*/
        //替代方案

        FileReader fr=new FileReader("myfile\\aaa\\gbkfile.txt", Charset.forName("GBK"));
        int ch;
        while ((ch=fr.read())!=-1){
            System.out.println((char) ch);
        }
        fr.close();
    }
}
