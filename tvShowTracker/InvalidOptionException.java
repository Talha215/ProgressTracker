package tvShowTracker;

public class InvalidOptionException extends Exception {
	private static final long serialVersionUID = 1012899272024441916L;

	InvalidOptionException() {
		super("Invalid choice, try again.");
	}
}
