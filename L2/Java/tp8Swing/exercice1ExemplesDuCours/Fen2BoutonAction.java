package tp8Swing.exercice1ExemplesDuCours;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Fen2BoutonAction extends JFrame {
	JButton monBouton1, monBouton2;
	public Fen2BoutonAction() {
		this.setTitle("deux boutons");
		this.setSize(300, 200);
		monBouton1 = new JButton("1er bouton");
		monBouton1.addActionListener(new TexteListener_bout1());
		monBouton2 = new JButton("2eme bouton");
		monBouton2.addActionListener(new TexteListener_bout2());
		this.setLayout(new FlowLayout());
		this.getContentPane().add(monBouton1);
		this.getContentPane().add(monBouton2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	class TexteListener_bout1 implements ActionListener {
		public void actionPerformed(ActionEvent Event) {
			monBouton1.setText("j'ai été cliqué moi le bouton 1!");
		}
	}
	class TexteListener_bout2 implements ActionListener {
		public void actionPerformed(ActionEvent Event) {
			monBouton2.setText("j'ai été cliqué moi le bouton 2!");
		}
	}
	// public class Bouton2Action {
	public static void main(String args[]) {
		Fen2BoutonAction fen = new Fen2BoutonAction();
	}
	//}
}
