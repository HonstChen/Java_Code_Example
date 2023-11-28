package Book;

import java.util.ArrayList;

public class BookList {
    private int size;
    private ArrayList<book> books;

    public BookList() {
        this.books = new ArrayList<>();
        //初始化列表
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public ArrayList<book> getBooks() {
        return this.books;
    }

    public void addBook(book Book) {
        this.books.add(Book);
        this.size = this.getSize();
    }

    public String getName(int index) {
        return books.get(index).getName();
    }

    public void deleteBook(int index) {
        this.books.remove(index);
    }
}
