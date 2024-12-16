package lab3zad2;

import java.awt.Graphics;


@SuppressWarnings("serial")
public class GoreDesnoCev extends Cev {
	
	public GoreDesnoCev() {
		super();
	}

	@Override
	protected void drawUnutrasnjost(Graphics g) {
		int a = 75;
		g.fillRect(a*1/4 , 0, a*1/2 , a*3/4 );
		g.fillRect(a*1/4 , a*1/4 , a*3/4 , a*1/2 );
	}

	@Override
	protected void drawIvica(Graphics g) {
		int a = 75;
		g.drawLine(a*1/4 , 0, a*1/4 , a*3/4 );
		g.drawLine(a*1/4 , a*3/4 , a, a*3/4 );
		g.drawLine(a*3/4 , 0, a*3/4 , a*1/4 );
		g.drawLine(a*3/4 , a*1/4 , a, a*1/4 );	
	}

	@Override
	protected void drawUsmerenje(Graphics g) {
		int a = 75;
		int x0 = a*1/2 ;
		int y0 = a*1/4 ;
		int x = a*3/4 ;
		int y = a*1/2 ;
		g.drawLine(x0, y0, x0, y);
		g.drawLine(x0, y, x, y);
		int[] xPoints = {x,x+10,x};
		int[] yPoints = {y+4,y,y-4};
		g.fillPolygon(xPoints, yPoints, 3);
	}
}