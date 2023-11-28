package Operation;

import Book.book;
import Book.BookList;

import java.util.Scanner;

public class Addbook implements IBook {
    @Override
    public void work(BookList bookList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入图书的名字:");
        String name = sc.nextLine();
        System.out.println("请输入图书作者:");
        String author = sc.nextLine();
        System.out.println("请输入图书的价格:");
        double price = sc.nextDouble();
        System.out.println("请输入图书的类别:");
        String type = sc.nextLine();
        book Book = new book(name, author, price, type);
        bookList.addBook(Book);
        System.out.println("添加成功!");
    }
}
