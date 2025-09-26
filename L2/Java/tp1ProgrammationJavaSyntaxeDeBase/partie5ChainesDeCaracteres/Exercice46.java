package tp1ProgrammationJavaSyntaxeDeBase.partie5ChainesDeCaracteres;

import java.util.Scanner;

public class Exercice46 {
	public static double calculMoyenne(String[] list) {
		double sum = 0;
		int count = 0;
		for (String val : list) {
			int startAge = val.lastIndexOf(" : ");
			if (startAge != -1) {
				startAge += 3;
				String ageStr = "";
				for (int i = startAge; i < val.length(); i++) {
					char c = val.charAt(i);
					if (c >= '0' && c <= '9') {
						ageStr += c;
					}
				}
				int age = ageStr.isEmpty() ? 0 : Integer.parseInt(ageStr);
				sum += age;
				count++;
			}
		}
		return count > 0 ? sum / count : 0;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Taille du tableau : ");
		int size = sc.nextInt();
		sc.nextLine(); // Consume leftover newline
		String[] list = new String[size];
		for (int i = 0; i < size; i++) {
			System.out.print("Entrez l'element " + i + " : ");
			list[i] = sc.nextLine();
		}
		double avg = calculMoyenne(list);
		System.out.println("Moyenne : " + avg);
		sc.close();
	}
}
