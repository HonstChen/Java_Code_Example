package com.ithema.tcpdemo1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //TCP协议，发送数据

        //1.创建Socket对象
        //细节：在创建对象的同时会连接服务器
        //如果连接不上，代码会报错
        Socket socket=new Socket("127.0.0.1",9999);

        //2.可以从连接通道中国获取输出流
        OutputStream os=socket.getOutputStream();
        //写出数据
        os.write("你好".getBytes());

        //3.释放资源
        os.close();
        socket.close();
    }
}
