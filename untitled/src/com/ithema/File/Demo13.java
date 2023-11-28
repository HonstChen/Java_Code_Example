package com.ithema.File;

import java.io.*;
import java.util.Arrays;

public class Demo13 {
    public static void main(String[] args) throws IOException {
        //1.打开文件
        FileReader fr = new FileReader("D:\\Java_Code\\untitled\\myfile\\aaa\\a.txt");
        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = fr.read()) != -1) {
            sb.append((char) ch);
        }
        fr.close();
        System.out.println(sb);
        //2.排序
        Integer[] array = Arrays.stream(sb.toString()
                        .split("-"))
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);

        //3.写出
        String s = Arrays.toString(array).replace(", ", "-");
        System.out.println(s);
        System.out.println(s.substring(1, s.length() - 1));
        FileWriter fw = new FileWriter("myfile\\b.txt");
        fw.write(s.substring(1,s.length()-1));
        fw.close();
    }
}
