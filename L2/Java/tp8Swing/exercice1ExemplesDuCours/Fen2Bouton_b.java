package tp8Swing.exercice1ExemplesDuCours;

import javax.swing.*;
import java.awt.*;

class Fen2Bouton_b extends JFrame {
	public Fen2Bouton_b() {
		JButton monBouton1, monBouton2;
		this.setTitle("deux boutons");
		this.setSize(300, 200);
		monBouton1 = new JButton("1er bouton");
		monBouton2 = new JButton("2eme bouton");
		this.getContentPane().add(BorderLayout.EAST, monBouton1);
		this.getContentPane().add(BorderLayout.WEST, monBouton2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	//}
	// public class Bouton2 {
	public static void main(String args[]) {
		Fen2Bouton_b fen = new Fen2Bouton_b();
	}
}
