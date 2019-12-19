package it.contrader.view.dish;

import it.contrader.controller.Request;

import it.contrader.dto.DishDTO;

import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class DishReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";
	
	public DishReadView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			DishDTO dish = (DishDTO) request.get("dish");
			System.out.println(dish);
			MainDispatcher.getInstance().callView("Dish", null);
		}
	}
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del piatto:");
		id = Integer.parseInt(getInput());
	}
	
	@Override
	public void submit() {
		
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Dish", "doControl", request);
		
	}


}