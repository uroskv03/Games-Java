package lab3zad3;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figura {
	protected Scena scena;
	protected double x,y;
	protected Color boja;
	public Figura(Scena scena, int x, int y, Color boja) {
		super();
		this.x = x;
		this.y = y;
		this.boja = boja;
		this.scena = scena;
		scena.dodajFiguru(this);
	}
	
	public abstract char getOznaka();
	
	public void pomeri(int dx, int dy) {
		x+= dx;
		y+= dy;
	}
	
	public void unisti() {
		scena.ukloni(this);
	}
	
	public abstract void draw(Graphics  g);
	
	
}
