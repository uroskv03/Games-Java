package lab3zad1;

import java.awt.Graphics;
import java.awt.Color;

public class Kamencic extends Figura{
	
	public Kamencic(int x, int y) {
		super(x, y);
	}

	@Override
	public int getRadius() {
		return 5;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(getX() - getRadius(), getY() - getRadius(), 2 * getRadius(), 2 * getRadius());
	}

	
}
