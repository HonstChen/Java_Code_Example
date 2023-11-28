package Tool;

import java.util.Scanner;

public class Menu {
    static void Printf() {
        /*
        首先进行创建和登录验证
         */
        System.out.println("0.退出系统");
        System.out.println("1.登录账户");
        System.out.println("2.创建账户");
        System.out.println("3.修改密码");
    }

    static void Menu() {
        System.out.println("欢迎进入图书管理系统！");
        System.out.println("请选择功能");
        Printf();
        Scanner sc = new Scanner(System.in);
        switch (sc.nextByte()) {
            case 0:
                System.out.println("退出成功");
                System.exit(0);
        }
    }

    static boolean Log_in(String Username, String Password) {
        //使用用户名和密码进行登录，获得管理员用户权限
        return false;
    }

    public static void main(String[] args) {
        Menu();

        return;
    }
}
