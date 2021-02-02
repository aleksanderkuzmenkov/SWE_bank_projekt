package Model;

import java.util.GregorianCalendar;

/**
 * The CurrentAccount class inherit all variables and
 * and methods of abstract class BankAccount
 *
 * @author  Oleksandr Kuzmenkov
 * @version 2.0
 * @since   2021-01-26
 */
public class CurrentAccount extends BankAccount {

    /**
     * Constructor.
     *
     * @param bankAccountNumber (required) bank account number. Will be automatically generated.
     * @param clerk (required) bank clerk name. Must have content.
     * @param bankBalance (required) show current balance of bank account. Can be negative.
     * @param debitAmount (required) show value of a debit. Can be more than bank balance.
     * @param debitDate (required) date of debit. Will be automatically generated.
     */
    public CurrentAccount(String bankAccountNumber, String clerk, double bankBalance, double debitAmount, GregorianCalendar debitDate) {
        super(bankAccountNumber, clerk, bankBalance, debitAmount, debitDate);
    }
}
