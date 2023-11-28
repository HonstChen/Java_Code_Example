package Operation;

import Book.book;
import Book.BookList;

import java.util.Scanner;

public class BorrowBook implements IBook {
    @Override
    public void work(BookList bookList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入需要查找的图书的书名:");
        String name = sc.nextLine();
        for (int i = 0; i < bookList.getSize(); i++) {
            book Book = bookList.getBooks().get(i);
            if (Book.getName().equals(name)) {
                if (Book.isStatues()==true){
                    System.out.println("该书已经借出，无法借阅!");
                    return;
                }else {
                    Book.setStatues(true);
                    return;
                }
            }
        }
        System.out.println("没有这本书，无法借阅!");
    }
}
