package com.ithema.a07test1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //客户端：多次发送数据
        //服务器：接受多次接收数据，并打印

        //1.创建Socket对象
        Socket socket=new Socket("127.0.0.1",9999);

        //2.写出数据
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("请输入您要发送的信息");
            String str=sc.nextLine();
            if (str.equals("886")){
                break;
            }
            OutputStream os=socket.getOutputStream();
            os.write(str.getBytes());
        }

        //3.释放资源
        socket.close();
    }
}
