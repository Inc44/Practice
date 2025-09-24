package tp1ProgrammationJavaSyntaxeDeBase.partie4Tableaux.tableauAUneDimension;

import java.util.Scanner;
import java.util.Random;

public class Exercice28VecteurTemperature {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		System.out.print("Nombre de jours : ");
		int dayCount = sc.nextInt();
		int min = -100, max = 100;
		int[] temperatures = new int[dayCount];
		for (int i = 0; i < dayCount; i++) {
			temperatures[i] = rand.nextInt(max - min) + min;
		}
		System.out.print("Temperatures : ");
		for (int t : temperatures) {
			System.out.print(t + " ");
		}
		System.out.println();
		// int[] temperatures = {15, 20, 22, 18, 18, 20, 17};
		int[] differences = new int[dayCount - 1];
		for (int i = 0; i < dayCount - 1; i++) {
			differences[i] = temperatures[i + 1] - temperatures[i];
		}
		System.out.print("Differences : ");
		for (int d : differences) {
			System.out.print(d + " ");
		}
		System.out.println();
		sc.close();
	}
}
