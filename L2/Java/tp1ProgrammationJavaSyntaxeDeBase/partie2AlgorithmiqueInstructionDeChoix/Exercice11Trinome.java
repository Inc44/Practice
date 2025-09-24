package tp1ProgrammationJavaSyntaxeDeBase.partie2AlgorithmiqueInstructionDeChoix;

import java.util.Scanner;

public class Exercice11Trinome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez a : ");
		double a = sc.nextDouble();
		System.out.print("Entrez b : ");
		double b = sc.nextDouble();
		System.out.print("Entrez c : ");
		double c = sc.nextDouble();
		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					System.out.println("Infini de solutions.");
				} else {
					System.out.println("Aucune solution.");
				}
			} else {
				System.out.println("Solution : " + (-c / b));
			}
		} else {
			double delta = b * b - 4 * a * c;
			if (delta > 0) {
				double x1 = (-b + Math.sqrt(delta)) / (2 * a);
				double x2 = (-b - Math.sqrt(delta)) / (2 * a);
				System.out.println("Solutions reelles : " + x1 + ", " + x2);
			} else if (delta == 0) {
				double x = -b / (2 * a);
				System.out.println("Solution reelle : " + x);
			} else {
				double re = -b / (2 * a);
				double im = Math.sqrt(-delta) / (2 * a);
				System.out.println(
					"Solutions complexes : " + re + " + " + im + "i, " + re + " - " + im + "i");
			}
		}
		sc.close();
	}
}
