package tp.model.agents;

import java.awt.Point;

import tp.model.comportements.Hebergeur;

public class Arbre extends Vegetal implements Hebergeur {
	
	//variable instance 
	
	private double taille = 1.0;
	private int nbHeberges = 0;
	
	
	//Instanciation
	public Arbre(Point coord, int nectar, int pollen, double taille) {
		super(coord, nectar, pollen);
		this.taille=taille;
	}
	
	public Arbre(Point coord) {
		this(coord, 0,0,1.0);
	}
	
	
	

	@Override
	public boolean peutAccueillir(Animal a) {
		return (a instanceof AbeilleSolitaire || a instanceof Frelons)&&nbHeberges<getMaxHeberges();
	}

	private int getMaxHeberges() {
		return (int)(Math.pow(taille,2));
	}

	@Override
	public boolean accueillir(Animal a) {
		boolean ret = false;
		if(peutAccueillir(a)) {
			nbHeberges++;
			ret=true;
		}
		return ret;
	}

	@Override
	public void produire() {
		qteNectar += Math.pow(2, taille);		
	}
	
	
}
