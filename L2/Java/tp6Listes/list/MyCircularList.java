package tp6Listes.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCircularList<T> extends MyLinkedList<T> {
	public MyCircularList() {
		super();
	}
	public MyCircularList(T value) {
		super(value);
		head.setNext(head);
	}
	@Override
	public boolean add(T elem) {
		boolean added = super.add(elem);
		if (tail != null) {
			tail.setNext(head);
		}
		return added;
	}
	@Override
	public void add(T elem, int index) {
		super.add(elem, index);
		if (tail != null) {
			tail.setNext(head);
		}
	}
	@Override
	public T remove(int index) {
		T removedNodeValue = super.remove(index);
		if (isEmpty()) {
			head = null;
			tail = null;
		} else {
			tail.setNext(head);
		}
		return removedNodeValue;
	}
	@Override
	public Iterator<T> iterator() {
		return new MyCircularListIterator();
	}
	private class MyCircularListIterator implements Iterator<T> {
		private Node<T> current;
		private int i;
		public MyCircularListIterator() {
			current = head;
			i = 0;
		}
		@Override
		public boolean hasNext() {
			return i < size;
		}
		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T value = current.getValue();
			current = current.getNext();
			i++;
			return value;
		}
	}
	@Override
	public MyLinkedList<T> inverse() {
		MyCircularList<T> reversedCircularList = new MyCircularList<>();
		Node<T> currentNode = head;
		for (int i = 0; i < size; i++) {
			reversedCircularList.add(currentNode.getValue(), 0);
			currentNode = currentNode.getNext();
		}
		return reversedCircularList;
	}
}