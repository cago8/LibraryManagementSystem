package book;

public class Book {
	private String ISBN;
	private String title;
	private String author;
	private boolean isAvailable;

	public Book(String ISBN, String title, String author, boolean isAvailable) {
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
		this.isAvailable = isAvailable;
	}

	public String getTitle() {
		return title;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getISBN() {
		return ISBN;
	}
	
	public String toString() {
        return  " "+ title + ", ISBN: " + ISBN +
                ", Author: " + author;
    }

}
