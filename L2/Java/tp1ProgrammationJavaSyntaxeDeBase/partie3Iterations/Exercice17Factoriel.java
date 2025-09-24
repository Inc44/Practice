package tp1ProgrammationJavaSyntaxeDeBase.partie3Iterations;

import java.util.Scanner;

public class Exercice17Factoriel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez n : ");
		int n = sc.nextInt();
		long factorial = 1; // Factorial 20 overflow
		for (int i = 1; i <= n; i++) {
			factorial *= i;
		}
		System.out.println("Factorielle : " + factorial);
		sc.close();
	}
}
