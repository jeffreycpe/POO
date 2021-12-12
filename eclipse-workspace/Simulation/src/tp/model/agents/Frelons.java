package tp.model.agents;

import java.awt.Point;
import java.util.ArrayList;

public class Frelons extends Animal {

	protected ArrayList<Class<? extends Animal>> proies;
	//instanciation
	public Frelons(Sexe sexe, Point coord) {
		super(sexe, coord);
		proies = new ArrayList<Class<? extends Animal>>();
		/*
		 * TODO: ajouter l'objet Class qui représente la classe Abeille à la liste proie
		 */
		
	}
	
	@Override
	public void rencontrer(Agent a) {
		try {
			gestionProie((Animal)a);
		}
		catch (ClassCastException cce) {
			System.err.println(a+" n'est pas un Animal");
		}
		
	}
	
	protected void gestionProie(Animal a) {
		//si le frelon a faim et 
		// TODO: qu'il a bien affaire à une proie, c'est à dire que la classe de a 
		// appartient bien à la liste proies
		// supprimer le instanceof et remplacer par cette vérification
		if(faim && a instanceof Abeilles) {
			faim=false;
		}
	}
	
	@Override
	protected void majDonnee() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void seNourrir() {
		// TODO Auto-generated method stub
		
	}
}
