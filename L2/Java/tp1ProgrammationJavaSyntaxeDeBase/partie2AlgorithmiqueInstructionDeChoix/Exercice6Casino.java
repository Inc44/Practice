package tp1ProgrammationJavaSyntaxeDeBase.partie2AlgorithmiqueInstructionDeChoix;

import java.util.Scanner;

public class Exercice6Casino {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("c pour casino, t pour toto : ");
		char choice =
			sc.nextLine().charAt(0); // Index 0 out of bounds for length 0 if Enter is pressed
		if (choice == 'c') {
			int first = (int) (Math.random() * 10);
			int second = (int) (Math.random() * 10);
			int third = (int) (Math.random() * 10);
			System.out.println("| " + first + " | " + second + " | " + third + " |");
			if (first == second && second == third) {
				System.out.println("gagne !");
			} else {
				System.out.println("perdu !");
			}
		} else if (choice == 't') {
			char[] face = {'<', '>', '-', 'o', '|', '+'};
			String result = "";
			for (int i = 0; i < 5; i++) {
				if (i == 0) {
					result += face[(int) (Math.random() * 2)];
				} else if (i == 4) {
					result += face[(int) (Math.random() * 2)];
				} else if (i == 1 || i == 3) {
					result += face[2 + (int) (Math.random() * 2)];
				} else {
					result += face[4 + (int) (Math.random() * 2)];
				}
			}
			System.out.println(result);
			if (result.compareTo("<o|o>") == 0) {
				System.out.println("gagne !");
			} else {
				System.out.println("perdu !");
			}
		} else {
			System.out.println("Mauvaise saisie.");
		}
		sc.close();
	}
}
