package tp.model.agents;

import java.awt.Point;

public class FrelonEurop�en extends Frelons{

	//instanciation
	public FrelonEurop�en(Sexe sexe, Point coord) {
		super(sexe, coord);
		
		
		
	}
	
	public void seRencontrer(Animal a) {
		a.rencontrer(this);
			
		
	}
}
