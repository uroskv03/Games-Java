package lab3zad3;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends Figura {
	private int visina, sirina;
	
	public Igrac(Scena scena, int x, int y,int visina, int sirina) {
		
		super(scena, x, y, Color.BLUE);
		this.visina = visina;
		this.sirina = sirina;
	}

	@Override
	public char getOznaka() {
		return 'I';
	}
	
	public int getVisina() {
		return visina;
	}

	public int getSirina() {
		return sirina;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(boja);
		g.fillRect((int)x-sirina/2, (int)y-visina/2, sirina, visina);

	}

}
