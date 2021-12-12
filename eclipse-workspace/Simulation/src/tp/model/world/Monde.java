package tp.model.world;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import tp.model.agents.AbeilleDomestique;
import tp.model.agents.AbeilleSolitaire;
import tp.model.agents.Agent;
import tp.model.agents.Arbre;
import tp.model.agents.Fleur;
import tp.model.agents.FrelonAiatique;
import tp.model.agents.FrelonEurop�en;
import tp.model.agents.Sexe;
import tp.model.agents.Varroa;
import tp.model.comportements.Ruches;

public class Monde {
	/**
	 * population d'agents dans le monde
	 */
	private Set<Agent>agents;
	/**
	 * map de probabilité pour trouver un agent
	 */
	private static final Map<Integer,Agent> proba= Monde.probaAgent();
	/**
	 * constante: largeur du monde
	 */
	private static int LARGEUR = 30;
	/**
	 * constante: longueur du monde
	 */
	private static int LONGUEUR = 20;
	
	/**
	 * 
	 * @param nbAgents
	 */
	
	public Monde(int nbAgents) {
		agents=generateAgents(nbAgents);
	}
	
	/**
	 * Méthode utilitaire statistique pour produire la table de proba
	 * d'apparition d'un agent
	 * @return
	 */
	private static Map<Integer, Agent> probaAgent() {
		Ruches r1 =new Ruches(new Point(10,50));
		Ruches r2 =new Ruches(new Point(100,20));
		Map<Integer,Agent> myMap = new LinkedHashMap<Integer,Agent>();
	    //myMap.put(20,new AbeilleDomestique(Sexe.assexue,new Point(0,0),r1));
	    //myMap.put(40,new AbeilleDomestique(Sexe.assexue,new Point(0,0),r2));
		myMap.put(20,new AbeilleDomestique(Sexe.assexue,new Point(0,0)));
	    myMap.put(40,new AbeilleDomestique(Sexe.assexue,new Point(0,0)));
	    myMap.put(50,new AbeilleSolitaire(Sexe.assexue,new Point(0,0)));
	    myMap.put(55,new FrelonEurop�en(Sexe.assexue,new Point(0,0)));
	    myMap.put(60,new FrelonAiatique(Sexe.assexue,new Point(0,0)));
	    myMap.put(70,new Varroa(Sexe.assexue,new Point(0,0)));
	    //myMap.put(80,new Arbre(new Point(0,0),1.0));
	    //myMap.put(85,new Arbre(new Point(0,0),2.0));
	    myMap.put(80,new Arbre(new Point(0,0)));
	    myMap.put(85,new Arbre(new Point(0,0)));
	    //myMap.put(100,new Fleur(new Point(0,0)));
	    return myMap;
	}
	
	/**
	 * fabrication aléatoire d'un Agent par tirage dans la Map
	 * et positionnement aléatoire
	 * @param alea
	 * @return
	 */
	private static Agent tirage(int alea) {
		/*
		 * NE PAS TOUCHER!
		 */
		Agent agent=null;
		if(alea<100 && alea>=0) {
			boolean trouve = false;
			Iterator<Integer> it = proba.keySet().iterator();
			while(!trouve && it.hasNext()) {
				Integer clef = it.next();
				if(clef>=alea) {
					agent = proba.get(clef);
					trouve=true;
				}
			}
		}
		else {
			agent = new Fleur(new Point(0,0));
		}
		//positionnement aléatoire entre Longueur et Largeur
		int aleaX = (int)(Math.random()*LONGUEUR);
		int aleaY = (int)(Math.random()*LONGUEUR);
		agent.setCoord(aleaX, aleaY);
		return agent;
	}

	private TreeSet<Agent> generateAgents(int nbAgents) {
			/*
			 * NE PAS TOUCHER!
			 */
		TreeSet<Agent> ts = new TreeSet<Agent>();
		for(int i=0;i<nbAgents;i++) {
			int alea = (int)(Math.random()*100);
			//partie 2
			//ts.add((Agent)tirage(alea).clone());
			//partie 1
			ts.add(copieAgent(tirage(alea)));
		}
		return ts;
	}
	/**
	 * à supprimer dès la partie deux lorsqu'il devient possible de
	 * cloner les agents
	 * place toutes les abeilles dans la même ruche
	 * les arbres ont tous la même taille
	 * ne respecte pas les bonnes pratiques (switch case sur le type) 
	 * @param tirage
	 * @return
	 */
	private Agent copieAgent(Agent tirage) {
		// TODO Auto-generated method stub
		Ruches ruche =new Ruches(new Point(10,50));
		Agent ret = null;
		String classeAgentName = tirage.getClass().getSimpleName();
		switch(classeAgentName) {
			case "AbeilleDomestique":
				AbeilleDomestique ad = (AbeilleDomestique) tirage;
				//ret = new AbeilleDomestique(ad.getSexe(),ad.getCoord(),ruche);
				ret = new AbeilleDomestique(ad.getSexe(),ad.getCoord());
				break;
			case "AbeilleSolitaire":
				AbeilleSolitaire as = (AbeilleSolitaire) tirage;
				ret = new AbeilleSolitaire(as.getSexe(),as.getCoord());
				break;
			case "FrelonEuropeen":
				FrelonEurop�en fe = (FrelonEurop�en) tirage;
				ret = new FrelonEurop�en(fe.getSexe(),fe.getCoord());
				break;
			case "FrelonAsiatique":
				FrelonAiatique fa = (FrelonAiatique) tirage;
				ret = new FrelonAiatique(fa.getSexe(),fa.getCoord());
				break;
			case "Varroa":
				Varroa v = (Varroa) tirage;
				ret = new Varroa(v.getSexe(),v.getCoord());
				break;
			case "Arbre":
				Arbre a = (Arbre) tirage;
				//ret = new Arbre(a.getCoord(),1.0);
				ret = new Arbre(a.getCoord());
				break;
			default:
				Fleur f = (Fleur) tirage;
				ret = new Fleur(f.getCoord());
				break;
		}
		return ret;
	}

	public String toString() {
		String ret="";
		ret+="******************************\n";
		ret+="Le monde contient "+agents.size()+" agents:\n";
		/*
		 * TODO
		Set<Agent> coordSet = new TreeSet<Agent>(new CoordComparator());//TODO
		coordSet.addAll(agents);
		*/
		for(Agent a:agents) {
			ret+="\t"+a+"\n";
		}
		return ret;
	}

	/**
	 * génère un cycle de vie dans le monde
	 */
	public void cycle() {
		/*
		 * TODO appeler la méthode cycle sur tous les agents		
		 */
	}
	
	

}
