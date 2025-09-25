package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice38 {
	public static void affiche(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
			if (i < str.length() - 1) {
				System.out.print(",");
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez une chaine : ");
		String str = sc.nextLine();
		affiche(str);
		sc.close();
	}
}
