package tp1ProgrammationJavaSyntaxeDeBase.partie4Tableaux.tableauA2Dimensions;

import java.util.Scanner;

public class Exercice34ProduitDeMatricesLigneEtColonne {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Dimension m pour ligne : ");
		int m = sc.nextInt();
		int[] Li = new int[m];
		System.out.print("Entrez les elements de Li : ");
		for (int i = 0; i < m; i++) {
			Li[i] = sc.nextInt();
		}
		System.out.print("Dimension p pour colonne : ");
		int p = sc.nextInt();
		int[] Cj = new int[p];
		System.out.print("Entrez les elements de Cj : ");
		for (int j = 0; j < p; j++) {
			Cj[j] = sc.nextInt();
		}
		int[][] product = new int[m][p];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < p; j++) {
				product[i][j] = Li[i] * Cj[j];
			}
		}
		System.out.println("Produit :");
		for (int[] row : product) {
			for (int val : row) {
				System.out.print(val + "\t");
			}
			System.out.println();
		}
		sc.close();
	}
}
