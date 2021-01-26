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

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void felderLeeren(){

    }
}
