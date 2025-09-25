package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice45b {
	public static boolean verifie(String s) {
		int parenthesisCount = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				parenthesisCount++;
			else if (c == ')') {
				parenthesisCount--;
				if (parenthesisCount < 0)
					return false;
			}
		}
		return parenthesisCount == 0;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez une expression : ");
		String str = sc.nextLine();
		boolean isValid = verifie(str);
		System.out.println("Valide : " + isValid);
		sc.close();
	}
}
