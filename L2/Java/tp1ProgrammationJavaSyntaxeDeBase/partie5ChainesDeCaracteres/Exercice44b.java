package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice44b {
	public static int nbMots(String str) {
		int wordCount = (str.isEmpty()) ? 0 : 1;
		boolean inWord = true;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == ' ' && c != '\'') {
				if (!inWord) {
					wordCount++;
					inWord = true;
				}
			} else {
				inWord = false;
			}
		}
		return wordCount;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez une chaine : ");
		String str = sc.nextLine();
		int wordCount = nbMots(str);
		System.out.println("Nombre de mots : " + wordCount);
		sc.close();
	}
}
