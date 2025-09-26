package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice49d {
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
	public static int taillePlusLong(String[] tab) {
		if (tab.length == 0)
			return 0;
		int max = tab[0].length();
		for (int i = 1; i < tab.length; i++) {
			int size = tab[i].length();
			if (size > max)
				max = size;
		}
		return max;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Taille du tableau : ");
		int size = sc.nextInt();
		sc.nextLine(); // Consume leftover newline
		String[] list = new String[size];
		list = saisieTab(list);
		int max = taillePlusLong(list);
		System.out.println("Longueur du mot de passe le plus long : " + max);
		sc.close();
	}
}
