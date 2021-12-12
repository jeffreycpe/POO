package tp.model.agents;

import java.awt.Point;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import tp.model.comportements.Deplacable;
import tp.model.comportements.Hebergeur;

/**
 * Cette classe modÃ©lise un Animal dans la simulation
 * @author bruno
 *
 */
public abstract class Animal extends Agent implements Deplacable{
	/* attributs de classe */
	//private static int currentId = 0;
	
	/* attributs d'instance*/
	/** identifiant unique de l'animal*/
	//private int id;
	/** age en unitÃ© de temps*/
	//private int age;
	/** position sur la carte*/
	//private Point coord;
	/** Ã©tat de santÃ© de l'animal */
	private Etat etat=Etat.Normal;
	private Sexe sexe;
	
	
	Hebergeur hebergement;
	
	
	
	/* 
	 * constructeurs 
	 */
	
	
	///////////////////////////////////////////////////////
	public Animal(Sexe sexe, Point coord) {
		super();
		age = 0; //On peutr mettre this pour que ca soit plus clair
		
		this.sexe=sexe;
		//this.coord=co
		this.coord=new Point(coord);
		
	}
	
	public Animal(Sexe sexe) {
		//TODO
		
		this(sexe, new Point(0,0));
		/* crÃ©e un animal avec le sexe passÃ© en paramÃ¨tre, Ã  la position (0;0), d'Ã¢ge 0 et lui attribue un id unique
		 * une bonne maniÃ¨re de faire 
		 * en utilisant ce qui existe dÃ©jÃ , une moins bonne
		 */
	}
	
	public Animal() {
		//TODO
		this(Sexe.Femelle, new Point(0,0)); //2 paramères comme l'objet le plus fournis
		
	}
	
	/*
	 *  Accesseurs et mutateurs
	 */
	
	public Hebergeur getHebergement() {
		return this.hebergement;
	}

	public void setHebergement(Hebergeur heberg) {
		this.hebergement = heberg;
	}
	
	
	
	
	
	public void setCoord(Point coord) {
		
		this.coord = coord;
	}



	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}
	
	
	
	public Etat getNiveauSante() {return etat;}
	/**
	 * protected, car seul l'animal doit pouvoir changer son niveau de santé
	 * @return
	 */
	protected void setNiveauSante(Etat e) {etat = e;}
	/*
	 * (non-Javadoc)
	 * @see complet.model.agents.Agent#toString()
	 */

	///////////////////////////////////////////////////////////////
	
	
	//cycle
	
	public void seDeplacer() {
		//TODO utiliser Math.random() pour choisir une direction de dÃ©placement
		
		int Min = -1;
		int Max = 1;
		int dx =  Min + (int)(Math.random() * ((Max - Min) + 1));
		int dy = Min + (int)(Math.random() * ((Max - Min) + 1));
		
		Point newCoord=new Point(this.coord.x + dx, this.coord.y + dy);
		setCoord(newCoord);
	}
	
	
	//abstract public void seRencontrer(Animal a);
	
	
	@Override
	public String toString() {
		
		return super.toString() + "age : " + this.getAge();
		//return getClass().getSimpleName() + " " + getId() + " (" + getCoord() + "age : " + getAge() + ")";
	}

	
	static void printClassName(Object obj) {
        System.out.println("The class of " + obj +
                           " is " + obj.getClass().getName());
    }

	
	
	
	//////////////////////////////////////
	//METHODE DE CLASSE
	//////////////////////////////////////
	
	protected final boolean sInstaller(Hebergeur h) {
		boolean ret=false;
		if(h!= null && h.accueillir(this)) {
			hebergement = h;
			ret=true;
		}
		return ret;
	}
	
	
	
	protected final void aggraverEtat() {
		/* détail sur plusieurs lignes de:
		 * 	LinkedList<Etat> liste = new LinkedList<Etat>(Arrays.asList(Etat.values()));

		Etat[] tableauEtat = Etat.values();
		List<Etat> listeEtat = Arrays.asList(tableauEtat);
		LinkedList<Etat> liste = new LinkedList<Etat>(listeEtat);
		*/
		LinkedList<Etat> liste = new LinkedList<Etat>(Arrays.asList(Etat.values()));
		// ArrayList<Etat> liste = new ArrayList<Etat>(Arrays.asList(Etat.values()));
		/* détail de
		 * Iterator<Etat> it = liste.listIterator(liste.indexOf(etat));
		 
		int indexEtatActuel = liste.indexOf(this.etat); (inutile avec l'algo suivant)
		Iterator<Etat> it = liste.listIterator();
		boolean trouve = false;
		while(it.hasNext() && !trouve) {
			if(it.next().equals(this.etat)) {trouve=true;}
		}
		*/
		Iterator<Etat> it = liste.listIterator(liste.indexOf(this.getNiveauSante()));
		it.next(); //?????????????
		
		
		if(it.hasNext()) {this.setNiveauSante(it.next());}	
		
	}
	
	public final void ameliorerEtat() {
		LinkedList<Etat> liste = new LinkedList<Etat>(Arrays.asList(Etat.values()));
		Collections.reverse(liste);
		Iterator<Etat> it = liste.listIterator(liste.indexOf(this.getNiveauSante())); 
		//Iterator<Etat> it = liste.listIterator(liste.indexOf(etat));
		it.next();
		if(it.hasNext()) {etat = it.next();}	
		
	}
}




/*
age = 0;
id = Animal.getUniqueId();
sexe = Sexe.Femelle;
coord = new Point(0,0);
*/


/* crÃ©e un animal de sexe femelle, Ã  la position (0;0), d'Ã¢ge 0 et lui attribue un id unique
 * une bonne maniÃ¨re de faire 
 * en utilisant ce qui existe dÃ©jÃ , une moins bonne
 */

/* comportements de classe */ 
/**
 * Renvoie un identifiant unique non encore utilisÃ©
 * @return un identifiant entier unique d'animal
 */


/*

private static int getUniqueId() {
	//TODO 
	int id = currentId;
	currentId++;  //Il sauvegarde puis incrémente la nouvelle valeur 
	
	
	return id;
}

*/

/*

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + age;
	result = prime * result + ((etat == null) ? 0 : etat.hashCode());
	result = prime * result + ((sexe == null) ? 0 : sexe.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Animal other = (Animal) obj;
	if (age != other.age)
		return false;
	if (etat != other.etat)
		return false;
	if (sexe != other.sexe)
		return false;
	return true;
}


*/










//TODO

	/////////////////////////////////////////////////////////
	
	//get set
	
	
	

	/*
	public Point getCoord() {
		//Point p = new Point(this.coord);  //=> ctrl space permet de voir, on luit met un new point
		//return p;    // Il retourne un pointeur our type construit seulment => modifiable en dehors de la fonction
		
		return (Point) this.coord.clone();
	}
*/



/*
private void setAge(int newAge) { //Pas en statique 
	this.age = newAge;
}


*/


/*

 * RedÃ©finitions de mÃ©thodes d'object
 */
//TODO


/* 
 * comportements d'instance
 */



/*
public void vieillir() {
	//TODO fait vieillir l'animal d'une unitÃ© de temps
	//une bonne maniÃ¨re de faire, une moins bonne...
	
	
	//manière brute
	//this.age++;
	
	//bonne pratique securisé utiliser setAge
	int newAge = getAge() + 1;
	setAge(newAge);
}
*/


/*
public void rencontrer(Animal a) {
	//TODO
}


*/
