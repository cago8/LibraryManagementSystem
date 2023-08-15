package loan;

import java.time.LocalDate;

import book.Book;
import exception.InvalidBookException;
import exception.InvalidLoanException;

public class LoanValidator {

	public void validateDueDate(LocalDate dueDate) throws InvalidLoanException {
		if (dueDate.isBefore(LocalDate.now())) {
			throw new InvalidLoanException("the dueDate should be after the current date");
		}
	}

	public void validateBookExistence(Book book) throws InvalidLoanException {
		if (!book.isAvailable()) {
			throw new InvalidLoanException("The book with ISBN" + book.getISBN() + " is not available for loan.");
		}
	}
}
