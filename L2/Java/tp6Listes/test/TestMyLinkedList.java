package tp6Listes.test;

import java.util.Iterator;
import java.util.Random;

import tp6Listes.list.MyLinkedList;

public class TestMyLinkedList {
	private static void generate(MyLinkedList<Integer> L, Random rd, int nbElem, int range) {
		for (int i = 0; i < nbElem; i++) {
			L.add(rd.nextInt(range));
		}
	}

	public static void main(String[] args) {
		Random r = new Random();
		r.setSeed(42);

		MyLinkedList<Integer> L = new MyLinkedList<Integer>();
		generate(L, r, 10, 100);
		System.out.println(L);

		L.add(42, 3);
		System.out.println(L);

		System.out.println(L.contains(30));
		System.out.println(L.indexOf(30));

		System.out.println("----------");
		Integer tmp = L.remove(6);
		System.out.println(tmp);
		System.out.println(L);

		// Test iterator

		Iterator<Integer> it = L.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}
}
