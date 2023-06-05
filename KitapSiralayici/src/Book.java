public class Book implements Comparable<Book>{
    private int bookPage;
    private String bookName;

    public Book(int bookPage, String bookName) {
        this.bookPage = bookPage;
        this.bookName = bookName;
    }

    public int getBookPage() {
        return bookPage;
    }

    public void setBookPage(int bookPage) {
        this.bookPage = bookPage;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public int compareTo(Book o) {
        return this.bookPage - o.bookPage;
    }
}
