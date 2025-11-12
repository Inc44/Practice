package tp5CollectionsGenericite.partie2Genericite.exercice3EnsembleGenerique;

import java.util.ArrayList;

public class EnsembleGenerique<E> implements Cloneable {
	private ArrayList<E> elements;

	public EnsembleGenerique() {
		this.elements = new ArrayList<>();
	}

	public void ajoute(E a) {
		this.elements.add(a);
	}

	public int taille() {
		return this.elements.size();
	}

	public E getElement(int index) throws IndexOutOfBoundsException {
		return this.elements.get(index);
	}

	public EnsembleGenerique union(EnsembleGenerique e) throws CloneNotSupportedException {
		EnsembleGenerique u = new EnsembleGenerique();
		u.elements.addAll(this.elements);
		u.elements.addAll(e.elements);

		return u;
	}

	public EnsembleGenerique intersection(EnsembleGenerique e) {
		EnsembleGenerique u = new EnsembleGenerique();
		for (E elt : this.elements) {
			if (e.contains(elt))
				u.ajoute(elt);
		}
		return u;
	}

	public boolean contains(E elt) {
		return this.elements.contains(elt);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		EnsembleGenerique u = new EnsembleGenerique();
		u.elements.addAll(this.elements);
		return u;
	}
}
