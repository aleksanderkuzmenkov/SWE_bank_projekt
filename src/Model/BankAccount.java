package Model;

import java.util.GregorianCalendar;

/**
 * The BankAccount abstract class implements class variables and
 * and getters/setters for using this variables
 *
 * @author  Oleksandr Kuzmenkov
 * @version 2.0
 * @since   2021-01-26
 */
public abstract class BankAccount {
    private int bankAccountID;
    private String bankAccountNumber;
    private String clerk;
    private double bankBalance;
    private double debitAmount;
    private GregorianCalendar debitDate;

    /**
     * Constructor.
     *
     * @param bankAccountID
     * @param bankAccountNumber (required) bank account number. Will be automatically generated.
     * @param clerk (required) bank clerk name. Must have content.
     * @param bankBalance (required) show current balance of bank account.
     */
    public BankAccount(int bankAccountID, String bankAccountNumber, String clerk, double bankBalance) {
        this.bankAccountID = bankAccountID;
        this.bankAccountNumber = bankAccountNumber;
        this.clerk = clerk;
        this.bankBalance = bankBalance;
    }

    /**
     *
     * @param debitAmount debitAmount to set
     */
    public void setDebitAmount(double debitAmount) {
        this.debitAmount = debitAmount;
    }

    /**
     * @return current debitAmount
     */
    public double getDebitAmount() {
        return debitAmount;
    }

    /**
     * @return current bankAccountNumber
     */
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    /**
     * @return current clerk
     */
    public String getClerk() {
        return clerk;
    }

    /**
     * @return current bankBlance
     */
    public double getBankBalance() {
        return bankBalance;
    }

    /**
     * @return current debitDate
     */
    public GregorianCalendar getDebitDate() {
        return debitDate;
    }
}
