package lab3zad2;

import java.awt.Graphics;


@SuppressWarnings("serial")
public class GoreDoleCev extends Cev {
	
	public GoreDoleCev() {
		super();
	}

	@Override
	protected void drawUnutrasnjost(Graphics g) {
		int a = 75;
		g.fillRect(a*1/4 , 0, a*1/2 , a);
	}

	@Override
	protected void drawIvica(Graphics g) {
		int a = 75;
		g.drawLine(a*1/4 , 0, a*1/4 , a);
		g.drawLine(a*3/4 , 0, a*3/4 , a);
		
	}

	@Override
	protected void drawUsmerenje(Graphics g) {
		int a = 75;
		int y = a*3/4 ;
		int x = a*1/2 ;
		int y0 = a*1/4 ;
		g.drawLine(x, y0, x, y);
		int[] yPoints = {y,y+10,y};
		int[] xPoints = {x+4,x,x-4};
		g.fillPolygon(xPoints, yPoints, 3);	
	}
}
