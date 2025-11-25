package tp8Swing.exercice1ExemplesDuCours;

import java.awt.*;
import javax.swing.*;

class Fen2Bouton_c extends JFrame {
	public Fen2Bouton_c() {
		JButton monBouton1, monBouton2;
		this.setTitle("deux boutons");
		this.setSize(300, 200);
		monBouton1 = new JButton("1er bouton");
		monBouton2 = new JButton("2eme bouton");
		this.setLayout(new FlowLayout());
		this.getContentPane().add(monBouton1);
		this.getContentPane().add(monBouton2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	//}
	// public class Bouton2 {
	public static void main(String args[]) {
		Fen2Bouton_c fen = new Fen2Bouton_c();
	}
}
