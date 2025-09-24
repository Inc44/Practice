package tp1ProgrammationJavaSyntaxeDeBase.partie3Iterations;

import java.util.Scanner;

public class Exercice21aNombreParfait {
	public static boolean isPerfect(int number) {
		if (number <= 1)
			return false;
		int sum = 1;
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				sum += i;
				if (i != number / i)
					sum += number / i;
			}
		}
		return sum == number;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un entier : ");
		int number = sc.nextInt();
		if (isPerfect(number)) {
			System.out.println("Le nombre est parfait.");
		} else {
			System.out.println("Le nombre n'est pas parfait.");
		}
		sc.close();
	}
}
