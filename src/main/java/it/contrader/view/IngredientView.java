package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.IngredientDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;

public class IngredientView extends AbstractView {
	private Request request;
	private String choice;

	public IngredientView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n--------------------------------------------- Gestione Ingredienti ---------------------------------------------\n");
			System.out.println("ID\tCategoria\tNome\tPeso Considerato\tCalorie (Kcal)\tCarboidrati (g)\tProteine (g)\tGrassi (g)");
			System.out.println("-----------------------------------------------------------------------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<IngredientDTO> ingredients = (List<IngredientDTO>)request.get("ingredient");
			for (IngredientDTO u: ingredients)
				System.out.println(u);
			System.out.println();
		}
	}

	@Override
	public void showOptions() {
		if(User.isAdmin()) {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
		}
		else {
			System.out.println("          Scegli l'operazione da effettuare:");
			System.out.println("[L]eggi [B]ack [E]sci");
		}
		this.choice = getInput();
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Ingredient", "doControl", this.request);
	}
}