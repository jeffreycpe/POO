package tp.model.comportements;

import java.awt.Point;

import tp.model.agents.Agent;

public abstract class Decor {
	
	//variable de classe
	Point coord;
	
	//instanciation
	public Decor(Point coord) {
		this.coord=coord;
		
	}
	
	public Point getCoord() {
		return new Point(coord);
	}

}
