package lab3zad3;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Scena extends Canvas {
	private ArrayList<Figura> figure = new ArrayList<Figura>();
	
	public Scena() {

	}
	
	public synchronized void dodajFiguru(Figura f) {
		synchronized(figure) {
			figure.add(f);
		}

	}
	
	public synchronized Figura dohvatiFiguruIndex(int index) {
		synchronized(figure) {
			if(index >= figure.size()) return null;
			return figure.get(index);
		}
	}
	
	public synchronized void ukloni(Figura f) {
		synchronized(figure) {
			figure.remove(f);
		}

	}

	@Override
	public void paint(Graphics g) {
		synchronized(figure) {
			for(Figura f: figure) {	
				f.draw(g);
			}
		}

	}
	
	public void pokreni() {
		for(Figura f: figure) {
			if(f.getOznaka() == 'C' && f.getOznaka() == 'L') {
				AktivnaFigura pom = (AktivnaFigura) f;
				pom.pokreni();
			}
		}
	}
	
	public void zaustavi() {
		synchronized(figure) {
			for(Figura f: figure) {
				if(f.getOznaka() == 'C' || f.getOznaka() == 'L') {
					AktivnaFigura pom = (AktivnaFigura) f;
					pom.zaustavi();
					
				}
			}
		}

	}
	
	

}
