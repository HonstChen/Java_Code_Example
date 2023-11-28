package com.ithema.demo;

import com.ithema.ui.MyActionListener;

import javax.swing.*;
import javax.swing.plaf.synth.SynthIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Test implements Cloneable {
    public static void main(String[] args) throws IOException {
        /*JFrame jFrame = new JFrame();
        jFrame.setSize(1000, 2000);
        jFrame.setVisible(true);
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("欢迎");
        JMenuItem jMenuItem = new JMenuItem("光临");
        jMenu.add(jMenuItem);
        jMenuBar.add(jMenu);
        jFrame.setJMenuBar(jMenuBar);
        *//*JButton jtb = new JButton("点我啊");
        jtb.setBounds(0, 0, 100, 50);*//*
         *//*jtb.addActionListener(new MyActionListener());
        jFrame.getContentPane().add(jtb);*//*
        JButton jtb2 = new JButton("再点我啊");
        jtb2.setBounds(100, 50, 100, 100);
        jtb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random r = new Random();
                jtb2.setBounds(r.nextInt(500), r.nextInt(500), 100, 100);
            }
        });
        jFrame.getContentPane().add(jtb2);*/

        //获取CPU的线程数
        /*System.out.println(Runtime.getRuntime().availableProcessors());
        //总内存大小
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);
*/
        //已经获取的总内存大小
        /*System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
        Runtime.getRuntime().exec("notepad");*/

        /*BigInteger bd1 = new BigInteger(4, new Random());
        System.out.println(bd1);//0到*/

        /*BigInteger bd2 = new BigInteger("011111010110", 2);
        System.out.println(bd2);*/
        BigInteger bd2 = BigInteger.valueOf(16);
        BigInteger bd3 = BigInteger.valueOf(16);
        System.out.println(bd2 == bd3);

        BigInteger bd4 = BigInteger.valueOf(17);
        BigInteger bd5 = BigInteger.valueOf(17);
        System.out.println(bd4 == bd5);

        BigDecimal bd1 = new BigDecimal("0.09");
        BigDecimal bd = new BigDecimal(0.09);
        System.out.println(bd);
        System.out.println(bd1);

    }
}
