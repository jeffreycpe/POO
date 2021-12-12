package tp.model.agents;

import java.awt.Point;

public class Varroa extends Animal{

	//instanciation
	public Varroa(Sexe sexe, Point coord) {
		super(sexe, coord);
	}
	
	//rencontrer
	public void rencontrer(Agent a) {
		if (a instanceof Abeilles && this.hebergement==null) {
			Abeilles parasi = (Abeilles)a;
			parasiter(parasi);
			
		}
			
	}
	
	//parasister l'abeille
	public void parasiter(Abeilles a) {
		if(a.peutAccueillir(this)) {
			a.rencontrer(this);
			this.hebergement = a;
		}
	}
	
	@Override
	public void seDeplacer() {
		if (this.hebergement == null) {
			super.seDeplacer();
		} else {
			Abeilles a = (Abeilles)hebergement;
			Point newCoord = a.getCoord(); 
			this.setCoord(newCoord);
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
