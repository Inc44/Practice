package tp8Swing.exercice1ExemplesDuCours;

import java.awt.*;
import javax.swing.*;

public class Fen2Bouton extends JFrame {
	public Fen2Bouton() {
		JButton monBouton1, monBouton2;
		JFrame fen = new JFrame();
		JPanel panneau = new JPanel();
		panneau.setBackground(Color.darkGray);
		panneau.setLayout(
			new BoxLayout(panneau, BoxLayout.Y_AXIS)); // changement du Layout
													   // Y_AXIS pour empilement vertical
		monBouton1 = new JButton("1er bouton");
		monBouton2 = new JButton("2eme bouton");
		panneau.add(monBouton1); // on ajoute le bouton au panneau
		panneau.add(monBouton2);
		fen.getContentPane().add(BorderLayout.EAST, panneau); // ajouter le panneau a la fenetre
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setSize(300, 200);
		fen.setVisible(true);
	}
	public static void main(String args[]) {
		Fen2Bouton fen = new Fen2Bouton();
	}
}
