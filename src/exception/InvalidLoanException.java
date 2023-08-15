package exception;

public class InvalidLoanException extends Exception {
	
	public InvalidLoanException(String message) {
		super("InvalidLoanException: Loan is invalid because " + message);
	}

}
