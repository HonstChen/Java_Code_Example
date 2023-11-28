package Operation;

import Book.book;
import Book.BookList;

import java.util.Scanner;

public class ReturnBook implements IBook {
    @Override
    public void work(BookList bookList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你需要归还的书名:");
        String name = sc.nextLine();
        for (int i = 0; i < bookList.getSize(); i++) {
            book Book = bookList.getBooks().get(i);
            if (Book.getName().equals(name)) {
                if (Book.isStatues() == true) {
                    Book.setStatues(false);
                    System.out.println("归还成功");
                    return;
                } else {
                    System.out.println("该图书未借出，重新输入!");
                    return;
                }
            }
        }
        System.out.println("没有这本书，无法归还");
    }
}
