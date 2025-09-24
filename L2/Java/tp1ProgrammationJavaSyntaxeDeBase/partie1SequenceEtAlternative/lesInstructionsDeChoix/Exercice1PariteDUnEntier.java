package tp1ProgrammationJavaSyntaxeDeBase.partie1SequenceEtAlternative.lesInstructionsDeChoix;

import java.util.Scanner;

public class Exercice1PariteDUnEntier {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un nombre entier : ");
		int number = sc.nextInt();
		if (number % 2 == 0) {
			System.out.println("Le nombre " + number + " est pair");
		} else {
			System.out.println("Le nombre " + number + " est impair");
		}
		sc.close();
	}
}
