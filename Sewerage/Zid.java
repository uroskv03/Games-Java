package lab3zad2;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Zid extends Kvadrat {

	public Zid() {
		super(new Color(170, 170, 170));
	}

	@Override
	public boolean mozeOznaciti() {
		return true;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

}
