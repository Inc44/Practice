package tp1ProgrammationJavaSyntaxeDeBase.partie3Iterations;

import java.util.Scanner;

public class Exercice20bNombresPremiers {
	public static boolean estPremier(int number) {
		if (number <= 1)
			return false;
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez n < 1000 : ");
		int n = sc.nextInt();
		for (int i = 2; i <= n; i++) {
			if (estPremier(i)) {
				System.out.print(i + " ");
			}
		}
		sc.close();
	}
}
