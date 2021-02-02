package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Model {
//    private ArrayList sparkonten = new ArrayList();
//    private ArrayList girokonten = new ArrayList();

    private HashMap<String, Girokonto> girokonten = new HashMap<String, Girokonto>();
    private HashMap<String, Sparkonto> sparkonten = new HashMap<String, Sparkonto>();

    public boolean buchen(double betrag){

        return true;
    }

    public boolean checkbetrag(double betrag){

        return true;
    }

    public boolean checkIfKontoExist(String kontonummer){

        checkSparkonten(kontonummer);


        if(!checkSparkonten(kontonummer) && !checkGirokonten(kontonummer)){
            return false;
        }else{
            return true;
        }


    }

    private boolean checkGirokonten(String kontonummer) {
        for (Map.Entry<String, Girokonto> set : girokonten.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue());
            if(!set.getKey().equals(kontonummer)){
                return false;
            }
        }
        return true;
    }

    private boolean checkSparkonten(String kontonummer) {
        for (Map.Entry<String, Sparkonto> set : sparkonten.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue());
            if(!set.getKey().equals(kontonummer)){
                return false;
            }
        }
        return true;
    }

    public String[] getKontoInformantion(String kontonummer){



        return null;
    }


}
