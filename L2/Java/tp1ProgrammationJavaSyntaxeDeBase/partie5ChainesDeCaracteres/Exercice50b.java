package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice50b {
	public static void saisie(String[] tab) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < tab.length; i++) {
			System.out.print("Entrez l'element " + i + " : ");
			tab[i] = sc.nextLine();
		}
		sc.close();
	}
	public static void trie(String[] tab) {
		int size = tab.length;
		for (int i = 0; i < size - 1; i++) {
			int k = i;
			for (int j = i + 1; j < size; j++) {
				if (tab[j].compareToIgnoreCase(tab[k]) < 0)
					k = j;
			}
			if (k != i) {
				String temp = tab[i];
				tab[i] = tab[k];
				tab[k] = temp;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Taille du tableau : ");
		int size = sc.nextInt();
		sc.nextLine(); // Consume leftover newline
		String[] list = new String[size];
		saisie(list);
		System.out.println("Tableau original : ");
		for (String val : list) {
			System.out.println(val);
		}
		trie(list);
		System.out.println("Tableau trie : ");
		for (String val : list) {
			System.out.println(val);
		}
		sc.close();
	}
}
