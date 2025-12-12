package tpNote2.Exercice2;

import java.util.HashMap;
import java.util.Map;

public class LLMEngine {
	private Map<String, String> responses;
	public LLMEngine() {
		this.responses = new HashMap<String, String>();
		this.setAnswer("Bonjour", "Salut a toi !");
		this.setAnswer("Comment ca va ?", "Je vais bien, merci.");
		this.setAnswer("Quelle est la capitale de la France ?", "Paris, bien sur !");
	}
	public void setAnswer(String question, String answer) {
		this.responses.put(question, answer);
	}
	public String getAnswer(String question) {
		return this.responses.get(question);
	}
}