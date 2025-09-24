package tp1ProgrammationJavaSyntaxeDeBase.partie3Iterations;

import java.util.Scanner;

public class Exercice18NombreDeFibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez n : ");
		int n = sc.nextInt();
		if (n == 1 || n == 2) {
			System.out.println(1);
		} else {
			long f1 = 1;
			long f2 = 1;
			long fn = 0; // Fibonacci 92 overflow
			for (int i = 3; i <= n; i++) {
				fn = f1 + f2;
				f1 = f2;
				f2 = fn;
			}
			System.out.println(fn);
		}
		sc.close();
	}
}
