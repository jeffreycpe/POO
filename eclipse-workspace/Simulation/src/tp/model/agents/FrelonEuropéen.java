package tp.model.agents;

import java.awt.Point;

public class FrelonEuropéen extends Frelons{

	//instanciation
	public FrelonEuropéen(Sexe sexe, Point coord) {
		super(sexe, coord);
		
		
		
	}
	
	public void seRencontrer(Animal a) {
		a.rencontrer(this);
			
		
	}
}
