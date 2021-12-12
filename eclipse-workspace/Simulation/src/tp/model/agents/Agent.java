package tp.model.agents;

import java.awt.Point;

/**
 * Cette classe modélise un Agent, c'est à dire un élément du monde qui est vivant ET 
 * qui peut interagir avec d'autres éléments de manière réciproque
 * Par exemple, une Abeille (qui butine une fleur) est un Agent
 * Une Fleur (qui produit et donne du nectar ou du pollen à une Abeille) est un Agent.
 * Une ruche, en revanche, n'est pas un agent (elle n'est pas vivante, elle ne produit rien).
 * @author bruno
 *
 */
public abstract class Agent {
	
	/* attributs de classe */
	private static int currentId = 0;
	
	/* attributs d'instance*/
	/** identifiant unique de l'animal*/
	private int id;
	/** age en unité de temps*/
	protected int age;
	/** position sur la carte*/
	
	
	//protected PointPositif coord;
	protected Point coord;
	
	protected boolean faim = false;
	
	
	public Agent(Point coord) {
		age = 0;
		id = Agent.getUniqueId();
		this.coord=coord;
		
		//this.coord=new PointPositif(coord);
	}
	
	public Agent() {
		this(new Point(0,0));
	}
	
	
	
	
	////////////////////////////////////
	//get set
	
	
	public boolean getFaim() {
		return faim;
	}
	
	public void setFaim(boolean niveauDeFaim) {
		this.faim = niveauDeFaim;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	
	public Point getCoord() {
		/*
		 * TP1
		
		Point p = new Point(new Point(coord.getX(),coord.getY()));
		return p;
		*/
		// ou TP2
		return (Point) coord.clone();
	}
	
	public void setCoord(int x, int y) {
		coord.setLocation(x, y);
		/* partie  3
		coord.setX(x);
		coord.setY(y);
		*/
	}
	
	
	public int getAge() {
		return this.age;
	}
	
	
	protected boolean setAge(int a) {
		boolean ret = false;
		if(a>age) {
			age = a;
			ret = true;
		}
		return ret;
	}
	
	private static int getUniqueId() {
		//TODO 
		Agent.currentId++;
		return currentId;
	}
	
	/////////////////////////////////////////////////////////
	//redefintion
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((coord == null) ? 0 : coord.hashCode());
		result = prime * result + id;
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
		Agent other = (Agent) obj;
		if (age != other.age)
			return false;
		if (coord == null) {
			if (other.coord != null)
				return false;
		} else if (!coord.equals(other.coord))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		//NomDeLaClasse n° id_agent (position x; position y)
		return getClass().getSimpleName() + " " + id + " (" + getCoord() + ")";
	}
	
	
	//changement de cycle
	//////////////////////////////////////
	
	public abstract void rencontrer(Agent a); 
	
	
	public void vieillir() {
		setAge(age+1);
	}
	

	
	protected void seNourrir() {
		System.out.println("j'ai faimmmmmmm");
	}
	
	
	protected void majDonnee() {// a faire
		
	}
	
	abstract public void seDeplacer();
	
	public final void cycle() {
		this.vieillir();
		this.seNourrir();
		this.seDeplacer();
		
	}
	
	/**
	 * 
	 * @param a
	 */
	//public abstract void rencontrer(Agent a); 
	
	
	
	/* comportements de classe */ 
	/**
	 * Renvoie un identifiant unique non encore utilisé
	 * @return un identifiant entier unique d'animal
	 */
	
}
