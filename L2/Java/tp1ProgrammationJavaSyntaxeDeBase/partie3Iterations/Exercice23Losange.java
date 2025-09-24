package tp1ProgrammationJavaSyntaxeDeBase.partie3Iterations;

import java.util.Scanner;

public class Exercice23Losange {
	public static void printRow(int i, int n, char c) {
		for (int j = 0; j < n - 1 - i; j++) {
			System.out.print(' ');
		}
		System.out.print(c);
		for (int j = 0; j < 2 * i - 1; j++) {
			System.out.print(' ');
		}
		if (i > 0) {
			System.out.print(c);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un caractere : ");
		char c = sc.nextLine().charAt(0);
		int n = 0;
		while (n < 1) {
			System.out.print("Entrez n >= 1 : ");
			n = sc.nextInt();
		}
		int size = 0;
		while (size < 1) {
			System.out.print("Taille du losange : ");
			size = sc.nextInt();
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < n; j++) {
				printRow(j, n, c);
			}
			for (int j = n - 2; j >= 0; j--) {
				printRow(j, n, c);
			}
		}
		sc.close();
	}
}