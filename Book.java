public class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean available;

    public Book(String bookId, String title, String author, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public void displayBookDetails() {
        System.out.println("Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Available: " + available);
    }

    public String getBookId() { return bookId; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
                              }
