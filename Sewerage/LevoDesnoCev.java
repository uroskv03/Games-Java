package lab3zad2;

import java.awt.Graphics;

@SuppressWarnings("serial")
public class LevoDesnoCev extends Cev {
	
	public LevoDesnoCev() {
		super();
	}

	@Override
	protected void drawUnutrasnjost(Graphics g) {
		int a = 75;
		g.fillRect(0, a*1/4, a, a*1/2);
		
	}	

	@Override
	protected void drawIvica(Graphics g) {
		int a = 75;
		g.drawLine(0, a*1/4, a, a*1/4);
		g.drawLine(0, a*3/4, a, a*3/4);
		
	}

	@Override
	protected void drawUsmerenje(Graphics g) {
		int a = 75;
		int x = a*3/4;
		int y = a*1/2;
		int x0 = a*1/4;
		g.drawLine(x0, y, x, y);
		int[] xPoints = {x,x+10,x};
		int[] yPoints = {y+4,y,y-4};
		g.fillPolygon(xPoints, yPoints, 3);	
	}
}
