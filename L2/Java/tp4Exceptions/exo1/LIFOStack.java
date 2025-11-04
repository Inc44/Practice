package tp4Exceptions.exo1;

import java.util.ArrayList;

public class LIFOStack implements Stack {
	private ArrayList<Value> stack;
	public LIFOStack() {
		this.stack = new ArrayList<>();
	}
	public boolean empty() {
		return stack.size() == 0;
	}
	public void push(Value v) {
		stack.add(v);
	}
	public Value pop() throws EmptyStackException {
		if (empty()) {
			throw new EmptyStackException("Impossible to pop an empty stack  ");
		}
		return stack.remove(stack.size() - 1);
	}
	public Value peek() throws EmptyStackException {
		if (empty()) {
			throw new EmptyStackException("Impossible to peek an empty stack");
		}
		return stack.get(stack.size() - 1);
	}
}