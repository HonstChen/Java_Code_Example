package Book;

import java.util.Scanner;

public class book {
    private String name;
    private String author;
    private double price;
    private String type;
    private boolean statues;

    public book(String name, String author, double price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
    }

    public book() {

    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatues(boolean statues) {
        this.statues = statues;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public boolean isStatues() {
        return statues;
    }

    @Override
    public String toString() {
        return "book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", statues=" + statues + ((statues == true) ? "借出" : "未借出") +
                '}';
    }
}
