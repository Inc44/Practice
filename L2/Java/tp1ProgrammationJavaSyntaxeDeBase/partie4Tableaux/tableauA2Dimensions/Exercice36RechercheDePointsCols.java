package tp1ProgrammationJavaSyntaxeDeBase.partie4Tableaux.tableauA2Dimensions;

import java.util.Scanner;

public class Exercice36RechercheDePointsCols {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un nombre de lignes : ");
		int rows = sc.nextInt();
		System.out.print("Entrez un nombre de colonnes : ");
		int cols = sc.nextInt();
		int[][] mat = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			System.out.print("Entrez les elements de la ligne " + i + " : ");
			for (int j = 0; j < cols; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		boolean[][] max = new boolean[rows][cols];
		boolean[][] min = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			int rowMax = mat[i][0];
			for (int j = 0; j < cols; j++) {
				if (mat[i][j] > rowMax) {
					rowMax = mat[i][j];
				}
			}
			for (int j = 0; j < cols; j++) {
				if (mat[i][j] == rowMax) {
					max[i][j] = true;
				}
			}
		}
		for (int j = 0; j < cols; j++) {
			int colMin = mat[0][j];
			for (int i = 0; i < rows; i++) {
				if (mat[i][j] < colMin) {
					colMin = mat[i][j];
				}
			}
			for (int i = 0; i < rows; i++) {
				if (mat[i][j] == colMin) {
					min[i][j] = true;
				}
			}
		}
		System.out.println("Points-cols :");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (max[i][j] && min[i][j]) {
					System.out.println("mat[" + i + "][" + j + "] = " + mat[i][j]);
				}
			}
		}
		sc.close();
	}
}
