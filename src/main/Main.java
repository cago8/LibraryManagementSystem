/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.

I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.

READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Çağrı Bilginer, 79929>

********************************************************************************/
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

import book.Book;
import exception.InvalidBookException;

// Import necessary classes

public class Main {
	public static void main(String[] args) throws InvalidBookException {
		// Create a library
		Library library = new Library("MyLibrary");
		// ToDo: Add books to the library via reading from text file with Scanner
		// !! Do not forget to handle exceptions
		try {
			File file = new File("//Users//cago//git//spring2023-lab07-cago8//src//main//Input.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (!line.isEmpty()) {
					String[] parts = line.split(" ");
					Book book = new Book(parts[0], parts[1] + " " + parts[2], parts[3] + " " + parts[4], true);
					library.addBook(book);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();

		// ToDo: Create loans via calling borrowBook method of library
		// !! Do not forget to handle exceptions
		library.borrowBook("Fatma", "1234567890123", LocalDate.parse("2023-06-05"));
		library.borrowBook("Vahideh", "2345678901234", LocalDate.parse("2023-06-10"));
		library.borrowBook("Ali", "123456789012X", LocalDate.parse("2023-06-11"));
		library.borrowBook("Veli", "1111111111111", LocalDate.parse("2023-06-12"));
		library.borrowBook("Vehdet", "2345678901234", LocalDate.parse("2022-05-10"));
		library.borrowBook("Ceren", "1234567890123", LocalDate.parse("2023-10-10"));
		System.out.println();
		// ToDo: Get returns via calling returnBook method of library
		// !! Do not forget to handle exceptions
		library.returnBook("1234567890123");
		library.returnBook("1111111111111");
		System.out.println();


		// ToDo: Print all loans
		library.printLoans();
		// ToDo: Print all books that includes "Programming" in its name
		library.printMatchingBooks("Programming");
		library.printLibraryCatalog();

	}
}
