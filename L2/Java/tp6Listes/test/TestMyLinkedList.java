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

		MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>(42);
		System.out.println(linkedList.size());
		System.out.println(linkedList.isEmpty());
		System.out.println(linkedList.get(0));
		System.out.println(linkedList.set(420, 0));
		linkedList.clear();
		System.out.println(linkedList.equals(L));
		System.out.println(linkedList.inverse());
		System.out.println(linkedList.estPalindrome());
		System.out.println(linkedList.estCroissante());
	}
}
