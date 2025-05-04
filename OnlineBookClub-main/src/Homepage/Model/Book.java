package Homepage.Model;

import java.awt.*;

public class Book {
    //Attributes
    Image bookImage;
    String title;
    String author;
    Boolean isRead;
    int numPages;
    double bookProgress;


    //CONSTRUCTOR
    public Book(Image bookImage, String title, String author, Boolean isRead, double bookProgress) {
        this.bookImage = bookImage;
        this.title = title;
        this.author = author;
        this.isRead = isRead;
        this.bookProgress = bookProgress;
    }

    public Book (String title, String author, Boolean isRead, double bookProgress) {
        this.title = title;
        this.author = author;
        this.isRead = isRead;
        this.bookProgress = bookProgress;
    }

    public Book(String title, String author, int numPages) {
        this.title = title;
        this.author = author;
        this.numPages = numPages;
        this.bookImage = null;
    }


    //METHODS
    public Image getBookImage() {
        return bookImage;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public Boolean getRead() {
        return isRead;
    }
    public double getBookProgress() {
        return bookProgress;
    }
    public int getNumPages() {
        return numPages;
    }

    public void setBookImage(Image bookImage) {
        this.bookImage = bookImage;
    }
    public void setTitle(String name) {
        this.title = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setRead(Boolean read) {
        isRead = read;
    }
    public void setBookProgress(double bookProgress) {
        this.bookProgress = bookProgress;
    }
    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public void displayBookInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Read: " + isRead + ", Progress: " + bookProgress + "%");
    }



}
