import Controller.Controller;
import Model.Model;

import java.util.GregorianCalendar;

public class Main {
  
	public static void main(String[] args) {

		Model model = new Model();

		model.addNewCurrentAccount("c350", "Max Mustermann", 550, 20, new GregorianCalendar());
		model.addNewCurrentAccount("c351", "Max Mustermann", 550, 20, new GregorianCalendar());
		model.addNewCurrentAccount("c352", "Max Mustermann", 550, 20, new GregorianCalendar());
		model.addNewCurrentAccount("c353", "Max Mustermann", 550, 20, new GregorianCalendar());

		model.addNewSavingAccount("s350", "Max Mustermann", 550, 20, new GregorianCalendar());
		model.addNewSavingAccount("s351", "Max Mustermann", 550, 20, new GregorianCalendar());
		model.addNewSavingAccount("s352", "Max Mustermann", 550, 20, new GregorianCalendar());
		model.addNewSavingAccount("s353", "Max Mustermann", 550, 20, new GregorianCalendar());
		model.addNewSavingAccount("s354", "Max Mustermann", 550, 20, new GregorianCalendar());

		Controller controller = new Controller("Bank Program");


    }

}
