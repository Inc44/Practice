package tp1ProgrammationJavaSyntaxeDeBase.partie4Tableaux.tableauAUneDimension;

import java.util.Scanner;

public class Exercice29ManipulationDeVecteurs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Taille des vecteurs : ");
		int tt = sc.nextInt();
		double[] v1 = new double[tt];
		double[] v2 = new double[tt];
		double[] v3 = new double[tt];
		boolean keepRunning = true;
		while (keepRunning) {
			System.out.println("Menu : ");
			System.out.println("1. Entrer v1");
			System.out.println("2. Calculer norme v1");
			System.out.println("3. Multiplier v1 par scalaire");
			System.out.println("4. Entrer v2");
			System.out.println("5. Calculer v3 = v1 + v2");
			System.out.println("6. Tester colinearite");
			System.out.println("7. Produit scalaire");
			System.out.println("0. Quitter");
			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					for (int i = 0; i < tt; i++) {
						v1[i] = sc.nextDouble();
					}
					break;
				case 2:
					double norm = 0;
					for (double val : v1) {
						norm += val * val;
					}
					System.out.println("Norme v1 : " + Math.sqrt(norm));
					break;
				case 3:
					System.out.print("Scalaire k : ");
					double k = sc.nextDouble();
					for (int i = 0; i < tt; i++) {
						v1[i] *= k;
						System.out.print(v1[i] + " ");
					}
					System.out.println();
					break;
				case 4:
					for (int i = 0; i < tt; i++) {
						v2[i] = sc.nextDouble();
					}
					break;
				case 5:
					for (int i = 0; i < tt; i++) {
						v3[i] = v1[i] + v2[i];
						System.out.print(v3[i] + " ");
					}
					System.out.println();
					break;
				case 6:
					boolean collinear = true;
					double ratio = v1[0] / v2[0];
					for (int i = 1; i < tt; i++) {
						if (v1[i] / v2[i] != ratio) {
							collinear = false;
							break;
						}
					}
					System.out.println("Colineaires : " + collinear);
					break;
				case 7:
					double product = 0;
					for (int i = 0; i < tt; i++) {
						product += v1[i] * v2[i];
					}
					System.out.println("Produit scalaire : " + product);
					break;
				case 0:
					keepRunning = false;
					break;
			}
		}
		sc.close();
	}
}
