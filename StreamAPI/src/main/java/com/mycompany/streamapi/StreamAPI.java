/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.streamapi;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author serdar
 */
public class StreamAPI {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Book> newBooks = new ArrayList<>();

        Book book1 = new Book("Kitap1", 100, "Yazar1", "2019");
        Book book2 = new Book("Kitap2", 75, "Yazar2", "2009");
        Book book3 = new Book("Kitap3", 365, "Yazar3", "2007");
        Book book4 = new Book("Kitap4", 170, "Yazar4", "2018");
        Book book5 = new Book("Kitap5", 95, "Yazar5", "2023");
        Book book6 = new Book("Kitap6", 210, "Yazar6", "2001");
        Book book7 = new Book("Kitap7", 250, "Yazar7", "2000");
        Book book8 = new Book("Kitap8", 130, "Yazar8", "2011");
        Book book9 = new Book("Kitap9", 45, "Yazar9", "2008");
        Book book10 = new Book("Kitap10", 450, "Yazar10", "2013");

        Book[] bookList = new Book[]{book1, book2, book3, book4, book5, book6, book7, book8, book9, book10};

        for (int i = 0; i < bookList.length; i++) {
            books.add(bookList[i]);
        }

        books.stream().map(book -> book.getBookName() + ": " + book.getAuthorName()).forEach(i -> System.out.println(i));

        newBooks = books.stream().filter(book -> book.getBookPageNumber() > 100).collect(Collectors.toCollection(ArrayList::new));
        for(Book book : newBooks){
            System.out.println("Kitap Adı: " + book.getBookName() + " - " + "Sayfa Sayısı: "  + book.getBookPageNumber());
        }

    }
}
