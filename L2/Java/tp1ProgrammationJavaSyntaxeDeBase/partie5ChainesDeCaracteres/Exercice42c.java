package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice42c {
	public static boolean estPalindrome(String str) {
		String inversedStr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			inversedStr += str.charAt(i);
		}
		return str.equals(inversedStr);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez une chaine : ");
		String str = sc.nextLine();
		boolean isPalindrome = estPalindrome(str);
		System.out.println("Palindrome : " + isPalindrome);
		sc.close();
	}
}
