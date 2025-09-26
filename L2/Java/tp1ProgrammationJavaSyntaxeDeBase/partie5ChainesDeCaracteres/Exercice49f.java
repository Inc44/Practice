package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice49f {
	public static String saisiePwd() {
		Scanner sc = new Scanner(System.in);
		String caracSpec = "&@#$%+=*";
		while (true) {
			System.out.print("Entrez un mot de passe : ");
			String str = sc.nextLine();
			if (str.length() >= 8) {
				boolean isValid = false;
				for (int i = 0; i < str.length(); i++) {
					if (caracSpec.indexOf(str.charAt(i)) >= 0) {
						isValid = true;
						break;
					}
				}
				if (isValid) {
					sc.close();
					return str;
				}
			}
		}
	}
	public static int nbCaracSpec(String s) {
		String caracSpec = "&@#$%+=*";
		int specialCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (caracSpec.indexOf(s.charAt(i)) >= 0) {
				specialCount++;
			}
		}
		return specialCount;
	}
	public static void main(String[] args) {
		String str = saisiePwd();
		System.out.println("Mot de passe : " + str);
		int specialCount = nbCaracSpec(str);
		System.out.println("Nombre de caracteres speciaux : " + specialCount);
	}
}
