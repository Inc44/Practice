package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice49c {
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
					// sc.close(); // Exception in thread "main"
					return str;
				}
			}
		}
	}
	public static String[] saisieTab(String[] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(i + " : ");
			tab[i] = saisiePwd();
		}
		return tab;
	}
	public static int taillePlusCourt(String[] tab) {
		if (tab.length == 0)
			return 0;
		int min = tab[0].length();
		for (int i = 1; i < tab.length; i++) {
			int size = tab[i].length();
			if (size < min)
				min = size;
		}
		return min;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Taille du tableau : ");
		int size = sc.nextInt();
		sc.nextLine(); // Consume leftover newline
		String[] list = new String[size];
		list = saisieTab(list);
		int min = taillePlusCourt(list);
		System.out.println("Longueur du mot de passe le plus court : " + min);
		sc.close();
	}
}
