package com.ithema.myioTest1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class enumeratorDemo2 {
    public static void main(String[] args) throws IOException {
        //从文件中读取班级同学的信息，并且实现随机点名
        BufferedReader bf=new BufferedReader(new FileReader("myfile\\aaa\\info.txt"));
        ArrayList<String> list=new ArrayList<>();
        String line;
        int index=0;
        while((line=bf.readLine())!=null){
            list.add(line.split("-")[0]);
            if (line.split("-")[1].equals("女")){

            }else {
                index++;
            }
        }
        bf.close();
        /*System.out.println(index);*/
        //首先读取文件，接下来百分之七十概率随机到男生，百分之30概率随机到女生，先创建一个数组
        //Random,或者使用数组
        Random random=new Random();

        int boycount=0;
        int girlcount=0;
        for (int i1 = 0; i1 < 10000; i1++) {
            int i = random.nextInt(10)+1;//1,2,3,4,5,6,7,8,9,10
            if (i<=7){
                //男生
                /*System.out.println("男生");
                System.out.println(list.get(random.nextInt(index)));*/
                boycount++;
            }else {
                //女生
                /*System.out.println("女生");
                System.out.println(list.get(random.nextInt(index,list.size())));
            */
                girlcount++;
            }
        }
        System.out.println(boycount/(float)(boycount+girlcount));
    }
}
