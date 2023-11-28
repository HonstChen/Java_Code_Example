package com.ithema.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    //LoginJFrame表示登录界面
    //以后所有与登录相关的代码，都写在这里

    public LoginJFrame() {
        //在创建登录界面的时候，同时给这个界面设置一些信息
        //比如，宽高，直接展示出来
        this.setSize(488, 430);
        this.setTitle("拼图  登录");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
