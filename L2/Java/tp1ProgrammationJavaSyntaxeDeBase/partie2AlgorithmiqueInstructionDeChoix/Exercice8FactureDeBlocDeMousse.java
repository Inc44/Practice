package tp1ProgrammationJavaSyntaxeDeBase.partie2AlgorithmiqueInstructionDeChoix;

import java.util.Scanner;

public class Exercice8FactureDeBlocDeMousse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(
			"Quelle est la forme voulue ? Saisir r pour rectangulaire, c pour cylindrique : ");
		char shape =
			sc.nextLine().charAt(0); // Index 0 out of bounds for length 0 if Enter is pressed
		double volume = 0.0;
		if (shape == 'r') {
			System.out.print("Largeur en metres : ");
			double width = sc.nextDouble();
			System.out.print("Longueur en metres : ");
			double length = sc.nextDouble();
			System.out.print("Profondeur en metres : ");
			double depth = sc.nextDouble();
			volume = width * length * depth;
		} else if (shape == 'c') {
			System.out.print("Rayon en metres : ");
			double radius = sc.nextDouble();
			System.out.print("Hauteur en metres : ");
			double height = sc.nextDouble();
			volume = 2 * radius * 2 * radius * height;
		} else {
			System.out.println("Forme invalide.");
			sc.close();
		}
		double priceM3 = 300.0;
		double price = volume * priceM3;
		System.out.println("Prix TTC : " + Math.round(price * 100.0) / 100.0 + " euros.");
		sc.close();
	}
}
