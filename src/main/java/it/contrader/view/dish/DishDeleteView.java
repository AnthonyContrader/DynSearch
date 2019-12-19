package it.contrader.view.dish;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class DishDeleteView extends AbstractView {
	private Request request;

	private int id;
	private final String mode = "DELETE";
	
	public DishDeleteView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Dish", null);
		}
	}
	
	@Override
	public void showOptions() {
			System.out.println("Inserisci id del piatto:");
			id = Integer.parseInt(getInput());

	}
	
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Dish", "doControl", request);
	}
	
}