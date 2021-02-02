package Controller;


import Model.Model;
import View.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private View view;
    private Model model;

    /**
     * Constructor.
     *
     * @param title (required) program name.
     */
    public Controller(String title) {
        this.view = new View("");
        this.model = new Model();
        setListeners();
    }

    /**
     * set listeners.
     *
     * This method set actionListener on buttons from view.
     */
    private void setListeners() {
        view.getOk().addActionListener(this);
        view.getAbbrechen().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(view.getOk().getActionCommand())){
            if(view.getKontonummer().getText().equals("")){
                view.getKontonummer().setBackground(Color.RED);
                view.getStatuszeile().setText("Geben Sie die Kontonummer ein!");
            }else{
                // --- check if konto number exist ---
                if(!model.checkIfAccountExist(view.getKontonummer().getText())){
                    // --- if not get error ---
                    view.getKontonummer().setBackground(Color.RED);
                    view.getStatuszeile().setText("Die Kontonummer ist flash!");
                }else{
                    // --- if exist ---
                    showData(view.getKontonummer().getText());
                }

                System.out.println(view.getKontonummer().getText());
                view.getKontonummer().setBackground(Color.WHITE);
                view.getStatuszeile().setText("");
            }
        }

        if(e.getActionCommand().equals(view.getAbbrechen().getActionCommand())){
            emptyFields();

        }
    }

    /**
     * Empty Fields.
     *
     * This method makes all fields of view empty.
     */
    public void emptyFields(){
        view.getKontonummer().setText("");
        view.getSachbearbeiter().setText("");
        view.getBuchungsbetrag().setText("");
        view.getBuchungsbetrag().setText("");
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
