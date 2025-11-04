package tp4Exceptions.exo1;

public class Value {
	private String name;
	private int value;

	public Value(String n, int v) {
		this.name = n;
		this.value = v;
	}
	public String toString() {
		return "<" + this.name + "; " + this.value + ">";
	}
}