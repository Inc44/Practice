package tp1ProgrammationJavaSyntaxeDeBase.partie3Iterations;

import java.util.Scanner;

public class Exercice24ChiffresRomains {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un entier entre 0 et 5000 exclus : ");
		int number = sc.nextInt();
		if (number < 1 || number > 4999) {
			System.out.println("Saisie invalide.");
		} else {
			int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
			String[] symbols = {
				"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
			for (int i = 0; i < 13; i++) {
				while (number >= numbers[i]) {
					System.out.print(symbols[i]);
					number -= numbers[i];
				}
			}
		}
		sc.close();
	}
}