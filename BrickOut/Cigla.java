package lab3zad3;

import java.awt.Color;
import java.awt.Graphics;

public class Cigla extends AktivnaFigura{
	private int sirina, visina;
	private boolean pogodjen = false;
	
	public Cigla(Scena scena,int x, int y,int vreme, int sirina,  int visina) {
		super(scena,x, y, Color.RED, vreme);
		this.sirina = sirina;
		this.visina = visina;
		thread.start();
	}

	public int getSirina() {
		return sirina;
	}

	public int getVisina() {
		return visina;
	}
	
	@Override
	protected void AzurirajPoziciju() {
		if(pogodjen) {
			y += 5;
			if(y> 600) {
				unisti();
			}
		}
	}
	
	@Override
	public char getOznaka() {
		return 'C';
	}
	
	public void pogodi() {
		boja = Color.GRAY;
		pogodjen = true;
	}

	public boolean isPogodjen() {
		return pogodjen;
	}
	
	

	@Override
	public void draw(Graphics g) {
		g.setColor(boja);
		g.fillRect((int)x-sirina/2, (int)y-visina/2, sirina, visina);
		
	}





}
