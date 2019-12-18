package it.contrader.view.ingredient;

import it.contrader.controller.Request;
import it.contrader.dto.IngredientDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class IngredientReadView extends AbstractView{
	private int id;
	private Request request;
	private final String mode = "READ";

	public IngredientReadView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			IngredientDTO ingredient = (IngredientDTO) request.get("ingredient");
			System.out.println(ingredient);
			MainDispatcher.getInstance().callView("Ingredient", null);
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID dell'utente:");
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