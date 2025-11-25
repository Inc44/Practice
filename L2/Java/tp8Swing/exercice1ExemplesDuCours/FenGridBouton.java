package tp8Swing.exercice1ExemplesDuCours;

import javax.swing.*;

import java.awt.*;

public class FenGridBouton extends JFrame {
	public FenGridBouton() {
		JButton monBouton1, monBouton2;
		JFrame fen = new JFrame();
		JPanel panneau = new JPanel(new GridLayout(2, 3));
		panneau.add(new JButton("A"));
		panneau.add(new JButton("B"));
		panneau.add(new JButton("C"));
		panneau.add(new JButton("D"));
		panneau.add(new JButton("E"));
		panneau.add(new JButton("F"));
		fen.getContentPane().add(panneau); // ajouter le panneau a la fenetre
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setSize(300, 100);
		fen.setVisible(true);
	}
	public static void main(String args[]) {
		FenGridBouton fen = new FenGridBouton();
	}
}
