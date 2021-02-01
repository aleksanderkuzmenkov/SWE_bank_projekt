package Model;

import java.util.GregorianCalendar;

public class Girokonto extends Konto{

    public Girokonto(String kontonummer, String sachbearbeiter, double kontostand, double buchungsbetrag, GregorianCalendar buchungsdatum) {
        super(kontonummer, sachbearbeiter, kontostand, buchungsbetrag, buchungsdatum);
    }


}
