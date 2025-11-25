package tp8Swing.exercice1ExemplesDuCours;

import javax.swing.*;
import java.awt.*;

class Fen2Bouton_d extends JFrame {
	public Fen2Bouton_d() {
		JButton monBouton1, monBouton2;
		JPanel panneau = new JPanel(); // création du panneau
		panneau.setBackground(Color.darkGray); // couleur de fond gris foncé
		monBouton1 = new JButton("1er bouton");
		monBouton2 = new JButton("2eme bouton");
		panneau.add(monBouton1); // on ajoute le bouton au panneau
		panneau.add(monBouton2);
		this.getContentPane().add(BorderLayout.EAST, panneau); // ajouter le panneau à la fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 200);
		this.setVisible(true);
	}
	//}
	// public class Bouton2 {
	public static void main(String args[]) {
		Fen2Bouton_d fen = new Fen2Bouton_d();
	}
}
