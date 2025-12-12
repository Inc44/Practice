package tpNote2.Exercice1.pGen1;

import java.util.HashMap;
import java.util.Set;

public class Commande<Article> {
	private int date;
	private HashMap<Article, Integer> lesArticles;
	public Commande(int date) {
		this.date = date;
		this.lesArticles = new HashMap<Article, Integer>();
	}
	public void ajouterArticle(Article a, int quantite) {
		if (this.lesArticles.containsKey(a))
			this.lesArticles.replace(a, quantite);
		else
			this.lesArticles.put(a, quantite);
	}
	@Override
	public String toString() {
		String articleString = "Les articles : \n";
		Set<Article> lesCles = this.lesArticles.keySet();
		for (Article cle : lesCles) {
			articleString = articleString + cle + " : " + lesArticles.get(cle) + "\n";
		}
		return articleString;
	}
	public HashMap<Article, Integer> getArticles() {
		return this.lesArticles;
	}
}