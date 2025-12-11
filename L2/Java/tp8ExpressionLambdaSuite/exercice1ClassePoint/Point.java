package tp8ExpressionLambdaSuite.exercice1ClassePoint;

class Point {
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	private int x, y;
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	@Override
	public boolean equals(Object obj) {
		Point c = (Point) obj;
		return c.x == this.x && c.y == this.y;
	}
	@Override
	public int hashCode() {
		return (int) (this.x + this.y * 31);
	}
}