package lab3zad2;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public abstract class Cev extends Kvadrat {

	public Cev() {
		super(new Color(170, 170, 170));
	}

	@Override
	public boolean mozeOznaciti() {
		return true;
	}

	@Override
	public void paint(Graphics g) {
		//pomPaint(g);
		super.paint(g);
		g.setColor(new Color(204,204,204));
		drawUnutrasnjost(g);
		g.setColor(Color.BLACK);
		drawIvica(g);
		drawUsmerenje(g);
	}
	
	protected abstract void drawUnutrasnjost(Graphics g);
	
	protected abstract void drawIvica(Graphics g);
	
	protected abstract void drawUsmerenje(Graphics g);
	

}
