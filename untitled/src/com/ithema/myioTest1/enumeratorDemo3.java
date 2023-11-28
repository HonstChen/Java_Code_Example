package com.ithema.myioTest1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class enumeratorDemo3 {
    public static void main(String[] args) throws IOException {
        //从文件中读取班级同学的信息，并且实现随机点名
        BufferedReader bf=new BufferedReader(new FileReader("myfile\\aaa\\info.txt"));
        BufferedReader b=null;
        int count;
        try {
            b=new BufferedReader(new FileReader("myfile\\aaa\\data.txt"));
        }catch (FileNotFoundException e){
            /*e.printStackTrace();*/
            BufferedWriter bw=new BufferedWriter(new FileWriter("myfile\\aaa\\data.txt"));
            bw.write("1");
            bw.close();
            b=new BufferedReader(new FileReader("myfile\\aaa\\data.txt"));
        }finally {
            count=Integer.parseInt(b.readLine());
            b.close();
        }
        ArrayList<String> list=new ArrayList<>();
        String line;
        while((line=bf.readLine())!=null){
            list.add(line.split("-")[0]);
        }
        if (count==3){
            System.out.println("张三");
        }else {
            Collections.shuffle(list);
            System.out.println(list.get(0));
        }
        bf.close();
        FileWriter fw=new FileWriter("myfile\\aaa\\data.txt");
        fw.write((count+1)+"");
        fw.close();
    }
}
