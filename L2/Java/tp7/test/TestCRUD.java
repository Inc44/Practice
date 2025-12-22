package tp7.test;

import java.util.ArrayList;
import tp7.dao.AbsenceDAO;
import tp7.dao.GroupeDAO;
import tp7.metier.Absence;
import tp7.metier.Etudiant;
import tp7.metier.Groupe;

public class TestCRUD {
	public static void main(String[] args) {
		GroupeDAO table_grp = new GroupeDAO();
		AbsenceDAO table_abs = new AbsenceDAO();

		String nomGroupe1 = "INFL2G1A";

		// charge et affiche le groupe INFL2G1A
		Groupe grp1A = table_grp.read(nomGroupe1);
		System.out.println("Chargement de " + nomGroupe1 + " : " + grp1A);
		// ajoute Hervé MORIN
		Etudiant nouvelEtu = new Etudiant("MORIN", "Herve", grp1A);
		// affiche le groupe
		System.out.println("Apres ajout de " + nouvelEtu + " : " + grp1A);
		// update base
		grp1A = table_grp.update(grp1A);
		// affiche groupe
		System.out.println("Apres enregistrement : " + grp1A);

		// charge le groupe INFL2G2A
		String nomGroupe2 = "INFL2G2A";
		Groupe grp2A = table_grp.read(nomGroupe2);
		System.out.println("Chargement de " + nomGroupe2 + " : " + grp2A);
		// change Herve MORIN de groupe
		grp1A.delEtudiant(nouvelEtu);
		grp2A.addEtudiant(nouvelEtu);
		System.out.println("Contenu de " + nomGroupe1 + " : " + grp1A);
		System.out.println("Contenu de " + nomGroupe2 + " : " + grp2A);
		// update base
		grp1A = table_grp.update(grp1A);
		grp2A = table_grp.update(grp2A);
		// affiche groupe
		System.out.println("Apres enregistrement : " + grp1A);
		System.out.println("Apres enregistrement : " + grp2A);
		String dtabs = "2023/11/12";
		String hrabs = "15:45";
		Absence abs = new Absence(dtabs, hrabs, nouvelEtu);
		table_abs.create(abs);
		System.out.println(abs);
		ArrayList<Absence> lesAbsences = table_abs.read(dtabs, hrabs);
		boolean trouve = false;
		if (lesAbsences != null) {
			for (Absence absence : lesAbsences) {
				if (absence.getEtudiant().getId() == nouvelEtu.getId()) {
					System.out.println("Found absence for " + nouvelEtu);
					trouve = true;
				}
			}
		}
		if (!trouve) {
			System.err.println("Not found");
		}
		table_abs.delete(abs);
	}
}
