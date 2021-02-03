package View;

import java.awt.*;

import javax.swing.*;

public class View extends JFrame {
	
	private Container cp;

	private JLabel debitAmountTxt = new JLabel("Buchungsbetrag: ");
	private JLabel bankBalanceTxt;
	private JLabel clearTxt;
	private JLabel bankAccountNumberTxt;

	private JTextField bankAccountNumber;
	private JTextField clear;
	private JTextField bankBalance;
	private JTextField debitAmount;
	private JTextField statusLine;

	private JButton okayButton;
	private JButton abortButton;
	private JPanel hauptpanel, nebenpanel, gridpanel, letzespanel, buttonpanel;

	/**
	 * Constructor.
	 *
	 * @param title (required) program name.
	 */
	public View(String title) {
		super(title);
		
		cp = getContentPane();

		initializeButtons();

		initializeGridpanel();

		initializeHauptpanel();

		initializeLetzpanel();

		createStatusLine();

		cp.add(letzespanel, BorderLayout.CENTER);
		cp.add(statusLine, BorderLayout.SOUTH);

		setproperties();

	}

	private void createStatusLine() {
		statusLine = new JTextField(20);
		statusLine.setEditable(false);
	}

	private void setproperties() {
		setSize(new Dimension(500, 700));
		setVisible(true);
	}

	private void initializeButtons() {
		buttonpanel = new JPanel();
		buttonpanel.setLayout(new FlowLayout());

		okayButton = new JButton("Ok");
		abortButton = new JButton("Abbrechen");

		buttonpanel.add(okayButton);
		buttonpanel.add(abortButton);
	}

	private void initializeGridpanel() {
		gridpanel = new JPanel(new GridLayout(4, 2));

		// --- prepare view elements for gridpanel ---
		debitAmount = new JTextField(20);
		debitAmount.setEditable(false);

		bankBalanceTxt = new JLabel("Kontostand: ");
		bankBalance = new JTextField(20);
		bankBalance.setEditable(false);

		clearTxt = new JLabel("Sachbearbeiterkürzel: ");
		clear = new JTextField(20);
		clear.setEditable(false);

		bankAccountNumberTxt = new JLabel("Kontonummer: ");
		bankAccountNumber = new JTextField(20);
		bankAccountNumber.setText(null);

		// --- add view elements to gridpanel ---
		gridpanel.add(bankAccountNumberTxt);
		gridpanel.add(bankAccountNumber);

		gridpanel.add(clearTxt);
		gridpanel.add(clear);

		gridpanel.add(debitAmountTxt);
		gridpanel.add(debitAmount);

		gridpanel.add(bankBalanceTxt);
		gridpanel.add(bankBalance);

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


	public JTextField getBankAccountNumber() {
		return bankAccountNumber;
	}


	public void setBankAccountNumber(JTextField bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}


	public JTextField getClear() {
		return clear;
	}


	public void setClear(JTextField clear) {
		this.clear = clear;
	}


	public JTextField getBankBalance() {
		return bankBalance;
	}


	public void setBankBalance(JTextField bankBalance) {
		this.bankBalance = bankBalance;
	}


	public JTextField getDebitAmount() {
		return debitAmount;
	}


	public void setDebitAmount(JTextField debitAmount) {
		this.debitAmount = debitAmount;
	}


	public JTextField getStatusLine() {
		return statusLine;
	}


	public void setStatusLine(JTextField statusLine) {
		this.statusLine = statusLine;
	}


	public JButton getOkayButton() {
		return okayButton;
	}


	public void setOkayButton(JButton okayButton) {
		this.okayButton = okayButton;
	}

	public JButton getAbortButton() {
		return abortButton;
	}
}
