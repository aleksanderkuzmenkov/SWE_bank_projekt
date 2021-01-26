package View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class View extends JFrame {
	
	private Container cp;
	private JLabel buchungsbetragtxt, kontostandtxt, sachbearbeitertxt, kontonummertxt;
	private JTextField kontonummer, sachbearbeiter, kontostand, buchungsbetrag, statuszeile;
	private JButton ok, abbrechen;
	private JPanel hauptpanel, nebenpanel, gridpanel, letzespanel;
	
	
	public View(String s) {
		super(s);
		
		cp = getContentPane();
		
		buchungsbetragtxt = new JLabel("Buchungsbetrag: ");
		kontostandtxt = new JLabel("Kontostand: ");
		sachbearbeitertxt = new JLabel("Sachbearbeiterkürzel: ");
		kontonummertxt = new JLabel("Kontonummer: ");
		
		kontonummer = new JTextField(20);
		sachbearbeiter = new JTextField(20);
		sachbearbeiter.setEditable(false);
		kontostand = new JTextField(20);
		kontostand.setEditable(false);
		buchungsbetrag = new JTextField(20);
		buchungsbetrag.setEditable(false);
		statuszeile = new JTextField(20);
		statuszeile.setEditable(false);
		
		ok = new JButton("Ok");
		abbrechen = new JButton("Abbrechen");
		
		hauptpanel = new JPanel();
		nebenpanel = new JPanel();
		gridpanel = new JPanel(new GridLayout(4, 2));
		letzespanel = new JPanel();
		
		gridpanel.add(kontonummertxt);
		gridpanel.add(kontonummer);
		gridpanel.add(sachbearbeitertxt);
		gridpanel.add(sachbearbeiter);
		gridpanel.add(buchungsbetragtxt);
		gridpanel.add(buchungsbetrag);
		gridpanel.add(kontonummertxt);
		gridpanel.add(kontonummer);
		
		hauptpanel.add(gridpanel);
		
		
		cp.add(hauptpanel);
		
		
		
		
		
		setSize(new Dimension(1080,720));
		setVisible(true);
	}


	
	
	
	
	
	
	
	public JTextField getKontonummer() {
		return kontonummer;
	}


	public void setKontonummer(JTextField kontonummer) {
		this.kontonummer = kontonummer;
	}


	public JTextField getSachbearbeiter() {
		return sachbearbeiter;
	}


	public void setSachbearbeiter(JTextField sachbearbeiter) {
		this.sachbearbeiter = sachbearbeiter;
	}


	public JTextField getKontostand() {
		return kontostand;
	}


	public void setKontostand(JTextField kontostand) {
		this.kontostand = kontostand;
	}


	public JTextField getBuchungsbetrag() {
		return buchungsbetrag;
	}


	public void setBuchungsbetrag(JTextField buchungsbetrag) {
		this.buchungsbetrag = buchungsbetrag;
	}


	public JTextField getStatuszeile() {
		return statuszeile;
	}


	public void setStatuszeile(JTextField statuszeile) {
		this.statuszeile = statuszeile;
	}


	public JButton getOk() {
		return ok;
	}


	public void setOk(JButton ok) {
		this.ok = ok;
	}
	
	
	
	
	
}
