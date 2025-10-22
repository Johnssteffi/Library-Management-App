import java.util.ArrayList;
 public class BookData {
    private static ArrayList<Book> bookList = new ArrayList<>();
    public static void addBook(Book book) {
        bookList.add(book);
    }
    public static ArrayList<Book> getBookList() {
        return bookList;
    }
    public static void removeBook(Book book) {
        bookList.remove(book);
    }
 }