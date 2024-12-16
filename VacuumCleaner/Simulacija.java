package lab3zad1;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Simulacija extends Frame {
	
	private Scena scena = new Scena();
	
	public Simulacija() {
		setTitle("Simulacija");
		addComponents();
		addListeners();
		setLocation(400,200);
		pack();
		setResizable(false);
		scena.nastavi();
		setVisible(true);
	}
	
	private void terminate() {
		scena.zavrsi();
		dispose();
	}
	
	private void addComponents() {
		setLayout(new BorderLayout());
		add(scena, BorderLayout.CENTER);
	}
	
	private void addListeners() {
		scena.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	scena.getParent().requestFocus();
                if (e.getButton() == MouseEvent.BUTTON1) {
                    scena.dodajFiguruNaScenu(new Kamencic(e.getX(), e.getY()));
                }
            }

			@Override
			public void mouseReleased(MouseEvent arg0) {
				scena.getParent().requestFocus();
				super.mouseReleased(arg0);
			}
            
        });

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				terminate();
			}
			
		});
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {;
				super.keyPressed(arg0);
				if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE) {
					terminate();
				}
				if(arg0.getKeyCode() == KeyEvent.VK_SPACE) {
					synchronized(scena) {
						if(scena.getRadi()) {
							scena.pauziraj();
						} else {
							scena.nastavi();
						}
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		new Simulacija();
	}

}



