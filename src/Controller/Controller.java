package Controller;


import Model.Model;
import View.View;

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
            System.out.println("Ok");
        }

        if(e.getActionCommand().equals(view.getAbbrechen().getActionCommand())){
            System.out.println("Abbrechen");
        }
    }

    public void felderLeeren(){

    }
}
