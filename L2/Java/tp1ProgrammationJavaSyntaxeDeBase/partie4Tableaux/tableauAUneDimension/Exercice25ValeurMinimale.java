package tp1ProgrammationJavaSyntaxeDeBase.partie4Tableaux.tableauAUneDimension;

import java.util.Scanner;
import java.util.Random;

public class Exercice25ValeurMinimale {
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
		int min = list[0];
		for (int i = 1; i < size; i++) {
			if (list[i] < min)
				min = list[i];
		}
		System.out.println("Valeur minimale : " + min);
		sc.close();
	}
}
