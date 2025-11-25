package tp8Swing.exercice1ExemplesDuCours;

import java.awt.Dimension;
import javax.swing.*;

public class MyFrame extends JFrame {
	public MyFrame() {
		JPanel panel = new JPanel();
		panel.add(new JButton("My button"));
		// add more elements if you like
		this.setContentPane(panel);
		this.setSize(new Dimension(400, 100));
		this.setTitle("A frame with a panel and one button");
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame();
	}
}
