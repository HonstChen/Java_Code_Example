package com.ithema.File;

import java.io.File;

public class Demo1 {
    public static void main(String[] args) {
        File f = new File("D:\\");
        String[] list = f.list();
        for (String s : list) {
            System.out.println(s);
        }
    }
}
