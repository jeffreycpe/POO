package tp.model.agents;

import java.awt.Point;

public abstract class Vegetal extends Agent {

	//variable instance
	protected int qteNectar = 0;
	int pollen;
	
	//instanciation
	public Vegetal(Point coord, int nectar, int pollen) {
		super(coord);
		this.qteNectar = nectar;
		this.pollen = pollen;
		
	}
	
	public abstract void produire();
	@Override
	public void rencontrer(Agent a) {
		// TODO Auto-generated method stub

	}
	
	public void seDeplacer() {
		
	}
	
	
	@Override
	protected void majDonnee() {
		// TODO Auto-generated method stub
		
	}
	
	public int getPortionNectar() {
		int ret = 0;
		if(qteNectar>0) {
			ret = 1;
			qteNectar--;
		}
		return ret;
	}
}
