package user;

import Operation.*;

import java.util.Scanner;

public class NormalUser extends User {
    public NormalUser(String name) {
        super(name);
        this.operation = new IBook[]{
                new FoundBook(),
                new BorrowBook(),
                new ReturnBook(),
                new ExitBook()
        };
    }

    @Override
    public int menu() {
        System.out.println("==============+++++");
        System.out.println("欢迎" + name + "使用图书管理系统");
        System.out.println("      1.查找图书     ");
        System.out.println("      2.借阅图书     ");
        System.out.println("      3.归还图书     ");
        System.out.println("      4.退出系统     ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextByte();
        return choice;
    }
}
