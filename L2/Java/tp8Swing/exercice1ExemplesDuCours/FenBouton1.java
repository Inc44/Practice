package tp8Swing.exercice1ExemplesDuCours;

import javax.swing.*;
import java.awt.*;

public class FenBouton1 extends JFrame {
	public FenBouton1() {
		JButton monBouton1, monBouton2;
		JFrame fen = new JFrame();
		fen.setTitle("deux boutons");
		fen.setSize(300, 200);
		monBouton1 = new JButton("1er bouton");
		monBouton2 = new JButton("2eme bouton");
		fen.getContentPane().add(monBouton1);
		fen.getContentPane().add(monBouton2);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);
	}

	public static void main(String args[]) {
		FenBouton1 fen = new FenBouton1();
	}
}
