package Operation;

import Book.*;

public class DisplayBook implements IBook {
    //显示图书

    @Override
    public void work(BookList bookList) {
        for (int i = 0; i < bookList.getSize(); i++) {
            book Book = bookList.getBooks().get(i);
            System.out.println(Book);
        }
        System.out.println("以上是全部的图书");
    }
}
