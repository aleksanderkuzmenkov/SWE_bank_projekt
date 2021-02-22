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
        // --- check if konto number correct ---
        if(checkDepositAccount(bankAccountNumber) || checkCurrentAccount(bankAccountNumber)){

            System.out.println("truuuuuuu");
            return true;
        }

        System.out.println("Faaaalse");

        return false;
    }

    /**
     * Check current account.
     *
     * This method check if any currentAccount contain searched bankAccountNumber.
     * @param bankAccountNumber must have content, and must contain correct bank account number.
     */
    private boolean checkCurrentAccount(String bankAccountNumber) {
        boolean exist = false;

        for (Map.Entry<String, CurrentAccount> set : currentAccounts.entrySet()) {
//            System.out.println(set.getKey() + " = " + set.getValue());
            if(set.getKey().equals(bankAccountNumber)){
               exist = true;
            }
        }
        return exist;
    }

    /**
     * Check deposit account.
     *
     * This method check if any DepositAccount contain searched bankAccountNumber.
     * @param bankAccountNumber must have content, and must contain correct bank account number.
     */
    private boolean checkDepositAccount(String bankAccountNumber) {

        boolean exist = false;

        for (Map.Entry<String, SavingAccount> set : savingAccounts.entrySet()) {
            if(set.getKey().equals(bankAccountNumber)){
                exist = true;
            }
        }
        return exist;
    }

    /**
     * Get bank account information.
     *
     * This method get all date of an bank account.
     * @param bankAccountNumber must have content, and must contain correct bank account number.
     */
    public String[] getBankAccountInformation(String bankAccountNumber){
//        ArrayList<BankAccount> bankAccountInformation = new ArrayList();

        String [] bankAccountInformation = new String[3];

        // --- first loop for looking for searched bank account ---
        for (Map.Entry<String, CurrentAccount> set : currentAccounts.entrySet()) {

            // --- if bank account in the list exitst ---
            if(set.getKey().equals(bankAccountNumber)){

                bankAccountInformation[0] = set.getValue().getBankAccountNumber();
                bankAccountInformation[1] = set.getValue().getClerk();
                bankAccountInformation[2] = String.valueOf(set.getValue().getBankBalance());

            }
        }

        // --- second loop for looking for searched bank account ---
        for (Map.Entry<String, SavingAccount> set : savingAccounts.entrySet()) {
            if(set.getKey().equals(bankAccountNumber)){

                bankAccountInformation[0] = set.getValue().getBankAccountNumber();
                bankAccountInformation[1] = set.getValue().getClerk();
                bankAccountInformation[2] = String.valueOf(set.getValue().getBankBalance());

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
     */
    public void addNewCurrentAccount(int bankAccountID, String bankAccountNumber, String clerk, double bankBalance){

        currentAccounts.put(bankAccountNumber, new CurrentAccount(bankAccountID, bankAccountNumber, "clerk", bankBalance));

//        writeDataToFile(bankAccountID, bankAccountNumber, clerk, bankBalance);
    }

    /**
     * Add new saving bank account.
     *
     * This method adds new saving account to saving account list.
     * @param bankAccountNumber must have content, and must contain correct bank account number.
     * @param clerk must have content, and must contain correct bank account number.
     * @param bankBalance must have content, and must contain correct bank account number.
     */
    public void addNewSavingAccount(int bankAccountID, String bankAccountNumber, String clerk, double bankBalance){

        savingAccounts.put(bankAccountNumber, new SavingAccount(bankAccountID, bankAccountNumber, clerk, bankBalance));

//        writeDataToFile(id, bankAccountNumber, clerk, bankBalance);
    }

    /**
     * Write Data to File.
     *
     * This method write all bank accounts information to BankAccounts.txt file.
     * Bank account in file will be separate to current and Saving accounts.
     * Avery line get an lineId;
     */
    private void writeDataToFile(int id, String bankAccountNumber, String clerk, double bankBalance) {
        File file = new File(FILE_NAME);
        FileWriter fr = null;
        BufferedWriter br = null;
        try {
            fr = new FileWriter(file,true);
            br = new BufferedWriter(fr);

            int lineId = 1;

            br.write(id + ";");
            br.write(bankAccountNumber + ";");
            br.write(clerk + ";");
            br.write(bankBalance + ";");


            br.close();

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

            String line = null;

            String test = "";

            String[] split = new String[4];

            while ((line = reader.readLine()) != null) {

                split = line.split(";");

                splitToBankAccountTypes(split);

                idNrs.add(Integer.parseInt(split[0]));

            }

            Collections.sort(idNrs);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- TODO ---
        return idNrs.get(idNrs.size()-1);
    }

    private void splitToBankAccountTypes(String[] split) {
        if (split[1].charAt(0) == 'C'){
            addNewCurrentAccount(Integer.parseInt(split[0]), split[1], split[2], Double.parseDouble(split[3]));
        }else {
            addNewSavingAccount(Integer.parseInt(split[0]), split[1], split[2], Double.parseDouble(split[3]));
        }
    }
}
