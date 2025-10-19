public class Transaction {
    private String transactionId;
    private String userId;
    private String bookId;
    private String dateBorrowed;
    private String dateReturned;

    public Transaction(String transactionId, String userId, String bookId, String dateBorrowed, String dateReturned) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.bookId = bookId;
        this.dateBorrowed = dateBorrowed;
        this.dateReturned = dateReturned;
    }

    public void displayTransaction() {
        System.out.println("Transaction ID: " + transactionId +
                           ", User ID: " + userId +
                           ", Book ID: " + bookId +
                           ", Borrowed: " + dateBorrowed +
                           ", Returned: " + dateReturned);
    }
}
