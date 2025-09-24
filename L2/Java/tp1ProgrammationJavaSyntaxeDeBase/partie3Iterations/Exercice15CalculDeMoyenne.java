package tp1ProgrammationJavaSyntaxeDeBase.partie3Iterations;

import java.util.Scanner;

public class Exercice15CalculDeMoyenne {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double sum = 0;
		int gradeCount = 0;
		while (true) {
			System.out.print("Entrez une note (-1 pour arreter) : ");
			double grade = sc.nextDouble();
			if (grade == -1)
				break;
			sum += grade;
			gradeCount++;
		}
		if (gradeCount > 0) {
			double avg = sum / gradeCount;
			System.out.println("Moyenne : " + avg);
		}
		sc.close();
	}
}
