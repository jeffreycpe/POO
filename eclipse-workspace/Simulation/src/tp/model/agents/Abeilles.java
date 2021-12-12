package tp.model.agents;

import java.awt.Point;

import tp.model.comportements.Hebergeur;

public class Abeilles extends Animal implements Hebergeur{
	
	//d�claration
	boolean peutAcceuil;
	boolean dejaAcceuil = false;
	int qteMiel = 0;
	private static final int qteMax = 10;
	
	//instanciation
	public Abeilles(Sexe sexe, Point coord) {
		super(sexe, coord);
	}
	
	
	//se rencontrer
	@Override
	public void rencontrer(Agent a) {
		/* rencontres */
		/* Accueil: ne pas coder ici
		 * c'est à l'animal rencontré d'appeler cette méthode
		 * 
		 * if(a instanceof Animal) {accueillir((Animal)a);}
		 */
		if(a instanceof Vegetal && qteMiel<Abeilles.qteMax) {
			Vegetal v = (Vegetal)a;
			qteMiel = qteMiel + v.getPortionNectar();
		}
		/* rencontre avec un prédateur */
		else if(a instanceof Frelons && getNiveauSante()!=Etat.Mourant) {
			setNiveauSante(Etat.EnDetresse);
			if (a.getFaim()) {setNiveauSante(Etat.Mourant);}
		}
	}

	
	@Override
	public boolean peutAccueillir(Animal a) {
		/*
		 * l'abeille n'a pas de parasite et l'animal est un Varroa
		 */
		return a instanceof Varroa && !dejaAcceuil;
	}

	@Override
	public boolean accueillir(Animal a) {
		boolean ret = false;
		if(peutAccueillir(a)) {
			dejaAcceuil = true;
			aggraverEtat();
			ret = true;
		}
		return ret;
	}
	

	@Override
	protected void majDonnee() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void seNourrir() {
		// TODO Auto-generated method stub
		
	}
		
	};
	
	
	

