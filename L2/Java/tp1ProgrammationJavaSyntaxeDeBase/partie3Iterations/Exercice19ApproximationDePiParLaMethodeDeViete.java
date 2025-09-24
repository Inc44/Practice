package tp1ProgrammationJavaSyntaxeDeBase.partie3Iterations;

import java.util.Scanner;

public class Exercice19ApproximationDePiParLaMethodeDeViete {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez le rang n : ");
		int n = sc.nextInt();
		double v = 0;
		double u = 2;
		for (int i = 0; i < n; i++) {
			v = Math.sqrt((1 + v) / 2);
			u /= v;
		}
		System.out.println("Approximation de pi : " + u);
		sc.close();
	}
}
