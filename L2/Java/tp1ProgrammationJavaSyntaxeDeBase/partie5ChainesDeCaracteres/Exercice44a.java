package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice44a {
	public static String epure(String str) {
		String trimmedStr = "";
		boolean inSpace = true;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == ' ') {
				if (!inSpace) {
					trimmedStr += ' ';
					inSpace = true;
				}
			} else {
				trimmedStr += c;
				inSpace = false;
			}
		}
		int size = trimmedStr.length();
		if (size > 0 && trimmedStr.charAt(size - 1) == ' ') {
			size--;
		}
		String cleanedStr = "";
		for (int i = 0; i < size; i++) {
			cleanedStr += trimmedStr.charAt(i);
		}
		return cleanedStr;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez une chaine : ");
		String str = sc.nextLine();
		// String str = " coucou      le monde";
		String cleanedStr = epure(str);
		System.out.print(cleanedStr);
		sc.close();
	}
}
