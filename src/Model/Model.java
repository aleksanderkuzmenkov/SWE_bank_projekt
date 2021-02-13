package Model;

import java.io.*;
import java.util.*;

/**
 * The Model class
 * and methods of abstract class BankAccount
 *
 * @author  Oleksandr Kuzmenkov
 * @version 2.0
 * @since   2021-01-26
 */
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

        String bankAccountId = "C" + generateBankAccountID();
        currentAccounts.put(bankAccountId, new CurrentAccount(bankAccountNumber, "clerk", bankBalance, debitAmount, debitDate));

        writeDataToFile(bankAccountId, clerk, bankBalance, debitAmount, debitDate);
    }

    /**
     * Add new saving bank account.
     *
     * This method adds new saving account to saving account list.
     * @param bankAccountNumber must have content, and must contain correct bank account number.
     * @param clerk must have content, and must contain correct bank account number.
     * @param bankBalance must have content, and must contain correct bank account number.
     * @param debitAmount must have content, and must contain correct bank account number.
     * @param debitDate must have content, and must contain correct bank account number.
     */
    public void addNewSavingAccount(String bankAccountNumber, String clerk, double bankBalance, double debitAmount, GregorianCalendar debitDate){
        String bankAccountId = "C"+generateBankAccountID();
        savingAccounts.put(bankAccountId, new SavingAccount(bankAccountNumber, clerk, bankBalance, debitAmount, debitDate));
        writeDataToFile(bankAccountId, clerk, bankBalance, debitAmount, debitDate);
    }

    /**
     * Write Data to File.
     *
     * This method write all bank accounts information to BankAccounts.txt file.
     * Bank account in file will be separate to current and Saving accounts.
     * Avery line get an lineId;
     */
    private void writeDataToFile(String bankAccountId, String clerk, double bankBalance, double debitAmount, GregorianCalendar debitDate) {
        File file = new File(FILE_NAME);
        FileWriter fr = null;
        BufferedWriter br = null;
        try {
            //для обновления файла нужно инициализировать FileWriter с помощью этого конструктора
            fr = new FileWriter(file,true);
            br = new BufferedWriter(fr);

            int lineId = 1;

            br.write(bankAccountId + ";");
            br.write(clerk + ";");
            br.write(bankBalance + ";");
            br.write(debitAmount + ";");
            br.write(debitDate + ";");

            br.close();

//            for (Map.Entry<String, CurrentAccount> set : currentAccounts.entrySet()) {
//                br.write(
//                        lineId++ + ";" +
//                                set.getValue().getBankAccountNumber() + ";" +
//                                set.getValue().getClerk()  + ";" +
//                                set.getValue().getBankBalance()
//                );
//                br.newLine();
//            }
//            for (Map.Entry<String, SavingAccount> set : savingAccounts.entrySet()) {
//                br.write(
//                        lineId++ + ";" +
//                                set.getValue().getBankAccountNumber() + ";" +
//                                set.getValue().getClerk()  + ";" +
//                                set.getValue().getBankBalance()
//                );
//                br.newLine();
//            }
//            br.close();



        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int generateBankAccountID(){

        ArrayList<Integer> idNrs = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){

            String line = reader.readLine();

            String test = "";
            boolean helper = true;
            int counter = 0;

            while ((line = reader.readLine()) != null) {
                while (helper) {
                    if (!String.valueOf(line.charAt(counter)).equals(";")) {
                        test = test + line.charAt(counter);
                        counter++;
                    } else {
                        System.out.println(test);
                        counter = 0;
                        idNrs.add(Integer.parseInt(test));
                        test = "";
                        helper = false;
                    }
                }
                helper = true;
            }

             Collections.sort(idNrs);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- TODO ---
        return idNrs.get(idNrs.size()-1);
//        return null;
    }
}
