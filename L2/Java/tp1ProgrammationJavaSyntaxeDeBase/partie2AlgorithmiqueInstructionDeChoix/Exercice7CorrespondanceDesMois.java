package tp1ProgrammationJavaSyntaxeDeBase.partie2AlgorithmiqueInstructionDeChoix;

import java.util.Scanner;

public class Exercice7CorrespondanceDesMois {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un entier entre 1 et 12 : ");
		int number = sc.nextInt();
		if (number < 1 || number > 12) {
			System.out.println("Saisie invalide.");
		} else {
			String[] months = {"Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet",
				"Aout", "Septembre", "Octobre", "Novembre", "Decembre"};
			System.out.println(months[number - 1]);
		}
		sc.close();
	}
}
