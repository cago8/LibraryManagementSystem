package exception;

public class NoSuchBookException extends Exception {

	public NoSuchBookException(String message) {
		super("NoSuchBookException: Loan aborted because " + message);
	}
}
