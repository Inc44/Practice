package tp6Listes.list;

public class Node<T> {
	private T value; // Value attached to the Node
	private Node<T> next; // Next node (default = null when no other node)

	/**
	 * Default constructor with a single value and no follow up node
	 * @param value : value, type T
	 */
	public Node(T value) {
		this.value = value;
		this.next = null;
	}

	/**
	 * Complete constructor to build a node with a value and
	 * followed by another (possibly null) node
	 * @param value: value, type T
	 * @param next: follow up node, type Node<T>
	 */
	public Node(T value, Node<T> next) {
		this.value = value;
		this.next = next;
	}

	// Getters and setters
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
}
