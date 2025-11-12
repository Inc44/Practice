package tp5CollectionsGenericite.partie2Genericite.exercice2TripletHybride;

public class TripletHybride<E, T, S> {
	private E first;
	private T second;
	private S third;

	public TripletHybride(E first, T second, S third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}

	/**
	 * @return the first
	 */
	public E getFirst() {
		return first;
	}

	/**
	 * @return the second
	 */
	public T getSecond() {
		return second;
	}

	/**
	 * @return the third
	 */
	public S getThird() {
		return third;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TripletHybride [first=" + first + ", second=" + second + ", third=" + third + "]";
	}
}
