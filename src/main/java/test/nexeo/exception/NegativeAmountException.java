package test.nexeo.exception;

public class NegativeAmountException extends Exception {

	private static final long serialVersionUID = 7657622788569863045L;

	public NegativeAmountException() {
		super();
	}

	public NegativeAmountException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NegativeAmountException(String message, Throwable cause) {
		super(message, cause);
	}

	public NegativeAmountException(String message) {
		super(message);
	}

	public NegativeAmountException(Throwable cause) {
		super(cause);
	}
}
