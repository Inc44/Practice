package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice45a {
	public static boolean verifie(String s) {
		int open = 0;
		int close = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				open++;
			else if (c == ')')
				close++;
		}
		return open == close;
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
