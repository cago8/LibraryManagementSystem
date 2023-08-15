package loan;

import java.time.LocalDate;

import book.Book;

public class Loan {
	private String borrower;
	private Book book;
	private LocalDate dueDate;
	private boolean isReturned;

	public Loan(String borrower, Book book, LocalDate dueDate) {
		this.borrower = borrower;
		this.book = book;
		this.dueDate = dueDate;
	}

	public String getBorrower() {
		return borrower;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public boolean isReturned() {
		return isReturned;
	}

	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
	
	public Book getBook() {
		return book;
	}

	public String toString() {
        return  ": Borrower: " + borrower + ", Book: " + book.getTitle() +
                ", Due date: " + dueDate;
    }

}
