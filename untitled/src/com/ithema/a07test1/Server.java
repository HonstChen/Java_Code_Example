package com.ithema.a07test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //客户端：多次发送数据
        //服务器：接受多次接收数据，并打印

        //bs架构，服务器为浏览器

        //1.创建对象绑定端口
        ServerSocket ss=new ServerSocket(9999);

        //2.等待客户端来连接
        Socket socket=ss.accept();

        //3.读取数据
        InputStream is=socket.getInputStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        InputStreamReader isr=new InputStreamReader(socket.getInputStream());
        int b;
        while ((b= isr.read())!=-1){
            System.out.print((char) b);
        }

        //4.释放资源
        socket.close();
        ss.close();
    }
}
