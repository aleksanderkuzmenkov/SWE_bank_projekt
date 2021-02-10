package Controller;


import Model.Model;
import View.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Controller implements ActionListener {
    private View view;
    private Model model;

    /**
     * Constructor.
     *
     * @param title (required) program name.
     */
    public Controller(String title) {
        this.view = new View(title);
        this.model = new Model();
        setListeners();
        model.generateBankAccountID();
    }

    /**
     * set listeners.
     *
     * This method set actionListener on buttons from view.
     */
    private void setListeners() {
        view.getOkayButton().addActionListener(this);
        view.getAbortButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(view.getOkayButton().getActionCommand())){
            if(view.getBankAccountNumber().getText().equals("")){
                view.getBankAccountNumber().setBackground(Color.RED);
                view.getStatusLine().setText("Geben Sie die Kontonummer ein!");
            }else{
                // --- check if konto number exist ---
                if(!model.checkIfAccountExist(view.getBankAccountNumber().getText())){
                    // --- if not get error ---
                    view.getBankAccountNumber().setBackground(Color.RED);
                    view.getStatusLine().setText("Die Kontonummer ist falsch!");
                }else{
                    // --- if exist ---
                    showData(view.getBankAccountNumber().getText());
                }

                System.out.println(view.getBankAccountNumber().getText());
                view.getBankAccountNumber().setBackground(Color.WHITE);
                view.getStatusLine().setText("");
            }
        }

        if(e.getActionCommand().equals(view.getAbortButton().getActionCommand())){
            emptyFields();

        }
    }

    /**
     * Empty Fields.
     *
     * This method makes all fields of view empty.
     */
    public void emptyFields(){
        view.getBankAccountNumber().setText("");
        view.getClear().setText("");
        view.getDebitAmount().setText("");
        view.getDebitAmount().setText("");
    }

    /**
     * Show data.
     *
     * This method get all date of an bank account.
     * @param bankAccountNumber must have content, and must contain correct bank account number.
     */
    public void showData(String bankAccountNumber){
        model.getBankAccountInformation(bankAccountNumber).get(0);
    }
}
