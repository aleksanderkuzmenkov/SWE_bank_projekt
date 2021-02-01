package View;

import java.awt.*;

import javax.swing.*;

public class View extends JFrame {
	
	private Container cp;
	private JLabel buchungsbetragtxt, kontostandtxt, sachbearbeitertxt, kontonummertxt;
	private JTextField kontonummer, sachbearbeiter, kontostand, buchungsbetrag, statuszeile;
	private JButton ok;
	private JButton abbrechen;
	private JPanel hauptpanel, nebenpanel, gridpanel, letzespanel, buttonpanel;
	
	
	public View(String s) {
		super(s);
		
		cp = getContentPane();

		initializeButtons();

		initializeGridpanel();

		initializeHauptpanel();

		initializeLetzpanel();

		createStatusLine();

		cp.add(letzespanel, BorderLayout.CENTER);
		cp.add(statuszeile, BorderLayout.SOUTH);

		setproperties();

	}

	private void createStatusLine() {
		statuszeile = new JTextField(20);
		statuszeile.setEditable(false);
	}

	private void setproperties() {
		setSize(new Dimension(500, 700));
		setVisible(true);
	}

	private void initializeButtons() {
		buttonpanel = new JPanel();
		buttonpanel.setLayout(new FlowLayout());

		ok = new JButton("Ok");
		abbrechen = new JButton("Abbrechen");

		buttonpanel.add(ok);
		buttonpanel.add(abbrechen);
	}

	private void initializeGridpanel() {
		gridpanel = new JPanel(new GridLayout(4, 2));

		// --- prepare view elements for gridpanel ---
		buchungsbetragtxt = new JLabel("Buchungsbetrag: ");
		buchungsbetrag = new JTextField(20);
		buchungsbetrag.setEditable(false);

		kontostandtxt = new JLabel("Kontostand: ");
		kontostand = new JTextField(20);
		kontostand.setEditable(false);

		sachbearbeitertxt = new JLabel("Sachbearbeiterkürzel: ");
		sachbearbeiter = new JTextField(20);
		sachbearbeiter.setEditable(false);

		kontonummertxt = new JLabel("Kontonummer: ");
		kontonummer = new JTextField(20);
		kontonummer.setText(null);

		// --- add view elements to gridpanel ---
		gridpanel.add(kontonummertxt);
		gridpanel.add(kontonummer);

		gridpanel.add(sachbearbeitertxt);
		gridpanel.add(sachbearbeiter);

		gridpanel.add(buchungsbetragtxt);
		gridpanel.add(buchungsbetrag);

		gridpanel.add(kontostandtxt);
		gridpanel.add(kontostand);

	}

	private void initializeHauptpanel() {
		hauptpanel = new JPanel();

		hauptpanel.add(gridpanel);

	}

	private void initializeLetzpanel() {

		letzespanel = new JPanel();
		letzespanel.setLayout(new BoxLayout(letzespanel, BoxLayout.Y_AXIS));
		letzespanel.add(hauptpanel);
		letzespanel.add(buttonpanel);

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

	public JButton getAbbrechen() {
		return abbrechen;
	}
}
