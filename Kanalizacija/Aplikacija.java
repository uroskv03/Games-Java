package lab3zad2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


@SuppressWarnings("serial")
public class Aplikacija extends Frame {
	private Kanalizacija kanalizacija = new Kanalizacija(5,5);
	
	
	public Aplikacija() {
		setTitle("Cevi");
		addComponents();
		addListeners();
		
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(495, 435));

		setLocation(400,200);	
		pack();
		setResizable(false);
		setVisible(true);
		}
	
	private void addComponents() {
		setLayout(new BorderLayout());
		Panel menu = new Panel();
		menu.setLayout(new GridLayout(8,1));
		menu.setBackground(Color.WHITE);
		CheckboxGroup grupa = new CheckboxGroup();
		menu.add(new Checkbox("Levo-Desno",false, grupa));
		menu.add(new Checkbox("Gore-Dole",false, grupa));
		menu.add(new Checkbox("Dole-Gore",false, grupa));
		menu.add(new Checkbox("Levo-Dole",false, grupa));
		menu.add(new Checkbox("Levo-Gore",false, grupa));
		menu.add(new Checkbox("Gore-Desno",false, grupa));
		menu.add(new Checkbox("Dole-Desno",false, grupa));
		Button Dodaj = new Button("Dodaj");
		menu.add(Dodaj);
		add(menu, BorderLayout.EAST);
		add(kanalizacija);
		
		Dodaj.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Checkbox a = grupa.getSelectedCheckbox();
				if(a == null) return;
				switch(a.getLabel()) {
				case("Levo-Desno"):kanalizacija.dodajCev(new LevoDesnoCev());break;
				case("Gore-Dole"):kanalizacija.dodajCev(new GoreDoleCev()); break;
				case("Dole-Gore"):kanalizacija.dodajCev(new DoleGoreCev()); break;
				case("Levo-Dole"):kanalizacija.dodajCev(new LevoDoleCev()); break;
				case("Levo-Gore"):kanalizacija.dodajCev(new LevoGoreCev()); break;
				case("Gore-Desno"):kanalizacija.dodajCev(new GoreDesnoCev()); break;
				case("Dole-Desno"):kanalizacija.dodajCev(new DoleDesnoCev()); break;
				}
			}
			
		});
		
	}

	private void addListeners() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}
			
		});
	}
	
	public static void main(String[] args) {
		new Aplikacija();
	}
}



