package lab3zad2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

@SuppressWarnings("serial")
public class Kanalizacija extends Panel {
	private int sirina, visina;
	private static Kvadrat oznacenKvadrat;
	private Kvadrat[][] kvadrati;

	public Kanalizacija(int sirina, int visina) {
		super();
		this.sirina = sirina;
		this.visina = visina;
		this.setLayout(new GridLayout(sirina, visina,1,1));
		this.setBackground(Color.white);
		kvadrati = new Kvadrat[sirina][visina];
		for(int i = 0; i<sirina; i++) {
			for(int j = 0; j<visina; j++) {
				kvadrati[i][j] = new Zid();
				add(kvadrati[i][j]);
			}
		}
	}
	
	public static void promeniOznakuKvadrata(Kvadrat a) {
		if(!a.mozeOznaciti()) return;
		if(oznacenKvadrat != null) {
			try {
				oznacenKvadrat.postaviOznaku(false);
				oznacenKvadrat.repaint();
			} catch (GOznaka e) {
				e.printStackTrace();
			}
		}
		
		try {
			a.postaviOznaku(true);
		} catch (GOznaka e) {
			e.printStackTrace();
		}
		oznacenKvadrat = a;
	}
	
	public void dodajCev(Cev cev) {
		if(cev == null) return;
		if(oznacenKvadrat == null) return;
		for(int i = 0; i<sirina; i++) {
			for(int j = 0; j<visina; j++) {
				if(oznacenKvadrat == kvadrati[i][j]) {
					kvadrati[i][j] = cev;
					try {
						oznacenKvadrat.postaviOznaku(false);
					} catch (GOznaka e) {
					}
					oznacenKvadrat.repaint();
					oznacenKvadrat = kvadrati[i][j];
					try {
						oznacenKvadrat.postaviOznaku(true);
					} catch (GOznaka e) {
					}
					this.remove(i*visina+j);
					this.add(cev,i*visina+j);
					this.revalidate();
					this.repaint();
					return;
				}
			}
		}
	}
}
