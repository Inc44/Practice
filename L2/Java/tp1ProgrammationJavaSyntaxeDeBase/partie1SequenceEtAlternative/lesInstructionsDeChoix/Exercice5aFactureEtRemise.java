package tp1ProgrammationJavaSyntaxeDeBase.partie1SequenceEtAlternative.lesInstructionsDeChoix;

import java.util.Scanner;

public class Exercice5aFactureEtRemise {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nombre d'articles : ");
		int itemCount = sc.nextInt();
		System.out.print("Prix unitaire H.T. en euros : ");
		double unitPriceHT = sc.nextDouble();
		double totalHT = itemCount * unitPriceHT;
		double totalTTC = totalHT * 1.196;
		double discount = (totalTTC >= 200) ? totalTTC * 0.05 : 0;
		double finalAmount = totalTTC - discount;
		System.out.println("Montant T.T.C. en euros : " + Math.round(totalTTC * 100.0) / 100.0);
		System.out.println("Montant de la remise : " + Math.round(discount * 100.0) / 100.0);
		System.out.println("Montant apres la remise : " + Math.round(finalAmount * 100.0) / 100.0);
		sc.close();
	}
}
