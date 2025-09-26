package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice48e {
	public static void affichePendu(int n) {
		System.out.println("+--+");
		System.out.println("|" + (n >= 1 ? "  |" : ""));
		System.out.println("|" + (n >= 2 ? "  o" : ""));
		System.out.println("|" + (n >= 3 ? "  |" : ""));
		System.out.println("|" + (n == 4 ? "  |" : "") + (n >= 5 ? " / \\" : ""));
		System.out.println("|" + (n >= 6 ? "  |" : ""));
		System.out.println("|" + (n == 7 ? "  |" : "") + (n >= 8 ? " / \\" : ""));
		System.out.println("|");
	}
	public static String initMot(String mot) {
		if (mot.length() <= 2) {
			return mot;
		}
		String str = "";
		str += mot.charAt(0);
		for (int i = 1; i < mot.length() - 1; i++) {
			str += "*";
		}
		str += mot.charAt(mot.length() - 1);
		return str;
	}
	public static String remplaceCar(String reponse, String etatActuel, char guess) {
		String str = "";
		for (int i = 0; i < reponse.length(); i++) {
			if (reponse.charAt(i) == guess) {
				str += guess;
			} else {
				str += etatActuel.charAt(i);
			}
		}
		return str;
	}
	public static void hangman(String word) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 50; i++) System.out.println();
		String str = initMot(word);
		int attempt = 0;
		while (attempt < 8 && !str.equals(word)) {
			System.out.println(str);
			System.out.print("Entrez un caractere : ");
			char c = sc.nextLine().charAt(0);
			boolean found = false;
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == c) {
					found = true;
					break;
				}
			}
			if (found) {
				str = remplaceCar(word, str, c);
			} else {
				attempt++;
				affichePendu(attempt);
			}
		}
		if (str.equals(word))
			System.out.println(word);
		else
			System.out.println("Perdu !");
		sc.close();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un mot : ");
		String word = sc.nextLine();
		hangman(word);
		sc.close();
	}
}
