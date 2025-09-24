package tp1ProgrammationJavaSyntaxeDeBase.partie1SequenceEtAlternative.lesInstructionsDeChoix;

import java.util.Scanner;

public class Exercice4Bissextile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez une annee: ");
		int year = sc.nextInt();
		boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
		if (isLeap) {
			System.out.println("L'annee " + year + " est bissextile");
		} else {
			System.out.println("L'annee " + year + " n'est pas bissextile");
		}
		sc.close();
	}
}
