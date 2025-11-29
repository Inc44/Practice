package tp8ExpressionLambdaSuite.exercice2TableauDEntiers;

class TupleInt {
	private int x;
	private int y;

	static int i = 0;

	TupleInt(int x, int y) {
		this.x = x;
		this.y = y;
	}
	int getX() {
		return x;
	}
	int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	@Override
	public boolean equals(Object obj) {
		TupleInt c = (TupleInt) obj;
		return c.x == this.x && c.y == this.y;
	}

	@Override
	public int hashCode() {
		// hashCode cours...
		return (int) (this.x + this.y * 31);
	}
}
