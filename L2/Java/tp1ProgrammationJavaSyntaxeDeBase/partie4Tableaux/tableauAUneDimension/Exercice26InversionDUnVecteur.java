package tp1ProgrammationJavaSyntaxeDeBase.partie4Tableaux.tableauAUneDimension;

import java.util.Scanner;
import java.util.Random;

public class Exercice26InversionDUnVecteur {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		System.out.print("Taille du tableau : ");
		int size = sc.nextInt();
		int[] list = new int[size];
		for (int i = 0; i < size; i++) {
			list[i] = rand.nextInt(100);
		}
		System.out.print("Tableau original : ");
		for (int val : list) {
			System.out.print(val + " ");
		}
		System.out.println();
		for (int i = 0; i < size / 2; i++) {
			int temp = list[i];
			list[i] = list[size - 1 - i];
			list[size - 1 - i] = temp;
		}
		System.out.print("Tableau inverse : ");
		for (int val : list) {
			System.out.print(val + " ");
		}
		System.out.println();
		sc.close();
	}
}
