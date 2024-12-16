package lab3zad3;

import java.awt.Color;

public abstract class AktivnaFigura extends Figura implements Runnable {
	
	protected Thread thread = new Thread(this);
	private boolean radi = false;
	private int vreme;

	public AktivnaFigura(Scena scena, int x, int y, Color boja, int vreme) {
		super(scena,x, y, boja);
		this.vreme = vreme;
	}
	
	protected abstract void AzurirajPoziciju();
	
	@Override
	public void run() {
		radi = true;
		try {
			while(!Thread.interrupted()) {
				synchronized(this) {
					if(!radi) wait();
				}
				Thread.sleep(vreme);
				AzurirajPoziciju();
				scena.repaint();
			}

		} catch (InterruptedException e) {
		}
	}

	public void pokreni() {
		radi = true;
		notify();
	}
	
	public void zaustavi() {
		thread.interrupt();
	}
	
	public void unisti() {
		super.unisti();
		zaustavi();
	}

}
