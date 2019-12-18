package it.contrader.view.ingredient;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class IngredientInsertView extends AbstractView{
	private Request request;
	private String category;
	private String name;
	private float weight;
	private float cal;
	private float carb;
	private float prot;
	private float fat;
	private final String mode = "INSERT";
	public IngredientInsertView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Ingredient", null);
		}
	}
	
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci categoria dell'ingrediente: ");
			category = getInput();
			System.out.println("Inserisci nome dell'ingrediente: ");
			name = getInput();
			System.out.println("Inserisci peso dell'ingrediente:");
			weight = Float.parseFloat(getInput());
			System.out.println("Inserisci calorie dell'ingrediente:");
			cal = Float.parseFloat(getInput());
			System.out.println("Inserisci carboidrati dell'ingrediente:");
			carb = Float.parseFloat(getInput());
			System.out.println("Inserisci proteine dell'ingrediente:");
			prot = Float.parseFloat(getInput());
			System.out.println("Inserisci grasso dell'ingrediente:");
			fat = Float.parseFloat(getInput());
		}catch (Exception e) {
			
		}
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("category", category);
		request.put("name", name);
		request.put("weight", weight);
		request.put("cal", cal);
		request.put("carb", carb);
		request.put("prot", prot);
		request.put("fat", fat);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Ingredient", "doControl", request);
	}
}