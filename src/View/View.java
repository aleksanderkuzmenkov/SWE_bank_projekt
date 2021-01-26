package View;

import java.awt.Container;

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
		
		buchungsbetragtxt = new JLabel();
		kontostandtxt = new JLabel();
		sachbearbeitertxt = new JLabel();
		kontonummertxt = new JLabel();
		
		kontonummer = new JTextField();
		sachbearbeiter = new JTextField();
		kontostand = new JTextField();
		buchungsbetrag = new JTextField();
		statuszeile = new JTextField();
		
		ok = new JButton();
		abbrechen = new JButton();
		
		hauptpanel = new JPanel();
		nebenpanel = new JPanel();
		gridpanel = new JPanel();
		letzespanel = new JPanel();
		
		
		
		
		
		
		
		
		
		
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
