package tp1ProgrammationJavaSyntaxeDeBase.partie3Iterations;

import java.util.Scanner;

public class Exercice20aNombresPremiers {
	public static boolean isPrime(int number) {
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
		System.out.print("Entrez un entier : ");
		int number = sc.nextInt();
		if (isPrime(number)) {
			System.out.println("Le nombre est premier.");
		} else {
			System.out.println("Le nombre n'est pas premier.");
		}
		sc.close();
	}
}
