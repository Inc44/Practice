package tp8Swing.exercice1ExemplesDuCours;

import java.awt.*;
import javax.swing.*;

public class Panneau extends JPanel {
	public void paintComponent(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(20, 50, 100, 100);
	}
	//}
	public static class Fen1Bouton extends JFrame {
		public Fen1Bouton() {
			this.setSize(300, 200);
			Panneau pan = new Panneau();
			this.getContentPane().add(pan);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}
	}
	// public class Dessin1 {
	public static void main(String args[]) {
		Fen1Bouton fen = new Fen1Bouton();
	}
}
