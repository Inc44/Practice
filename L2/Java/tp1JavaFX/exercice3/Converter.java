package tp1JavaFX.exercice3;

public class Converter {
	private double rate = 120.2;
	private String currency1Name = "EUR";
	private String currency2Name = "JPY";
	public String getCurrency1Name() {
		return currency1Name;
	}
	public void setCurrency1Name(String currency1Name) {
		this.currency1Name = currency1Name;
	}
	public String getCurrency2Name() {
		return currency2Name;
	}
	public void setCurrency2Name(String currency2Name) {
		this.currency2Name = currency2Name;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double currency1To2(double currency) {
		return currency * rate;
	}
	public double currency2To1(double currency) {
		return currency / rate;
	}
}