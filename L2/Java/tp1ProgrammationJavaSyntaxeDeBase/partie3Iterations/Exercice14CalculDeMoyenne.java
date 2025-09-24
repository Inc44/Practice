package tp1ProgrammationJavaSyntaxeDeBase.partie3Iterations;

import java.util.Scanner;

public class Exercice14CalculDeMoyenne {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez le nombre de notes : ");
		int gradeCount = sc.nextInt();
		double sum = 0;
		for (int i = 0; i < gradeCount; i++) {
			System.out.print("Entrez la note " + (i + 1) + " : ");
			sum += sc.nextDouble();
		}
		double avg = sum / gradeCount;
		System.out.println("Moyenne : " + avg);
		sc.close();
	}
}
