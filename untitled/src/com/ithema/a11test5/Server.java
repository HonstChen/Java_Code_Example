package com.ithema.a11test5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    public static void main(String[] args) throws IOException {
        //客户端：将本地文件上传到服务器，接收服务器的反馈
        //服务器：接收客户端上传的文件，上传完毕之后给出反馈

        //创建线程池的对象
        //利用线程池可以提高程序的运行效率
        //频繁地销毁线程和创建线程时一件很浪费资源的事情
        ThreadPoolExecutor pool=new ThreadPoolExecutor(
                3,
                16,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        //1.创建ServerSock对象
        ServerSocket ss = new ServerSocket(9999);
        Socket socket = null;

        //单线程的弊端
        while (true) {
            //2.创建Socket对象
            socket = ss.accept();

            //开启一条线程
            //一个用户对应服务端的一条线程
            /*new Thread(new MyRUnnable(socket)).start();*/
            pool.submit(new MyRUnnable(socket));
        }
    }
}
