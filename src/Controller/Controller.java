package Controller;


import Model.Model;
import View.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private View view;
    private Model model;

    public Controller(String s) {
        this.view = new View("");
        this.model = new Model();
        setListeners();
    }

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
                if(!model.checkIfKontoExist(view.getKontonummer().getText())){
                    // --- if not get error ---
                    view.getKontonummer().setBackground(Color.RED);
                    view.getStatuszeile().setText("Die Kontonummer ist flash!");
                }else{
                    // --- if exist ---

                }

                System.out.println(view.getKontonummer().getText());
                view.getKontonummer().setBackground(Color.WHITE);
                view.getStatuszeile().setText("");
            }
        }

        if(e.getActionCommand().equals(view.getAbbrechen().getActionCommand())){
            felderLeeren();

        }
    }

    public void felderLeeren(){
        view.getKontonummer().setText("");
        view.getSachbearbeiter().setText("");
        view.getBuchungsbetrag().setText("");
        view.getBuchungsbetrag().setText("");
    }

    public void showData(){

    }
}
