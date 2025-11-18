package tp6Listes.list;

import java.util.Iterator;

public interface IList<T> extends Iterable<T> {
	boolean add(T elem);
	void add(T elem, int index);
	void clear();
	boolean contains(T elem);
	boolean equals(Object other);
	T get(int index);
	int indexOf(T elem);
	boolean isEmpty();
	Iterator<T> iterator();
	T remove(int index);
	T set(T elem, int index);
	int size();
}
