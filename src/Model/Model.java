package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Model {

    private HashMap<String, CurrentAccount> girokonten = new HashMap<String, CurrentAccount>();
    private HashMap<String, SavingAccount> sparkonten = new HashMap<String, SavingAccount>();

    // --- todo ---
    public boolean debitMoney(double amount){

        return true;
    }

    // --- todo ---
    public boolean checkAmount(double amount){

        return true;
    }

    /**
     * Check if account exist.
     *
     * This method check if account exist.
     * @param bankAccountNumber must have content, and must contain correct bank account number.
     */
    public boolean checkIfAccountExist(String bankAccountNumber){
        checkDepositAccount(bankAccountNumber);
        // --- check if konto number correct ---
        if(!checkDepositAccount(bankAccountNumber) && !checkCurrentAccount(bankAccountNumber)){
            return false;
        }else{
            return true;
        }
    }

    /**
     * Check current account.
     *
     * This method check if any currentAccount contain searched bankAccountNumber.
     * @param bankAccountNumber must have content, and must contain correct bank account number.
     */
    private boolean checkCurrentAccount(String bankAccountNumber) {
        for (Map.Entry<String, CurrentAccount> set : girokonten.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue());
            if(!set.getKey().equals(bankAccountNumber)){
                return false;
            }
        }
        return true;
    }

    /**
     * Check deposit account.
     *
     * This method check if any DepositAccount contain searched bankAccountNumber.
     * @param bankAccountNumber must have content, and must contain correct bank account number.
     */
    private boolean checkDepositAccount(String bankAccountNumber) {
        for (Map.Entry<String, SavingAccount> set : sparkonten.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue());
            if(!set.getKey().equals(bankAccountNumber)){
                return false;
            }
        }
        return true;
    }

    /**
     * Get bank account information.
     *
     * This method get all date of an bank account.
     * @param bankAccountNumber must have content, and must contain correct bank account number.
     */
    public ArrayList getBankAccountInformation(String bankAccountNumber){
        ArrayList<BankAccount> bankAccountInformation = new ArrayList();

        // --- first for loop for looking for searched bank account ---
        for (Map.Entry<String, CurrentAccount> set : girokonten.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue());
            if(set.getKey().equals(bankAccountNumber)){
               bankAccountInformation.add(set.getValue());
            }
        }

        // --- second for loop for looking for searched bank account ---
        for (Map.Entry<String, SavingAccount> set : sparkonten.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue());
            if(set.getKey().equals(bankAccountNumber)){
                bankAccountInformation.add(set.getValue());
            }
        }

        return bankAccountInformation;
    }

}
