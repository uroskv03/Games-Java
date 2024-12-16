package lab3zad1;

import java.awt.Graphics;
import java.awt.Color;

public class Usisivac extends Figura {

	public Usisivac(int x, int y) {
		super(x, y);
	}

	@Override
	public int getRadius() {
		return 15;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		int x = this.getX();
		int y = this.getY();
		double a = Math.sqrt(3) * getRadius();
		int xPoints[] = {x,(int)(a/2+x),(int)(-a/2+x)};
		int yPoints[] = {y-getRadius(),y+getRadius(),y+getRadius()};
		g.fillPolygon(xPoints, yPoints, 3);
	}
	
	public int getOffset() {
		return getRadius() / 2;
	}
	
	
	
	

}
