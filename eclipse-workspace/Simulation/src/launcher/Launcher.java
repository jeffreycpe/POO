package launcher;

import java.awt.Point;

import tp.model.agents.AbeilleDomestique;
import tp.model.agents.FrelonAiatique;
import tp.model.agents.FrelonEurop�en;
import tp.model.agents.Sexe;
import tp.model.agents.Varroa;

/**
 * Cette classe modÃ©lise un Animal dans la simulation
 * @author bruno
 *
 */
public class Launcher {
	public static void main(String args[]) {
		
		
		
		/*
		Monde m = new Monde(50);
		System.out.println(m);
		m.cycle();
		System.out.println(m);
		*/
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		AbeilleDomestique a = new AbeilleDomestique(Sexe.Femelle,new Point(25,30));
		FrelonAiatique b = new FrelonAiatique(Sexe.Femelle,new Point(25,30));
		Varroa c = new Varroa(Sexe.Femelle,new Point(25,30));
		FrelonEurop�en d = new FrelonEurop�en(Sexe.Femelle,new Point(25,30));
		
		System.out.println(a.getEtat());
		a.ameliorerEtat();
		System.out.println(a.getEtat());
		a.ameliorerEtat();
		System.out.println(a.getEtat());
		a.ameliorerEtat();
		System.out.println(a.getEtat());
		
		
		
		
		
		//a.cycle();
		//System.out.println(b.getCoord());
		
		
		
		
		
		
		
		//tests unitaires de la classe Animal
		//TODO dÃ©commentez les lignes pour approfondir le test unitaire
		//complÃ©tez la mÃ©thode pour tester les nouvelles fonctionnalitÃ©s que vous allez implÃ©menter
		//Animal a = new Animal();
		//Animal b = new Animal(Sexe.Male);
		//Animal c = new Animal(Sexe.Assexue);
		//Animal d = new Animal(Sexe.Femelle,new Point(25,30));
		//Animal e = new Animal(Sexe.Femelle,new Point(25,30));
		
		/*
		 * les lignes suivantes doivent afficher Ã  terme: NomDeLaClasse nÂ° id_animal(sexe, (position x; position y)).
		 * ex: 28 (FEMELLE, (25;30))
		 */
		
		
		
		/*
		System.out.println("*** Animaux crées: **********");
		System.out.println(a);
		System.out.println(a.toString());
		System.out.println(b);
		//System.out.println(c);
		d.setAge(25);
		System.out.println(d.getAge());
		
		*/
		
		
		/*
		
		System.out.println("*** Getters et setters **********");
		
		System.out.println(d.getSexe());
		Sexe ss = d.getSexe();
		ss=Sexe.Male;
		System.out.println(d.getSexe());
		
		*/
		
		
		
		
		
		
		//les lignes suivantes devraient afficher la mÃªme chose....
		
		
		
		
		/*
		System.out.println(d.getCoord());
		Point pt = d.getCoord();
		pt.x=50;    //Il considère que le return est la même variable donc la on modife la vriable de base cd pointeur
		System.out.println(d.getCoord());
		
		*/
		
		//TODO ajoutez vos propres tests de getters et setters
		
		//TODO test vieillir
		
		//TODO test seDeplacer
		
		//TODO test id
		
		
		/*
		System.out.println(a.getId());
		System.out.println(b.getId());
		*/
		
		
		
		
		
		
		
		/*
		 * Test comparaison
		 */
		
		
		/*
		System.out.println(d==e);
		System.out.println(d.equals(e));
		System.out.println("Bonjour"=="Bonjour"); //censé être faux car addresse différentes  => f	ux pour objet
		System.out.println("Bonjour".equals("Bonjour"));
		
		System.out.println(a.getCoord());	
		a.seDeplacer();
		System.out.println(a.getCoord());	
		
		*/
		//printClassName(a);
		
		//System.out.println(a.toString());
	}

	
}

	
	
               
