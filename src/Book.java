
public class Book {

	private int bookID;
	private String bookTitle;
	private String author;
	private String status;
	private String borrower;
	private long dueDate;
	private int counter;


	public Book(String bookTitle, String author, String status, int counter) {
		super();
		this.author = author;
		this.bookTitle = bookTitle;
		this.status = status;
		this.dueDate = dueDate;
		this.counter = counter;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long getDueDate() {
		return dueDate;
	}

	public void setDueDate(long dueDate) {
		this.dueDate = dueDate;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {

		return String.format("%1$-4d %2$-50s %3$-20s %4$-10s",counter, bookTitle, author, status);
	}

}
