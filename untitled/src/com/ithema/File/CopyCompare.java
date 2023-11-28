package com.ithema.File;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CopyCompare {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("myfile\\csb.txt"));
        String line;
        //读取加排序
        ArrayList<String> list = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        br.close();

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i1 = Integer.parseInt(o1.split("\\.")[0]);
                int i2 = Integer.parseInt(o2.split("\\.")[0]);
                return i1-i2;
            }
        });
        BufferedWriter bw=new BufferedWriter(new FileWriter("myfile\\copy.txt"));
        for (String s : list) {
            bw.write(s.split("\\.")[1]);
            bw.newLine();
        }
        bw.close();
    }
}
