package com.ithema.a10test4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {
    public static void main(String[] args) throws IOException {
        //客户端：将本地文件上传到服务器，接收服务器的反馈
        //服务器：接收客户端上传的文件，上传完毕之后给出反馈

        //1.创建ServerSock对象
        ServerSocket ss=new ServerSocket(9999);

        //2.创建Socket对象
        Socket socket=ss.accept();

        //创建字节输入输出流等
        BufferedInputStream bis=new BufferedInputStream(socket.getInputStream());
        String name= UUID.randomUUID().toString().replace("-","");
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("D:\\Java_Code\\untitled\\myfile\\ccc\\"+name+".mp4"));
        int len;
        byte[] bytes=new byte[1024];
        while ((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bos.close();

        //4.回写数据
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("上传成功");
        bw.newLine();
        bw.flush();

        //5.释放资源
        socket.close();
        ss.close();
    }
}