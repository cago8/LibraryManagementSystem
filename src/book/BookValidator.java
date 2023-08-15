package book;

import java.util.Map;

import exception.InvalidBookException;
import exception.NoSuchBookException;

public class BookValidator {

	public void validateISBN(Book book) throws InvalidBookException {
		if (book.getISBN().length() != 13) {
			throw new InvalidBookException("the length of the ISBN should be 13");
		}
		if (!book.getISBN().matches("\\d+")) {
			throw new InvalidBookException("the ISBN should contain only numeric characters");
		}
	}

	public void validateExistence(Map<String, Book> books, String ISBN, String libraryName) throws NoSuchBookException {
		if (!books.containsKey(ISBN)) {
			throw new NoSuchBookException(
					"Book with ISBN " + ISBN + " does not exist in the " + libraryName + " library.");
		}

	}

}
