package tp8Swing.exercice1ExemplesDuCours;

import java.awt.event.*;
import javax.swing.*;

class Fen1BoutonAction extends JFrame implements ActionListener {
	JButton monBouton;
	public Fen1BoutonAction() {
		this.setTitle("Gestion du clic");
		this.setSize(300, 200);
		monBouton = new JButton("Cliquez-moi");
		monBouton.addActionListener(this); // s’ajouter à la liste des auditeurs
		this.getContentPane().add(monBouton);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent event) {
		monBouton.setText("j'ai été cliqué!");
		// bouton appelle cette méthode quand l’évènement se produit
	}
	//}
	// public class Bouton1Action {
	public static void main(String args[]) {
		Fen1BoutonAction fen = new Fen1BoutonAction();
	}
}
