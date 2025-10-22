 import javafx.application.Application;
 import javafx.scene.Scene;
 import javafx.scene.control.Label;
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
 import javafx.scene.layout.GridPane;
 import javafx.scene.layout.VBox;
 import javafx.stage.Stage;
 import java.io.BufferedReader;
 import java.io.FileReader;
 import java.io.IOException;
 public class ReaderApp extends Application {
    private GridPane gridPane; // GridPane for book display
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Reader App");
         gridPane = new GridPane();
        // Load books from file
        loadBooksFromFile();
 VBox vbox = new VBox(10, gridPane);
        Scene scene = new Scene(vbox, 500, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void loadBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            int row = 0;
            int col = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Book book = new Book(parts[0], parts[1], parts[2]);
                    ImageView imageView = new ImageView(new Image(book.getImagePath()));
                    imageView.setFitWidth(100);
                    imageView.setFitHeight(150);
 VBox bookInfo = new VBox(new Label(book.getTitle()), new Label("by 
"+book.getAuthor()));
                    bookInfo.setStyle("-fx-alignment: center;");
 VBox bookContainer = new VBox(10, imageView, bookInfo);
                    bookContainer.setStyle("-fx-padding: 10; -fx-background-color: #f0f0f0; -fx-border
radius: 5; -fx-background-radius: 5;");
 gridPane.add(bookContainer, col, row);
                    col++;
                    if (col > 2) { // Adjust to the number of columns you want
                        col = 0;
                        row++;
                    }
 }
    }
 } 
    catch (IOException e) {
            e.printStackTrace();
          }
  }
 }