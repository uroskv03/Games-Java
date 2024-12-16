package lab3zad1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


@SuppressWarnings("serial")
public class Scena extends Canvas implements Runnable {
	
	private SkupFigura skup = new SkupFigura();
	private Usisivac usisivac;
	private Thread thread = new Thread(this);
	private boolean radi;

	public Scena(){
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(600, 400));
		usisivac = new Usisivac(getPreferredSize().width / 2, getPreferredSize().height / 2);
		try {
			skup.dodajFiguru(usisivac);
		} catch (GreskaFiguraVecUSkupu e) {
			e.printStackTrace();
		}
		thread.start();
	}
		
	
	public synchronized void pomeriUsisivac() {
		synchronized(this.skup) {
			if(skup.brFigura() == 1) {
				return;
			}
			int min = 0;
			Figura minFigura = null;
			try {
				if(skup.brFigura() > 1 ) {
					skup.TekPrva();
					skup.TekSledeca();
					while(true) {
						if(minFigura == null || min > skup.getTekuca().getDistance(usisivac) ) {
							minFigura = skup.getTekuca();
							min = minFigura.getDistance(usisivac);
						}	
						if(skup.postojiSled()) {
							skup.TekSledeca();
						} else {
							break;
						}
					}
				}
				int x = minFigura.getX() - usisivac.getX();
				int y = minFigura.getY() - usisivac.getY();
				if(Math.abs(x) > usisivac.getOffset()) {
					if(x > 0) {
						usisivac.setX(usisivac.getX()+usisivac.getOffset());
						x += usisivac.getOffset();
					} else {
						usisivac.setX(usisivac.getX()-usisivac.getOffset());
						x-= usisivac.getOffset();
					}
				} else {
					if(Math.abs(y) > usisivac.getOffset()) {
						if(y > 0) {
							usisivac.setY(usisivac.getY()+usisivac.getOffset());
							y+= usisivac.getOffset();
						} else {
							usisivac.setY(usisivac.getY()-usisivac.getOffset());
							y-= usisivac.getOffset();
						}
					}
				}
				if(usisivac.Preklapa(minFigura)) {
					skup.izbaci(minFigura);
				}
			} catch (GreskaNePostojiSledeci e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		synchronized(this.skup) {
			try {
				if(skup.brFigura() > 0 ) {
					skup.TekPrva();
					while(true) {
						skup.getTekuca().draw(g);
						if(skup.postojiSled()) {
							skup.TekSledeca();
						} else {
							break;
						}
					}
				}
			} catch (GreskaNePostojiSledeci e) {
			}
		}
	}


	@Override
	public void run() {
		try {
			while(!thread.isInterrupted()) {
				synchronized (this) {
					while (!radi) {
						wait();
					}
				}
				Thread.sleep(50);
				pomeriUsisivac();
				repaint();
			}
		} catch (InterruptedException e) {
		}
		

	}
	
	public synchronized void pauziraj() {
		radi = false;
	}
	
	public synchronized void nastavi() {
		radi = true;
		notify();
	}
	
	public synchronized void zavrsi() {
		thread.interrupt();
	}
	
	public synchronized boolean getRadi() {
		return radi;
	}
	
	public synchronized void dodajFiguruNaScenu(Figura f) {
		synchronized(skup) {
			try {
				if((f.getX()-f.getRadius() < 0) || (f.getY() - f.getRadius() < 0)) {
					return;
				}
				if((f.getX()+f.getRadius() > getPreferredSize().width ) || (f.getY() + f.getRadius() > getPreferredSize().height )) {
					return;
				}
				if(skup.brFigura() > 0 ) {
					skup.TekPrva();
					while(true) {
						if(skup.getTekuca().Preklapa(f)) {
							return;
						}
						if(skup.postojiSled()) {
							skup.TekSledeca();
						} else {
							break;
						}
					}
				}
				skup.dodajFiguru(f);
			} catch (GreskaFiguraVecUSkupu | GreskaNePostojiSledeci e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
