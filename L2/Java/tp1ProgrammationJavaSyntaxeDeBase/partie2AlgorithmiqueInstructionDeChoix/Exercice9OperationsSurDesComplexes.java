package tp1ProgrammationJavaSyntaxeDeBase.partie2AlgorithmiqueInstructionDeChoix;

import java.util.Scanner;

public class Exercice9OperationsSurDesComplexes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez l'operation (+ ou - ou * ou /) : ");
		char operation =
			sc.nextLine().charAt(0); // Index 0 out of bounds for length 0 if Enter is pressed
		System.out.print("Entrez la partie reelle du premier nombre : ");
		double re1 = sc.nextDouble();
		System.out.print("Entrez la partie imaginaire du premier nombre : ");
		double im1 = sc.nextDouble();
		System.out.print("Entrez la partie reelle du deuxieme nombre : ");
		double re2 = sc.nextDouble();
		System.out.print("Entrez la partie imaginaire du deuxieme nombre : ");
		double im2 = sc.nextDouble();
		double re = 0.0, im = 0.0;
		switch (operation) {
			case '+':
				re = re1 + re2;
				im = im1 + im2;
				break;
			case '-':
				re = re1 - re2;
				im = im1 - im2;
				break;
			case '*':
				re = re1 * re2 - im1 * im2;
				im = re1 * im2 + im1 * re2;
				break;
			case '/':
				double divisor = re2 * re2 + im2 * im2;
				re = (re1 * re2 + im1 * im2) / divisor;
				im = (im1 * re2 - re1 * im2) / divisor;
				break;
			default:
				System.out.println("Operation invalide.");
				sc.close();
				return;
		}
		System.out.print("Resultat : " + re);
		if (im >= 0) {
			System.out.print(" + ");
		} else {
			System.out.print(" - ");
			im = -im;
		}
		System.out.println(im + "i");
		sc.close();
	}
}
