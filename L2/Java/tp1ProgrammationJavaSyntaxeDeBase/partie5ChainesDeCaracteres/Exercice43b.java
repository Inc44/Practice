package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice43b {
	public static boolean gagne(String str) {
		return str.contains(":-)");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez une chaine : ");
		String str = sc.nextLine();
		boolean isVictory = gagne(str);
		System.out.println("Gagne : " + isVictory);
		sc.close();
	}
}
