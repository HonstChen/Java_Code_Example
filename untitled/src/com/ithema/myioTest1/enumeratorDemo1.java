package com.ithema.myioTest1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class enumeratorDemo1 {
    public static void main(String[] args) throws IOException {
        //从文件中读取班级同学的信息，并且实现随机点名
        BufferedReader bf=new BufferedReader(new FileReader("myfile\\aaa\\info.txt"));
        ArrayList<String> templist=new ArrayList<>();
        String line;
        while((line=bf.readLine())!=null){
            templist.add(line);
        }
        bf.close();
        ArrayList<String> list=new ArrayList<>();
        for (String s : templist) {
            list.add(s.split("-")[0]);
        }
        //随机点名器
        Collections.shuffle(list);
        System.out.println(list.get(0));
    }
}
