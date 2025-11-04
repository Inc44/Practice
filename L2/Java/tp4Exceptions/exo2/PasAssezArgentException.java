package tp4Exceptions.exo2;

public class PasAssezArgentException extends Exception {
	public PasAssezArgentException() {
		super("You are broke");
	}
	public PasAssezArgentException(String message) {
		super(message);
	}
}