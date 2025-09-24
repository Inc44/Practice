package tp1ProgrammationJavaSyntaxeDeBase.partie3Iterations;

import java.util.Scanner;
import java.util.Random;

public class Exercice22Jeu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int number = rand.nextInt(100);
		int attempts = 0;
		while (true) {
			System.out.print("Entrez un nombre entre 0 et 100 : ");
			int guess = sc.nextInt();
			attempts++;
			if (guess == number) {
				break;
			} else if (guess < number) {
				System.out.println("Le nombre cherche est plus grand, veuillez recommencer.");
			} else {
				System.out.println("Le nombre cherche est plus petit, veuillez recommencer.");
			}
		}
		System.out.println(
			"Vous avez utilise " + attempts + " essai" + (attempts > 1 ? "s" : "") + ".");
		if (attempts < 5) {
			System.out.println("Pas mal.");
		} else {
			System.out.println("Trop nul.");
		}
		sc.close();
	}
}
