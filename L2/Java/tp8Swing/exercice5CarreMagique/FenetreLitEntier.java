package tp8Swing.exercice5CarreMagique;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FenetreLitEntier extends JFrame implements ActionListener {
	private JLabel text = new JLabel("Entrez un nombre");
	private JTextField field = new JTextField(2);
	public static int n;

	public FenetreLitEntier(String s) {
		super(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(text);
		getContentPane().add(field);
		field.addActionListener(this);
		pack();
	}
	public void actionPerformed(ActionEvent e) {
		n = Integer.parseInt(field.getText());
		dispose();
		FenetreCarre fen2 = new FenetreCarre("Carré Magique", FenetreLitEntier.n);
		fen2.setVisible(true);
	}
}
