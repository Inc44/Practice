package tpNote2.Exercice2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MiniLLMApp extends JFrame implements ActionListener {
	private JTextField field = new JTextField(21);
	private JLabel text = new JLabel("Je ne sais pas repondre a cela.");
	private String str;
	private LLMEngine llm = new LLMEngine();
	public MiniLLMApp(String s) {
		super(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(2, 1));
		getContentPane().add(field);
		getContentPane().add(text);
		field.addActionListener(this);
		pack();
	}
	public void actionPerformed(ActionEvent e) {
		str = field.getText();
		if (llm.getAnswer(str) != null)
			str = llm.getAnswer(str);
		else
			str = "Je ne sais pas repondre a cela.";
		text.setText(str);
	}
}