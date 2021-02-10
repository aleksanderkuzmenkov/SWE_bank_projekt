package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Model {

    private HashMap<String, CurrentAccount> currentAccounts = new HashMap<String, CurrentAccount>();
    private HashMap<String, SavingAccount> savingAccounts = new HashMap<String, SavingAccount>();
    private final String FILE_NAME = "BankAccounts.txt";

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
        for (Map.Entry<String, CurrentAccount> set : currentAccounts.entrySet()) {
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
        for (Map.Entry<String, SavingAccount> set : savingAccounts.entrySet()) {
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

        // --- first loop for looking for searched bank account ---
        for (Map.Entry<String, CurrentAccount> set : currentAccounts.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue());
            if(set.getKey().equals(bankAccountNumber)){
               bankAccountInformation.add(set.getValue());
            }
        }

        // --- second loop for looking for searched bank account ---
        for (Map.Entry<String, SavingAccount> set : savingAccounts.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue());
            if(set.getKey().equals(bankAccountNumber)){
                bankAccountInformation.add(set.getValue());
            }
        }

        return bankAccountInformation;
    }
    /**
     * Add new current bank account.
     *
     * This method adds new current account to current account list.
     * @param bankAccountNumber must have content, and must contain correct bank account number.
     * @param clerk must have content, and must contain correct bank account number.
     * @param bankBalance must have content, and must contain correct bank account number.
     * @param debitAmount must have content, and must contain correct bank account number.
     * @param debitDate must have content, and must contain correct bank account number.
     */
    public void addNewCurrentAccount(String bankAccountNumber, String clerk, double bankBalance, double debitAmount, GregorianCalendar debitDate){
        currentAccounts.put(bankAccountNumber, new CurrentAccount(bankAccountNumber, "clerk", bankBalance, debitAmount, debitDate));

        try {
            writeDataToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addNewSavingAccount(String bankAccountNumber, String clerk, double bankBalance, double debitAmount, GregorianCalendar debitDate){
        savingAccounts.put(bankAccountNumber, new SavingAccount(bankAccountNumber, clerk, bankBalance, debitAmount, debitDate));
        try {
            writeDataToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write Data to File.
     *
     * This method write all bank accounts information to BankAccounts.txt file.
     * Bank account in file will be separate to current and Saving accounts.
     * Avery line get an lineId;
     */
    public void writeDataToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));

        int lineId = 1;
        writer.write("==================== Current Accounts ==================== ");
        writer.newLine();
        for (Map.Entry<String, CurrentAccount> set : currentAccounts.entrySet()) {
            writer.write(
                    lineId++ + ";" +
                        set.getValue().getBankAccountNumber() + ";" +
                        set.getValue().getClerk()  + ";" +
                        set.getValue().getBankBalance()
            );
            writer.newLine();
        }
        writer.write("==================== Current Accounts ==================== ");
        writer.newLine();
        for (Map.Entry<String, SavingAccount> set : savingAccounts.entrySet()) {
            writer.write(
                    lineId++ + ";" +
                        set.getValue().getBankAccountNumber() + ";" +
                        set.getValue().getClerk()  + ";" +
                        set.getValue().getBankBalance()
            );
            writer.newLine();
        }
        writer.close();
    }

    public String generateBankAccountID(){

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){

            String line;

            // --- TODO what is () ---
            while ((line = reader.readLine()) != null){
                System.out.println(line + "\n");
                int c;
                while((c=reader.read()) != -1){
                    System.out.println(c);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
