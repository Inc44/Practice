package tp1ProgrammationJavaSyntaxeDeBase.partie3Iterations;

import java.util.Scanner;

public class Exercice16ChiffresDUnNombreEntier {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un entier : ");
		int number = sc.nextInt();
		int power = 0;
		while (number > 0) {
			int chiffre = number % 10;
			System.out.println("10 puissance " + power + " : " + chiffre);
			number /= 10;
			power++;
		}
		sc.close();
	}
}
