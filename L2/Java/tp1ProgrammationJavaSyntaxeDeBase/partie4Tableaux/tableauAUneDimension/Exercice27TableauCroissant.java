package tp1ProgrammationJavaSyntaxeDeBase.partie4Tableaux.tableauAUneDimension;

import java.util.Scanner;
import java.util.Random;

public class Exercice27TableauCroissant {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		System.out.print("Taille du tableau : ");
		int size = sc.nextInt();
		int[] list = new int[size];
		for (int i = 0; i < size; i++) {
			list[i] = rand.nextInt(100);
		}
		System.out.print("Tableau : ");
		for (int val : list) {
			System.out.print(val + " ");
		}
		System.out.println();
		boolean croissant = true;
		for (int i = 1; i < size; i++) {
			if (list[i] < list[i - 1]) {
				croissant = false;
				break;
			}
		}
		System.out.println("Est croissant : " + croissant);
		sc.close();
	}
}
