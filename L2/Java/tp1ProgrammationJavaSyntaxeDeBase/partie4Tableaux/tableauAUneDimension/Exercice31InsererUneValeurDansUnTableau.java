package tp1ProgrammationJavaSyntaxeDeBase.partie4Tableaux.tableauAUneDimension;

import java.util.Scanner;
import java.util.Random;

public class Exercice31InsererUneValeurDansUnTableau {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		System.out.print("Taille du tableau: ");
		int size = sc.nextInt();
		int[] list = new int[size + 1];
		list[0] = rand.nextInt(100);
		for (int i = 1; i < size; i++) {
			while (true) {
				int val = rand.nextInt(100);
				if (val >= list[i - 1]) {
					list[i] = val;
					break;
				}
			}
		}
		// int size = 6;
		// int[] list = {2,7,14,14,28,35,0};
		System.out.print("Tableau trie : ");
		for (int i = 0; i < size; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		System.out.print("Valeur a inserer : ");
		int number = sc.nextInt();
		int pos = 0;
		for (int i = 0; i < size; i++) {
			if (list[i] > number) {
				pos = i;
				break;
			}
		}
		for (int i = size; i > pos; i--) {
			list[i] = list[i - 1];
		}
		list[pos] = number;
		size++;
		System.out.print("Tableau apres insertion : ");
		for (int val : list) {
			System.out.print(val + " ");
		}
		System.out.println();
		sc.close();
	}
}
