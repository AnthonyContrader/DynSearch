package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.DishDTO;
import it.contrader.main.MainDispatcher;

public class DishView extends AbstractView {

	private Request request;
	private String choice;

	public DishView() {
		
	}
	
	@Override
	public void showResults(Request request) {

		if (request != null) {
			System.out.println("\n------------------- Gestione piatti ----------------\n");
			System.out.println("ID\tName\tCalorie\tCarboidrati\tGrassi\tCarboidrati\tProteine\tCategorie\tPeso");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<DishDTO> dishes = (List<DishDTO>) request.get("dishes");
			for (DishDTO u: dishes)
				System.out.println(u);
			System.out.println();
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();
		
		}
	
	@Override
	public void submit() {
		
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Dish", "doControl", this.request);
		
	}
}