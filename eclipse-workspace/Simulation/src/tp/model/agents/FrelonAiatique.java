package tp.model.agents;

import java.awt.Point;

public class FrelonAiatique extends Frelons {

	//instanciation
		public FrelonAiatique(Sexe sexe, Point coord) {
			super(sexe, coord);
		}
		
		
		
		public void seRencontrer(Animal a) {
			if(a instanceof FrelonEuropéen) {
				this.setEtat(Etat.EnDetresse);
			} else {
				a.rencontrer(this);
				}
			
		}
}
