package Operation;

import Book.book;
import Book.BookList;

import java.util.Scanner;

public class FoundBook implements IBook {
    @Override
    public void work(BookList bookList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你需要查找的书名:");
        String name = sc.nextLine();
        for (int i = 0; i < bookList.getSize(); i++) {
            book Book = bookList.getBooks().get(i);
            if (Book.getName().equals(name)) {
                System.out.println("查找成功，有这本书!");
                System.out.println(Book);
                return;
            }
        }
        System.out.println("没有这本书");
    }
}
