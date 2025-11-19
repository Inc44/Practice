package tp6Listes.list;

public class MyDoubleList<T> extends MyLinkedList<T> {
	public MyDoubleList() {
		super();
	}
	public MyDoubleList(T value) {
		head = new DoubleNode<>(value);
		tail = head;
		size = 1;
	}
	@Override
	public boolean add(T elem) {
		DoubleNode<T> newNode = new DoubleNode<T>(elem);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			DoubleNode<T> currentTail = (DoubleNode<T>) tail;
			currentTail.setNext(newNode);
			newNode.setPrevious(currentTail);
			tail = newNode;
		}
		size += 1;
		return true;
	}
	@Override
	public void add(T elem, int index) throws IndexOutOfBoundsException {
		DoubleNode<T> newNode = new DoubleNode<T>(elem);
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index not valid");
		} else if (isEmpty() || index == 0) {
			newNode.setNext(head);
			if (head != null) {
				((DoubleNode<T>) head).setPrevious(newNode);
			}
			head = newNode;
			if (size == 0) {
				tail = newNode;
			}
			size++;
		} else {
			if (index == size) {
				add(elem);
			} else {
				int i = 0;
				DoubleNode<T> previousNode = (DoubleNode<T>) head;
				while (previousNode != null && i < index - 1) {
					previousNode = (DoubleNode<T>) previousNode.getNext();
					i++;
				}
				DoubleNode<T> nextNode = (DoubleNode<T>) previousNode.getNext();
				newNode.setNext(nextNode);
				newNode.setPrevious(previousNode);
				previousNode.setNext(newNode);
				if (nextNode != null) {
					nextNode.setPrevious(newNode);
				}
				size++;
			}
		}
	}
	@Override
	public T remove(int index) throws IndexOutOfBoundsException, UnsupportedOperationException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		if (isEmpty()) {
			throw new UnsupportedOperationException("List is empty, no value to remove");
		}
		if (index == 0) {
			T newNode = head.getValue();
			head = head.getNext();
			if (head != null) {
				((DoubleNode<T>) head).setPrevious(null);
			} else {
				tail = null;
			}
			size--;
			return newNode;
		} else {
			int i = 0;
			DoubleNode<T> previousNode = (DoubleNode<T>) head;
			while (i < index - 1 && previousNode != null) {
				previousNode = (DoubleNode<T>) previousNode.getNext();
				i++;
			}
			DoubleNode<T> nodeToRemove = (DoubleNode<T>) previousNode.getNext();
			T newNode = nodeToRemove.getValue();
			DoubleNode<T> nextNode = (DoubleNode<T>) nodeToRemove.getNext();
			previousNode.setNext(nextNode);
			if (nextNode != null) {
				nextNode.setPrevious(previousNode);
			}
			if (index == size - 1) {
				tail = previousNode;
			}
			size--;
			return newNode;
		}
	}
	@Override
	public MyLinkedList<T> inverse() {
		MyDoubleList<T> reversedDoubleList = new MyDoubleList<>();
		Node<T> currentNode = head;
		while (currentNode != null) {
			reversedDoubleList.add(currentNode.getValue(), 0);
			currentNode = currentNode.getNext();
		}
		return reversedDoubleList;
	}
}