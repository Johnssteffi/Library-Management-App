 import javafx.scene.image.ImageView;
 public class Book {
    private String title;
    private String author;
    private String imagePath;
    public Book(String title, String author, String imagePath) {
        this.title = title;
        this.author = author;
        this.imagePath = imagePath;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getImagePath() {
        return imagePath;
    }
    @Override
    public String toString() {
        return title + " by " + author;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return title.equals(book.title) && author.equals(book.author);
    }
 }