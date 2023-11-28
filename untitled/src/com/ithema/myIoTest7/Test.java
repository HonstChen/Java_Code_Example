package com.ithema.myIoTest7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        //1.读取正确的用户名和密码
        BufferedReader br=new BufferedReader(new FileReader("D:\\Java_Code\\untitled\\myfile\\aaa\\userInfo.txt"));
        String line=br.readLine();
        System.out.println(line);
        br.close();
        String[] userInfo = line.split("&");
        String[] arr1 = userInfo[0].split("=");
        String[] arr2 = userInfo[1].split("=");
        //2.键盘录入用户名和密码
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String username=sc.nextLine();
        System.out.println("请输入密码");
        String password=sc.nextLine();
        if (username.equals(arr1[1])&&password.equals(arr2[1])){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }
}
