package tp1ProgrammationJavaSyntaxeDeBase.partie1SequenceEtAlternative.lesInstructionsDeChoix;

import java.util.Scanner;

public class Exercice3DureeConversion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez la duree en secondes : ");
		int totalSeconds = sc.nextInt();
		int hours = totalSeconds / 3600;
		int minutes = (totalSeconds % 3600) / 60;
		int seconds = totalSeconds % 60;
		if (hours > 0) {
			System.out.print(hours + " heures ");
		}
		if (minutes > 0) {
			System.out.print(minutes + " minutes ");
		}
		System.out.println(seconds + " secondes");
		sc.close();
	}
}
