package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

import book.Book;
import book.BookValidator;
import exception.InvalidBookException;
import exception.InvalidLoanException;
import exception.NoSuchBookException;
import loan.Loan;
import loan.LoanValidator;

public class Library {
	private String name;
	private BookValidator bookValidator = new BookValidator();
	private LoanValidator loanValidator = new LoanValidator();
	private HashMap<String, Book> books = new HashMap<String, Book>();
	private ArrayList<Loan> loans = new ArrayList<Loan>();

	public Library(String name) {
		this.name = name;
	}

	public void addBook(Book book) {

		try {
			bookValidator.validateISBN(book);
			book.setAvailable(true);
			books.put(book.getISBN(), book);
			System.out.println("Book added:" + book.toString());
		} catch (InvalidBookException e) {
			System.out.println(e.getMessage());
		}
	}

	public void borrowBook(String borrower, String ISBN, LocalDate dueDate) {
		try {
			bookValidator.validateExistence(books, ISBN, name);
			loanValidator.validateDueDate(dueDate);
			loanValidator.validateBookExistence(books.get(ISBN));
			Loan loan = new Loan(borrower, books.get(ISBN), dueDate);
			books.get(ISBN).setAvailable(false);
			loans.add(loan);
			System.out.println("Loan created:" + loan.toString());
		} catch (NoSuchBookException e) {
			System.out.println(e.getMessage());
		} catch (InvalidLoanException e) {
			System.out.println(e.getMessage());
		}

	}

	public void returnBook(String ISBN) {
		try {
			bookValidator.validateExistence(books, ISBN, name);
			books.get(ISBN).setAvailable(true);
			for (Loan loan : loans) {
				if (loan.getBook().getISBN().equals(ISBN)) {
					loan.setReturned(true);
					System.out.println("Book returned: " + loan.getBook().getTitle() + ", ISBN: " + ISBN);
				}
			}
		} catch (NoSuchBookException e) {
			System.out.println(e.getMessage());
		}
	}

	public void printLoans() {
		System.out.println("All loans:");
		int a = 1;
		for (Loan loan : loans) {
			System.out.print("Loan " + a);
			a += 1;
			System.out.print(loan.toString() + ", Returned: " + loan.isReturned());
			System.out.println();

		}
	}

	public void printMatchingBooks(String titlePattern) {
		System.out.println();

		System.out.println("Matching books with '" + titlePattern + "':");
		for (Book book : books.values()) {
			if (book.getTitle().contains(titlePattern)) {
				System.out.println("Book:" + book.toString());
			}
		}
	}

	public void printLibraryCatalog() {
		System.out.println();
		System.out.println("Library Catalog:");
		
        for(Map.Entry<String,Book> book : books.entrySet()) {
            if(book.getValue().isAvailable()) {
                String output = String.format("Book Name: %s, ISBN: %s, Status: Available",book.getValue().getTitle(),book.getKey());
                System.out.println(output);
            }
            else {
                for(Loan loan: loans) {
                    if(loan.getBook().equals(book.getValue())) {
                        String str = String.format("Book Name: %s, ISBN: %s,"
                                + " Status: On Loan - "
                                + "Borrower: %s, Due Date: %s",book.getValue().getTitle(),book.getKey(),loan.getBorrower(),loan.getDueDate());
                        System.out.println(str);
                    }
                }
            }
        }
    }

}
