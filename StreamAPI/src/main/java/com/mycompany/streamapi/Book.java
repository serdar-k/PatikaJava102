/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.streamapi;

/**
 *
 * @author serdar
 */
public class Book {
    private String bookName;
    private int bookPageNumber;
    private String authorName;
    private String bookDate;

    public Book(String bookName, int bookPageNumber, String authorName, String bookDate) {
        this.bookName = bookName;
        this.bookPageNumber = bookPageNumber;
        this.authorName = authorName;
        this.bookDate = bookDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPageNumber() {
        return bookPageNumber;
    }

    public void setBookPageNumber(int bookPageNumber) {
        this.bookPageNumber = bookPageNumber;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }
    
    
}
