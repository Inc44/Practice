package tp6Listes.list;

import java.util.Iterator;
import java.lang.IndexOutOfBoundsException;
import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements IList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;

	/**
	 * Build an empty linked list
	 */
	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Build a linked list from a value
	 */
	public MyLinkedList(T value) {
		head = new Node<T>(value);
		tail = head;
		size = 1;
	}

	/**
	 * Appends the specified element to the end of this list
	 */
	@Override
	public boolean add(T elem) {
		Node<T> tmp = new Node<T>(elem);
		if (head == null) {
			head = tmp;
			tail = tmp;
		} else {
			tail.setNext(tmp);
			tail = tmp;
		}
		size += 1;
		return true; // (as specified by Collection.add(E))
	}

	/**
	 * Inserts the specified element at the specified position in this list
	 */
	@Override
	public void add(T elem, int index) throws IndexOutOfBoundsException {
		Node<T> tmp = new Node<T>(elem);

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index not valid");
		} else if (isEmpty() || index == 0) {
			tmp.setNext(head);
			head = tmp;
			if (size == 0) {
				tail = tmp;
			}
			size++;
		} else {
			if (index == size) {
				add(elem);
			} else {
				int i = 0;

				Node<T> p = head;

				while (p != null && i < index - 1) {
					// p != null should be unused
					p = p.getNext();
					i++;
				}
				tmp.setNext(p.getNext());
				p.setNext(tmp);
				size++;
			}
		}
	}

	/**
	 * Removes all of the elements from this list. The list is empty after this call returns
	 */
	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Returns true if this list contains the specified element
	 */
	@Override
	public boolean contains(T elem) {
		Node<T> p = head;
		while (p != null && !p.getValue().equals(elem)) {
			p = p.getNext();
		}
		return p != null;
	}

	/**
	 * Returns the element at the specified position in this list.
	 */
	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		int ind = 0;
		Node<T> p = head;
		while (p != null) {
			if (ind == index)
				return p.getValue();
			else {
				p = p.getNext();
				ind++;
			}
		}
		return null;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true; // Check if both references point to the same object
		if (other == null || getClass() != other.getClass())
			return false; // Check if 'other' is null or of different class

		MyLinkedList<T> tmp = (MyLinkedList<T>) other;
		if (tmp.size() != size())
			return false; // Check if sizes are different

		// Iterate over both lists to compare each element
		Node<T> current1 = this.head;
		Node<T> current2 = tmp.head;

		while (current1 != null && current2 != null) {
			if (!current1.getValue().equals(current2.getValue())) {
				return false; // If any element differs, return false
			}
			current1 = current1.getNext();
			current2 = current2.getNext();
		}

		return true; // All elements are equal
	}

	/**
	 * Returns the index of the first occurrence
	 * of the specified element in this list,
	 * or -1 if this list does not contain the element.
	 */
	@Override
	public int indexOf(T elem) {
		int index = 0;
		Node<T> p = head;
		while (p != null) {
			if (p.getValue().equals(elem))
				return index;
			else {
				p = p.getNext();
				index++;
			}
		}
		return -1;
	}

	/**
	 * Returns true if this list contains no elements.
	 */
	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyLinkedListIterator();
	}

	/**
	 * Removes the element at the specified position in this list
	 */
	@Override
	public T remove(int index) throws IndexOutOfBoundsException, UnsupportedOperationException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index");
		}

		if (isEmpty()) {
			throw new UnsupportedOperationException("List is empty, no value to remove");
		}

		// list is not empty
		if (index == 0) {
			T tmp = head.getValue();
			head = head.getNext();
			size--;
			if (size == 0) {
				tail = null;
			}
			return tmp;
		} else {
			int i = 0;
			Node<T> p = head;
			while (i < index - 1 && p != null) {
				p = p.getNext();
				i++;
			}
			// (p.getNext() != null) is always true
			// because of Exception at the beginning
			T tmp = p.getNext().getValue();
			p.setNext(p.getNext().getNext());
			if (index == size - 1) {
				tail = p;
			}
			size--;
			return tmp;
			//}
		}
	}

	/**
	 * Replaces the element at the specified position in this list with the specified element
	 */
	@Override
	public T set(T elem, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		Node<T> p = head;
		int i = 0;
		while (p != null && i < index) {
			p = p.getNext();
			i++;
		}
		T tmp = p.getValue();
		p.setValue(elem);
		return tmp;
	}

	/**
	 * Returns the number of elements in this list.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns a string describing the linked List content
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer("(");
		Node<T> p = head;
		while (p != null) {
			sb.append(p.getValue().toString());
			if (p.getNext() != null)
				sb.append(", ");
			p = p.getNext();
		}
		sb.append(")");
		return sb.toString();
	}

	public MyLinkedList<T> inverse() {
		MyLinkedList<T> reversedLinkedList = new MyLinkedList<T>();
		Node<T> currentNode = head;
		while (currentNode != null) {
			reversedLinkedList.add(currentNode.getValue(), 0);
			currentNode = currentNode.getNext();
		}
		return reversedLinkedList;
	}
	public boolean estPalindrome() {
		MyLinkedList<T> reversedLinkedList = inverse();
		return this.equals(reversedLinkedList);
	}
	@SuppressWarnings("unchecked")
	public boolean estCroissante() {
		if (head == null || head.getNext() == null) {
			return true;
		}
		Node<T> currentNode = head;
		while (currentNode.getNext() != null) {
			Comparable<T> comparableCurrentNodeValue = (Comparable<T>) currentNode.getValue();
			if (comparableCurrentNodeValue.compareTo(currentNode.getNext().getValue()) > 0) {
				return false;
			}
			currentNode = currentNode.getNext();
		}
		return true;
	}

	/**
	 * Internal class to define the ad-hoc iterator
	 */
	private class MyLinkedListIterator implements Iterator<T> {
		private Node<T> current;

		public MyLinkedListIterator() {
			current = head;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T value = current.getValue();
			current = current.getNext();
			return value;
		}
	}
}
