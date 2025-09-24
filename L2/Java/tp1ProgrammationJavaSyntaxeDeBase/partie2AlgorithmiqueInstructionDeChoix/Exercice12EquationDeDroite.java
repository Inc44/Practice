package tp1ProgrammationJavaSyntaxeDeBase.partie2AlgorithmiqueInstructionDeChoix;

import java.util.Scanner;

public class Exercice12EquationDeDroite {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez xA : ");
		double xA = sc.nextDouble();
		System.out.print("Entrez yA : ");
		double yA = sc.nextDouble();
		System.out.print("Entrez xB : ");
		double xB = sc.nextDouble();
		System.out.print("Entrez yB : ");
		double yB = sc.nextDouble();
		if (xA == xB && yA == yB) {
			System.out.println("Points identiques.");
		} else if (xA == xB) {
			System.out.println("x = " + xA);
		} else {
			double slope = (yB - yA) / (xB - xA);
			double yIntercept = yA - slope * xA;
			System.out.println("y = " + slope + "x + " + yIntercept);
		}
		System.out.print("Entrez xM : ");
		double xM = sc.nextDouble();
		System.out.print("Entrez yM : ");
		double yM = sc.nextDouble();
		boolean belongs;
		if (xA == xB) {
			belongs = xM == xA;
		} else {
			double slope = (yB - yA) / (xB - xA);
			double yIntercept = yA - slope * xA;
			belongs = yM == slope * xM + yIntercept;
		}
		if (belongs) {
			System.out.println("Le point M appartient a la droite AB.");
		} else {
			System.out.println("Le point M n'appartient pas a la droite AB.");
		}
		sc.close();
	}
}
