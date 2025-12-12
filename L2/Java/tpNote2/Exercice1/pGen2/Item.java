package tpNote2.Exercice1.pGen2;

public class Item implements Priceable {
	private String label;
	private int prix;
	public Item(String label, int prix) {
		this.label = label;
		this.prix = prix;
	}
	@Override
	public int getPrix() {
		return this.prix;
	}
	@Override
	public String toString() {
		return "Item [label=" + label + ", prix=" + prix + "]";
	}
}