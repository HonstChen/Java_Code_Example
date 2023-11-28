package Operation;

import Book.BookList;

import java.util.Scanner;

public class DelBook implements IBook {
    @Override
    public void work(BookList bookList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除的图书书名:");
        String name = sc.nextLine();
        int index = -1;
        for (int i = 0; i < bookList.getSize(); i++) {
            if (bookList.getName(i).equals(name)) {
                index = i;
                bookList.deleteBook(i);
                System.out.println("删除成功!");
                break;
            }
        }
        if (index == -1) {
            System.out.println("未找到该书");
        }
    }
}
