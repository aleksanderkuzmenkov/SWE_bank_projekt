package Model;

import java.util.GregorianCalendar;

public abstract class Konto {
    private String kontonummer;
    private String sachbearbeiter;
    private double kontostand;
    private double buchungsbetrag;
    private GregorianCalendar buchungsdatum;

    public Konto(String kontonummer, String sachbearbeiter, double kontostand, double buchungsbetrag, GregorianCalendar buchungsdatum) {
        this.kontonummer = kontonummer;
        this.sachbearbeiter = sachbearbeiter;
        this.kontostand = kontostand;
        this.buchungsbetrag = buchungsbetrag;
        this.buchungsdatum = buchungsdatum;
    }

    public void setBuchungsbetrag(double buchungsbetrag) {
        this.buchungsbetrag = buchungsbetrag;
    }

    public double getBuchungsbetrag() {
        return buchungsbetrag;
    }
}
