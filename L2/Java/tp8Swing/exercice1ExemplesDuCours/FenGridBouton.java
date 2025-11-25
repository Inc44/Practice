package tp8Swing.exercice1ExemplesDuCours;

import javax.swing.*;
import java.awt.*;

public class FenGridBouton extends JFrame {
	public FenGridBouton() {
		JPanel panneau = new JPanel(new GridLayout(2, 3));
		panneau.add(new JButton("A"));
		panneau.add(new JButton("B"));
		panneau.add(new JButton("C"));
		panneau.add(new JButton("D"));
		panneau.add(new JButton("E"));
		panneau.add(new JButton("F"));
		this.getContentPane().add(panneau);
		// ajouter le panneau a la fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 100);
		this.setVisible(true);
	}
	//}
	// public class GridBouton {
	public static void main(String args[]) {
		FenGridBouton fen = new FenGridBouton();
	}
}
