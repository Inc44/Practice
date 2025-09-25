package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice41a {
	public static void affiche(String[] list) {
		for (String val : list) {
			int endCode = val.indexOf(' ');
			int endDepartment = val.indexOf(' ', endCode + 1);
			System.out.print("Code : ");
			for (int i = 0; i < endCode; i++) {
				System.out.print(val.charAt(i));
			}
			System.out.print(" ; rayon : ");
			for (int i = endCode + 1; i < endDepartment; i++) {
				System.out.print(val.charAt(i));
			}
			System.out.print(" ; article : ");
			for (int i = endDepartment + 1; i < val.length(); i++) {
				System.out.print(val.charAt(i));
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Taille du tableau : ");
		int size = sc.nextInt();
		sc.nextLine(); // Consume leftover newline
		String[] tab = new String[size];
		for (int i = 0; i < size; i++) {
			System.out.print("Entrez element " + i + " : ");
			tab[i] = sc.nextLine();
		}
		// String[] tab = {"G1108 bricolage pack tournevis"};
		affiche(tab);
		sc.close();
	}
}
