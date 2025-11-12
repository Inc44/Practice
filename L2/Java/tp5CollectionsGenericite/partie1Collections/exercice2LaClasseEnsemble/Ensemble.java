package tp5CollectionsGenericite.partie1Collections.exercice2LaClasseEnsemble;

import java.util.ArrayList;

public class Ensemble implements Cloneable {
	private ArrayList<Integer> elements;

	public Ensemble() {
		this.elements = new ArrayList<>();
	}

	public void ajoute(int a) {
		this.elements.add(a);
	}

	public int taille() {
		return this.elements.size();
	}

	public int getElement(int index) throws IndexOutOfBoundsException {
		// if (this.elements.size() < index)
		//	return -1;
		return this.elements.get(index);
	}

	public Ensemble union(Ensemble e) throws CloneNotSupportedException {
		Ensemble u = new Ensemble();

		for (int elt : this.elements) {
			if (!u.contains(elt))
				u.ajoute(elt);
		}
		// u.elements.addAll(this.elements);
		// Ensemble u = (Ensemble) this.clone();
		for (int elt : e.elements) {
			if (!u.contains(elt))
				u.ajoute(elt);
		}
		return u;
	}

	public Ensemble intersection(Ensemble e) {
		Ensemble u = new Ensemble();
		for (int elt : this.elements) {
			if (e.contains(elt) && !u.contains(elt))
				u.ajoute(elt);
		}
		return u;
	}

	public boolean contains(int elt) {
		return this.elements.contains(elt);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Ensemble u = new Ensemble();
		u.elements.addAll(this.elements);
		return u;
	}
}
