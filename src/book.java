
public class Book {

private String bookTitle;
private String author;
public String status;
private long dueDate;



public Book(String bookTitle,String author) {
		super();
		this.author = author;
		this.bookTitle = bookTitle;
		this.status= status;
		this.dueDate= dueDate;
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
	
}
