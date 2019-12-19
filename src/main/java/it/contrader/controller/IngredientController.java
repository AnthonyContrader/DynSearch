package it.contrader.controller;

import java.util.List;

import it.contrader.dto.IngredientDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.service.IngredientService;

public class IngredientController implements Controller{
	private static String sub_package = "ingredient.";
	private IngredientService ingredientService;
	
	public IngredientController() {
		this.ingredientService = new IngredientService();
	}
	
	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
		boolean isAdmin = User.isAdmin();
		int id;
		String category;
		String name;
		float weight;
		float cal;
		float carb;
		float prot;
		float fat;

		switch (mode) {
		
		
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			IngredientDTO ingredientDTO = ingredientService.read(id);
			request.put("ingredient", ingredientDTO);
			MainDispatcher.getInstance().callView(sub_package + "IngredientRead", request);
			break;
		
		case "INSERT":
			category = request.get("category").toString();
			name = request.get("name").toString();
			weight = Float.parseFloat(request.get("weight").toString());
			cal = Float.parseFloat(request.get("cal").toString());
			carb = Float.parseFloat(request.get("carb").toString());
			prot = Float.parseFloat(request.get("prot").toString());
			fat = Float.parseFloat(request.get("fat").toString());
			IngredientDTO ingredienttoinsert = new IngredientDTO(category, name, weight, cal, carb, prot, fat);
			ingredientService.insert(ingredienttoinsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "IngredientInsert", request);
			break;
		
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			ingredientService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "IngredientDelete", request);
			break;
		
		
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			category = request.get("category").toString();
			name = request.get("name").toString();
			weight = Float.parseFloat(request.get("weight").toString());
			cal = Float.parseFloat(request.get("cal").toString());
			carb = Float.parseFloat(request.get("carb").toString());
			prot = Float.parseFloat(request.get("prot").toString());
			fat = Float.parseFloat(request.get("fat").toString());
			IngredientDTO ingredienttoupdate = new IngredientDTO(category, name, weight, cal, carb, prot, fat);
			ingredienttoupdate.setId(id);
			ingredientService.update(ingredienttoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "IngredientUpdate", request);
			break;
			 
		case "INGREDIENTLIST":
			List<IngredientDTO> ingredientsDTO = ingredientService.getAll();
			request.put("ingredient", ingredientsDTO);
			MainDispatcher.getInstance().callView("Ingredient", request);
			break;
			
		case "GETCHOICE":
					
			switch (choice.toUpperCase()) {
		
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "IngredientRead", null);
				break;
				
			case "I":
				if(User.isAdmin()) {
					MainDispatcher.getInstance().callView(sub_package + "IngredientInsert", null);
				}
				break;
				
			case "M":
				if(User.isAdmin()) {
					MainDispatcher.getInstance().callView(sub_package + "IngredientUpdate", null);
				}
					break;
				
			case "C":
				if(User.isAdmin()) {
				MainDispatcher.getInstance().callView(sub_package + "IngredientDelete", null);
				}
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
		if(isAdmin) {
			User.setAdmin(true);
		}else {
			User.setAdmin(false);
		}
	}
}