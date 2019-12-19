package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	
	private String choice;
    
	private Request request;
	@Override
	public void showResults(Request request) {
    	if(request!=null) {
    	System.out.println("\n Benvenuto in SAMPLE PROJECT "+request.get("username").toString() + "\n");
    	}
    }

	public void showOptions() {
        System.out.println("-------------MENU------------\n");
        System.out.println(" Seleziona cosa vuoi gestire:");
        System.out.println(" [D]ish [E]xit");
        //Il metodo che salva l'input nella stringa choice.
        //getInput() è definito in AbstractView.
        choice = this.getInput();
    }

	@Override
	public void submit() {
		request = new Request();

		switch (choice) {
		 case "d":
			 	
	        	this.request.put("mode", "DISHLIST");
	        	System.out.println("ee");
	        	MainDispatcher.getInstance().callAction("Dish", "doControl", request);
	        	
	        	break;

		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
			break;

		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
