package lab3zad3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class IgraLoptica extends Frame{
	
	private Scena scena = new Scena();
		
	public IgraLoptica(){
		namestiScenu();
		setTitle("Loptica");
		setLayout(new BorderLayout());
		add(scena, BorderLayout.CENTER);
		addListeners();
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(535, 600));
		setLocation(400,200);
		pack();
		setResizable(false);
		setVisible(true);
	}
	
	private void namestiScenu() {
		
		scena.dodajFiguru(new Igrac(scena,250,540,10,50));
		for(int i = 0; i<5; i++) {
			for(int j=0; j<3; j++) {
				scena.dodajFiguru(new Cigla(scena,50+100*i+3*i,10+20*j+3*j,50,100,20));
			}
		}
	}
	
	private void addListeners() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				scena.zaustavi();
				dispose();
			}
		});
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_A) {
					if(scena.dohvatiFiguruIndex(0).x>30) {
						scena.dohvatiFiguruIndex(0).pomeri(-5, 0);
					}

					scena.repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					if(scena.dohvatiFiguruIndex(0).x<490)
					scena.dohvatiFiguruIndex(0).pomeri(5, 0);
					scena.repaint();
				}
			}
			
		});
		scena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				scena.getParent().requestFocus();
				Igrac igrac = (Igrac)scena.dohvatiFiguruIndex(0);
				scena.dodajFiguru(new Loptica(scena,(int)igrac.x,(int)igrac.y-igrac.getVisina()/2-2-5,10,5));
				scena.repaint();
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				scena.getParent().requestFocus();
			}
			
			
		});
	}

	public static void main(String[]args) {
		new IgraLoptica();
	}
}
