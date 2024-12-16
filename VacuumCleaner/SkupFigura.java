package lab3zad1;

import java.util.ArrayList;

public class SkupFigura {
	private ArrayList<Figura> figure = new ArrayList<Figura>();
	private Figura tekuca;
	private int indexTekuce = -1;
	
	public synchronized void dodajFiguru(Figura f) throws GreskaFiguraVecUSkupu{ 
		if(figure.contains(f)) throw new GreskaFiguraVecUSkupu();
		figure.add(f);
	}
	
	public synchronized void TekPrva() {
		tekuca = figure.get(0);
		indexTekuce = 0;
	}
	
	public synchronized Figura TekSledeca() throws GreskaNePostojiSledeci {
		if(!postojiSled()) throw new GreskaNePostojiSledeci();
		tekuca = figure.get(++indexTekuce);
		return tekuca;
	}

	public synchronized Figura getTekuca() {
		return tekuca;
	}
	
	public synchronized boolean postojiSled() {
		return (indexTekuce < this.brFigura()-1);
	}
	
	public synchronized void Isprazni() {
		figure.clear();
	}
	
	public synchronized boolean nalazi(Figura f) {
		return figure.contains(f);
	}
	
	public synchronized void izbaci(Figura f) {
		figure.remove(f);
	}
	
	public synchronized int brFigura() {
		return figure.size();
	}
	
}
