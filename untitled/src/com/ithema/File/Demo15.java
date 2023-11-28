package com.ithema.File;

import java.io.*;

public class Demo15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("myfile\\aaa\\count.txt"));
        String line;
        line = br.readLine();
        if (Integer.parseInt(line) > 2) {
            System.out.println("免费试用超过三次");
        } else {
            System.out.println("免费试用中");
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("myfile\\aaa\\count.txt"));
        bw.write(String.valueOf(Integer.parseInt(line) + 1));
        bw.close();
    }
}
