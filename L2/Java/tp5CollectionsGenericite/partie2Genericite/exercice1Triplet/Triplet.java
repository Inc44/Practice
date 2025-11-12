package tp5CollectionsGenericite.partie2Genericite.exercice1Triplet;

public class Triplet<E> {
	private E first;
	private E second;
	private E third;

	public Triplet(E first, E second, E third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}

	public E getFirst() {
		return first;
	}

	public E getSecond() {
		return second;
	}

	public E getThird() {
		return third;
	}

	@Override
	public String toString() {
		return "Triplet [first=" + first + ", second=" + second + ", third=" + third + "]";
	}
}
