package com.ithema.InetAddressdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {
        //接收数据

        //1.创建DatagramSocket对象（快递公司）
        //细节：
        //在接收的时候，一定要绑定端口
        //绑定的端口一定要与发送的端口保持一致
        DatagramSocket ds=new DatagramSocket(10087);
        //2.接收数据包
        byte[] bytes=new byte[1024];
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length);
        //该方法是阻塞的，会一致在等receive的方法
        //
        ds.receive(dp);

        //3.解析数据包
        byte[] data=dp.getData();
        int len=dp.getLength();
        InetAddress address = dp.getAddress();
        int port = dp.getPort();

        System.out.println("接受到数据"+new String(data,0,len));
        System.out.println("该数据是从"+address+"这台电脑中发送的");

        //4.释放资源
        ds.close();
    }
}
