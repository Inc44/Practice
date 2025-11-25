package tp8Swing.exercice1ExemplesDuCours;

import javax.swing.JFrame;

public class MaFenetre extends JFrame {
	public MaFenetre() // constructeur
	{
		setTitle("Ma premiere fenetre");
		setSize(300, 150);
	}

	public static void main(String args[]) {
		JFrame fen = new MaFenetre(); // creer un cadre
		fen.setVisible(true); // rendre visible la fenetre
	}
}
