package tp6Listes.list;

public class Node<T> {
	private T value; // Value attached to the Node
	private Node<T> next; // Next node (default = null when no other node)

	/**
	 * Default constructor with a single value and no follow up node
	 * @param val : value, type T
	 */
	public Node(T val) {
		this.value = val;
		this.next = null;
	}

	/**
	 * Complete constructor to build a node with a value and
	 * followed by another (possibly null) node
	 * @param val: value, type T
	 * @param nxt: follow up node, type Node<T>
	 */
	public Node(T val, Node<T> nxt) {
		this.value = val;
		this.next = nxt;
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
