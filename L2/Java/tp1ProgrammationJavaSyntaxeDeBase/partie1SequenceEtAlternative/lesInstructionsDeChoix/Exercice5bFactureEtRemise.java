package tp1ProgrammationJavaSyntaxeDeBase.partie1SequenceEtAlternative.lesInstructionsDeChoix;

import java.util.Scanner;

public class Exercice5bFactureEtRemise {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nombre d'articles : ");
		int articleCount = sc.nextInt();
		System.out.print("Prix unitaire H.T. en euros : ");
		double unitPriceHT = sc.nextDouble();
		double totalHT = articleCount * unitPriceHT;
		double totalTTC = totalHT * 1.196;
		double discountRate = 0;
		if (totalTTC >= 1000) {
			discountRate = 0.10;
		} else if (totalTTC >= 500) {
			discountRate = 0.07;
		} else if (totalTTC >= 200) {
			discountRate = 0.05;
		}
		double discount = totalTTC * discountRate;
		double finalAmount = totalTTC - discount;
		System.out.println("Montant T.T.C. en euros : " + Math.round(totalTTC * 100.0) / 100.0);
		System.out.println("Montant de la remise : " + Math.round(discount * 100.0) / 100.0);
		System.out.println("Montant apres la remise : " + Math.round(finalAmount * 100.0) / 100.0);
		sc.close();
	}
}
