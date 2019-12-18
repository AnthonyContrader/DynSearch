package it.contrader.view.ingredient;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class IngredientDeleteView extends AbstractView {
	private Request request;
	private int id;
	private final String mode = "DELETE";
	
	public IngredientDeleteView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Ingredient", null);
		}
	}
	
	@Override
	public void showOptions() {
			System.out.println("Inserisci id dell'ingrediente: ");
			id = Integer.parseInt(getInput());
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Ingredient", "doControl", request);
	}
}