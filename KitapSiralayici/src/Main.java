import com.sun.source.tree.Tree;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Book book1 = new Book(125, "Java-1");
        Book book2 = new Book(250, "Java-2");
        Book book3 = new Book(100, "Java-3");
        Book book4 = new Book(300, "Java-4");
        Book book5 = new Book(275, "Java-5");

        TreeSet<Book> books = new TreeSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        for (Book book : books){
            System.out.println(book.getBookName() + " " + book.getBookPage());
        }

    }
}