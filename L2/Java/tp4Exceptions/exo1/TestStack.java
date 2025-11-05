package tp4Exceptions.exo1;

public class TestStack {
	public static void main(String[] args) {
		LIFOStack stack = new LIFOStack();
		try {
			stack.pop();
		} catch (EmptyStackException exception) {
			System.err.println("Exception : " + exception.getMessage());
		}
		Value v = new Value("Test", 42);
		stack.push(v);
		try {
			Value popped = stack.pop();
			System.out.println("Popped value : " + popped);
		} catch (EmptyStackException exception) {
			System.err.println("Exception: " + exception.getMessage());
		}
		System.out.println("Empty stack : " + stack.empty());
	}
}