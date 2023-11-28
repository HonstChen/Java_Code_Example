package com.ithema.myioTest1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class enumeratorDemo4 {
    //班级，要求点完名之后开始下一轮点名
    //利用哈希表，表中所有元素均点过之后便可以不点
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("myfil\\aaa\\info.txt"));
        HashSet<String> nameList=new HashSet<>();
        String line;
        while ((line=br.readLine())!=null){
            nameList.add(line.split("-")[0]);
        }
        BufferedReader br1=null;
        HashSet<String> alreadyPoint=new HashSet<>();
        try {
            br1=new BufferedReader(new FileReader("myfile\\aaa\\data1.txt"));
        }catch (IOException e){
            File file=new File("myfile\\aaa\\data1.txt");
            br1=new BufferedReader(new FileReader("myfile\\aaa\\data1.txt"));
        }finally {
            while ((line=br1.readLine())!=null){
                alreadyPoint.add(line);
            }
        }
        while (true){
            //点名，判断哈希表中是否已经存在该元素，存在则更换
        }
    }
}
