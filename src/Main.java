import Controller.Controller;
import Model.Model;

import java.util.GregorianCalendar;

public class Main {
  
	public static void main(String[] args) {

		Model model = new Model();

		model.addNewCurrentAccount("b350", "Max Mustermann", 550, 20, new GregorianCalendar());

		Controller controller = new Controller("Bank Program");


    }

}
