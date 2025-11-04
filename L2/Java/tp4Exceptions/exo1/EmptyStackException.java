package tp4Exceptions.exo1;

public class EmptyStackException extends Exception {
	public EmptyStackException() {
		super("Stack is empty");
	}
	public EmptyStackException(String message) {
		super(message);
	}
}