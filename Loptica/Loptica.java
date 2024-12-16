package lab3zad3;

import java.awt.Color;
import java.awt.Graphics;

//import java.util.Random;

public class Loptica extends AktivnaFigura {
	private int poluprecnik;
	private double dx, dy;
	private int brAzuriranja;
	
	public Loptica(Scena scena,int x, int y,int vreme, int poluprecnik) {
		
		super(scena,x, y, Color.GREEN, vreme);
		this.poluprecnik = poluprecnik;
		pocetnaBrzina();
		thread.start();
	}
	
	private void pocetnaBrzina() {
		dx = -1 + Math.random()*2;
		dy = -Math.random();
		
	}
	
	
	@Override
	protected void AzurirajPoziciju() {
		x+= dx;
		y+= dy;
		brAzuriranja++;
		if(brAzuriranja % 100 ==0) {
			dx *= 1.1;
			dy *= 1.1;
		}

		synchronized(scena) {
			Figura f;
			for(int i = 0; (f = scena.dohvatiFiguruIndex(i))!= null; i++ ) {
				boolean pogodjenIgrac = false;
				switch(f.getOznaka()) {
				case('C'):
					Cigla c = (Cigla) f;
					
					if(c.isPogodjen()) continue;
					if( (x <= c.x + c.getSirina()/2 + poluprecnik) && 
							(x >= c.x - c.getSirina()/2 + poluprecnik) && 
							(y <= c.y + c.getVisina()/2) &&
							(y >= c.y - c.getVisina()/2)) {
						dx*= -1;
						c.pogodi();
					} else {
						if( (x <= c.x + c.getSirina()/2 - poluprecnik) && 
								(x >= c.x - c.getSirina()/2 - poluprecnik) && 
								(y <= c.y + c.getVisina()/2) &&
								(y >= c.y - c.getVisina()/2)) {
							dx*= -1;
							c.pogodi();
						}

					}
					if( (y <= c.y + c.getVisina()/2 + poluprecnik) && 
							(y >= c.y - c.getVisina()/2 + poluprecnik) && 
							(x <= c.x + c.getSirina()/2) &&
							(x >= c.x - c.getSirina()/2)) {
						dy*= -1;
						c.pogodi();
					} else {
						if( (y <= c.y + c.getVisina()/2 - poluprecnik) && 
								(y >= c.y - c.getVisina()/2 - poluprecnik) && 
								(x <= c.x + c.getSirina()/2) &&
								(x >= c.x - c.getSirina()/2)) {
							dy*= -1;
							c.pogodi();
						}

					}
					break;
				case('L'): 
					break;
				case('I'): 
					Igrac igrac = (Igrac) f;
				if( (x <= igrac.x + igrac.getSirina()/2 + poluprecnik) && 
						(x >= igrac.x - igrac.getSirina()/2 + poluprecnik) && 
						(y <= igrac.y + igrac.getVisina()/2) &&
						(y >= igrac.y - igrac.getVisina()/2)) {
					if(dx>0) {
						dx*= -1;
					}
					pogodjenIgrac = true;
				} else {
					if( (x <= igrac.x + igrac.getSirina()/2 - poluprecnik) && 
							(x >= igrac.x - igrac.getSirina()/2 - poluprecnik) && 
							(y <= igrac.y + igrac.getVisina()/2) &&
							(y >= igrac.y - igrac.getVisina()/2)) {
						if(dx<0) {
							dx*= -1;
						}
						dx*= -1;
						pogodjenIgrac = true;
					}

				}
				if( (y <= igrac.y + igrac.getVisina()/2 - poluprecnik) && 
						(y >= igrac.y - igrac.getVisina()/2 - poluprecnik) && 
						(x <= igrac.x + igrac.getSirina()/2) &&
						(x >= igrac.x - igrac.getSirina()/2)) {
					if(dy >0) {
						dy*= -1;
					}

					pogodjenIgrac = true;
				
					
				} else {
					if( (y <= igrac.y + igrac.getVisina()/2 + poluprecnik) && 
							(y >= igrac.y - igrac.getVisina()/2 + poluprecnik) && 
							(x <= igrac.x + igrac.getSirina()/2) &&
							(x >= igrac.x - igrac.getSirina()/2)) {
						if(dy<0) {
							dy*= -1;
						}

						pogodjenIgrac = true;
						}

					}
				if(pogodjenIgrac) {
					x+= dx;
					y+= dy;
				}
				}
			}

			if(x < poluprecnik) dx *= -1;
			if(y < poluprecnik) dy*= -1; 
			if(x > poluprecnik + 500) dx*= -1;
			if(y > poluprecnik + 600) this.unisti();  
		}

	}

	@Override
	public char getOznaka() {
		return 'L';
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(boja);
		g.fillOval((int)x-poluprecnik,(int)y-poluprecnik , 2*poluprecnik, 2*poluprecnik);
		
	}





}
