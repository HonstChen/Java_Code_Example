package com.ithema.a08test2;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //客户端：发送一条数据，接收服务端反馈的消息并打印
        //服务器：接收数据并打印，再给客户端反馈消息

        //1.创建对象并绑定端口
        ServerSocket ss = new ServerSocket(9999);

        //2.等待客户端连接
        Socket socket = ss.accept();

        //3.Socket之中获取输入流
        InputStream inputStream = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader br=new BufferedReader(isr);
        String b;
        while ((b=br.readLine())!=null){
            System.out.println(b);
        }

        //回写数据
        String str="到底有多开心?";
        OutputStream os=socket.getOutputStream();
        os.write(str.getBytes());

        //5.释放资源
        socket.close();
        ss.close();
    }
}
