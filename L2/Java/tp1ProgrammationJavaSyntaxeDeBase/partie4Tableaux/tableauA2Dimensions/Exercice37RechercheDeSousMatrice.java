package tp1ProgrammationJavaSyntaxeDeBase.partie4Tableaux.tableauA2Dimensions;

import java.util.Scanner;

public class Exercice37RechercheDeSousMatrice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un nombre de lignes de la matrice principale : ");
		int rows = sc.nextInt();
		System.out.print("Entrez un nombre de colonnes de la matrice principale : ");
		int cols = sc.nextInt();
		int matrix[][] = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			System.out.print("Entrez les elements de la ligne " + i + " : ");
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		/*
		int rows = 12;
		int cols = 12;
		int matrix[][] = {{0, 0, 2, 1, 2, 1, 1, 1, 1, 2, 1, 1},
			{2, 1, 1, 0, 1, 0, 0, 1, 2, 2, 0, 1}, {2, 2, 1, 0, 1, 1, 2, 0, 0, 2, 1, 2},
			{2, 0, 0, 2, 2, 0, 1, 0, 2, 1, 0, 1}, {1, 2, 2, 2, 1, 0, 1, 1, 2, 2, 0, 2},
			{0, 1, 2, 2, 0, 1, 1, 1, 1, 2, 1, 1}, {0, 0, 2, 0, 2, 2, 1, 2, 0, 0, 0, 0},
			{0, 0, 1, 0, 2, 0, 2, 2, 0, 2, 0, 2}, {2, 2, 2, 0, 0, 1, 1, 2, 0, 1, 1, 1},
			{1, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 1}, {2, 0, 1, 2, 1, 0, 0, 1, 2, 2, 2, 2},
			{1, 0, 1, 0, 0, 0, 0, 1, 0, 2, 1, 1}};
		*/
		System.out.print("Entrez un nombre de lignes de la sous-matrice : ");
		int subRows = sc.nextInt();
		System.out.print("Entrez un nombre de colonnes de la sous-matrice : ");
		int subCols = sc.nextInt();
		int subMatrix[][] = new int[subRows][subCols];
		for (int i = 0; i < subRows; i++) {
			System.out.print("Entrez les elements de la ligne " + i + " : ");
			for (int j = 0; j < subCols; j++) {
				subMatrix[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < rows - subRows; i++) {
			for (int j = 0; j < cols - subCols; j++) {
				boolean match = true;
				for (int subI = 0; subI < subRows && match; subI++) {
					for (int subJ = 0; subJ < subCols && match; subJ++) {
						if (matrix[i + subI][j + subJ] != subMatrix[subI][subJ]) {
							match = false;
						}
					}
				}
				if (match) {
					System.out.println("Position de la sous-matrice : " + i + " " + j);
				}
			}
		}
		sc.close();
	}
}
