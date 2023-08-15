package exception;

public class InvalidBookException extends Exception {

	public InvalidBookException(String message) {
		super("InvalidBookException: Book is invalid because " + message);
	}
}
	


