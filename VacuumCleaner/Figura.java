package lab3zad1;

import java.awt.Graphics;

public abstract class Figura {
	private int x, y;
	
	public Figura(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public abstract int getRadius();

	public abstract void draw(Graphics g);
	
	public int getDistance(Figura f) {
		return (int) Math.sqrt(Math.pow(x - f.x, 2) + Math.pow(y - f.y, 2));
	}
	
	public boolean Preklapa(Figura f) {
		return getDistance(f) <= getRadius() + f.getRadius();
	}
	
	public boolean Obuhvata(Figura f) {
		return getRadius() <=  getDistance(f) + f.getRadius();
	}
	
	
	
	
	
}
