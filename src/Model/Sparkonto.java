package Model;

import java.util.GregorianCalendar;

public class Sparkonto extends Konto{
    public Sparkonto(String kontonummer, String sachbearbeiter, double kontostand, double buchungsbetrag, GregorianCalendar buchungsdatum) {
        super(kontonummer, sachbearbeiter, kontostand, buchungsbetrag, buchungsdatum);
    }


}
