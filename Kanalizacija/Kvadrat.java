package lab3zad2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public abstract class Kvadrat extends Canvas {
	
	private boolean oznacen;
	private Color bojaPoazadine;
	
	public Kvadrat(Color bojaPozadine) {
		this.bojaPoazadine = bojaPozadine;
		addListeners();
	}
	
	private void addListeners() {
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Kanalizacija.promeniOznakuKvadrata(Kvadrat.this);
				repaint();
			}
		});
	}

	
	public abstract boolean mozeOznaciti();
	
	public void postaviOznaku(boolean oznaka) throws GOznaka {
		if(!mozeOznaciti()) throw new GOznaka();
		oznacen = oznaka;
	}
	
	public boolean isOznacen() {
		return oznacen;
	}	

	@Override
	public void paint(Graphics g) {
		g.setColor(bojaPoazadine);
		g.fillRect(0, 0, 75, 75);
		if(oznacen) {
			g.setColor(Color.RED);
			g.drawRect(0, 0, 75, 75); 
		}
	}
	
}
