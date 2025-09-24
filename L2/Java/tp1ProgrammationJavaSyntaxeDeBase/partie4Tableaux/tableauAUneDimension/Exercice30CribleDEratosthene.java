package tp1ProgrammationJavaSyntaxeDeBase.partie4Tableaux.tableauAUneDimension;

public class Exercice30CribleDEratosthene {
	public static void main(String[] args) {
		boolean[] prem = new boolean[1001];
		for (int i = 2; i <= 1000; i++) {
			prem[i] = true;
		}
		for (int p = 2; p * p <= 1000; p++) {
			if (prem[p]) {
				for (int multiple = p * p; multiple <= 1000; multiple += p) {
					prem[multiple] = false;
				}
			}
		}
		System.out.print("Nombres premiers : ");
		for (int i = 2; i <= 1000; i++) {
			if (prem[i]) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}
