package tp.model.agents;

import java.awt.Point;

public class Fleur extends Vegetal {

	int pollen = 0;
	
	public Fleur(Point coord, int nectar, int pollen) {
		super(coord, nectar, pollen);
	}
	
	public Fleur(Point coord) {
		this(coord, 0,0);
	}
	
	@Override
	public final void majDonnee() {
		this.majDonnee();
		this.pollen++;
		
	}
	
	
	@Override
	public void produire() {
		qteNectar+=1;
	}
}
