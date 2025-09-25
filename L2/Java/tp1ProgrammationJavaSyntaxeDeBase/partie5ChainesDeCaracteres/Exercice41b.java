package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice41b {
	public static void recap(String[] t, String ray) {
		int itemCount = 0;
		for (String val : t) {
			int endCode = val.indexOf(' ');
			int endDepartment = val.indexOf(' ', endCode + 1);
			if (endDepartment - endCode - 1 == ray.length()
				&& val.regionMatches(endCode + 1, ray, 0, ray.length())) {
				System.out.print("Code : ");
				for (int i = 0; i < endCode; i++) {
					System.out.print(val.charAt(i));
				}
				System.out.print(" ; article : ");
				for (int i = endDepartment + 1; i < val.length(); i++) {
					System.out.print(val.charAt(i));
				}
				System.out.println();
				itemCount++;
			}
		}
		System.out.println("Nombre d'articles au rayon " + ray + " : " + itemCount);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Taille du tableau : ");
		int size = sc.nextInt();
		sc.nextLine(); // Consume leftover newline
		String[] tab = new String[size];
		for (int i = 0; i < size; i++) {
			System.out.print("Entrez l'element " + i + " : ");
			tab[i] = sc.nextLine();
		}
		System.out.print("Entrez le rayon : ");
		String department = sc.nextLine();
		/*
		String[] tab = {"G1108 bricolage pack tournevis", "H44362 bricolage perceuse"};
		String department = "bricolage";
		*/
		recap(tab, department);
		sc.close();
	}
}
