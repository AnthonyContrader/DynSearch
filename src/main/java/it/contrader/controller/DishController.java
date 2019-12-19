package it.contrader.controller;

import java.util.List;

import it.contrader.dto.DishDTO;

import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.service.DishService;


public class DishController implements Controller {

	/**
	 * definisce il pacchetto di vista dish.
	 */
	private static String sub_package = "dish.";
	
	private DishService dishService;
	/**
	 * Costruisce un oggetto di tipo DishService per poterne usare i metodi
	 */
	public DishController() {
		this.dishService = new DishService();
	}
	
	
	

	@Override
	public void doControl(Request request) {
		
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		
		String choice = (String) request.get("choice");
		
		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		String name, category;
		float cal, carb, fat, prot, weight;
		
		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			DishDTO userDTO = dishService.read(id);
			request.put("dish", userDTO);
			MainDispatcher.getInstance().callView(sub_package + "DishRead", request);
			break;

		// Arriva qui dalla DishInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			
			name = request.get("name").toString();
			cal = Float.parseFloat(request.get("cal").toString());
			carb = Float.parseFloat(request.get("carb").toString());
			fat = Float.parseFloat(request.get("fat").toString());
			prot = Float.parseFloat(request.get("prot").toString());
			category = request.get("category").toString();
			weight = Float.parseFloat(request.get("weight").toString());
			
			//costruisce l'oggetto user da inserire
			DishDTO dishtoinsert = new DishDTO(name, cal, carb, fat, prot, category, weight);
			//invoca il service
			dishService.insert(dishtoinsert);
			
			request = new Request();
			request.put("mode", "mode");
			
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "DishInsert", request);
			
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			dishService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "DishDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			cal = Float.parseFloat(request.get("cal").toString());
			carb = Float.parseFloat(request.get("carb").toString());
			fat = Float.parseFloat(request.get("fat").toString());
			prot = Float.parseFloat(request.get("prot").toString());
			category = request.get("category").toString();
			weight = Float.parseFloat(request.get("weight").toString());
			DishDTO dishtoupdate =  new DishDTO(name, cal, carb, fat, prot, category, weight);
			dishtoupdate.setId(id);
			dishService.update(dishtoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "DishUpdate", request);
			break;
			
	
		case "DISHLIST":
			List<DishDTO> dishesDTO = dishService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("dishes", dishesDTO);
			MainDispatcher.getInstance().callView("Dish", request);
			break;
		
		case "GETCHOICE":
			
			
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				
				MainDispatcher.getInstance().callView(sub_package + "DishRead", null);
				
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "DishInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "DishUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "DishDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				if(User.isAdmin()) {
					MainDispatcher.getInstance().callView("HomeAdmin", null);
				}else {
					MainDispatcher.getInstance().callView("HomeUser", null);
				}
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
	