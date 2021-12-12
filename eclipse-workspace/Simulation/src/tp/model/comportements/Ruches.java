package tp.model.comportements;

import java.awt.Point;

import tp.model.agents.AbeilleDomestique;
import tp.model.agents.Animal;

public class Ruches extends Decor implements Hebergeur {
	//varaible de classe
	int miel;
	private static int populationMax = 1000;
	
	//instanciation
	public Ruches(Point coord) {
		super(coord);
		}
	
	
	public boolean peutAccueillir(Animal a) {
		return a instanceof AbeilleDomestique; /*&& 
				&& //population ok
				//l'abeille n'appartient pas déjà à la ruche
				 */
	}

	@Override
	public boolean accueillir(Animal a) {
		boolean ret = false;
		if(peutAccueillir(a)) {
			/* Ne pas faire ça ici: c'est à l'animal de mettre à jour ses attributs
			 * a.setHebergeur(this);
			 */
			//TODO ajouter a à la population
			ret=true;
		}
		return ret;
	}
	
	public String toString() {
		String ret ="TODO";
		/*
		 * "\t" code une tabulation dans une chaine de caractères
		 * "\n" un saut de ligne 
		 */
		return ret;
	}
	
	public static void main(String[] a) {
		/*
		Ruche r = new Ruche(new Point(0,0));
		new AbeilleDomestique(Sexe.Assexue, new Point(10,20),r);
		System.out.println(r);
		new AbeilleDomestique(Sexe.Assexue, new Point(10,20),r);
		System.out.println(r);
		new AbeilleDomestique(Sexe.Femelle, new Point(5,10),r);
		System.out.println(r);
		*/
	}
}
