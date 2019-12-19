package it.contrader.view.dish;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class DishUpdateView extends AbstractView {
	private Request request;


	
	private float cal;
	private float carb;
	private float fat;
	private float prot;
	private String category;
	private String name;
	private float weight;
	private final String mode = "UPDATE";

	public DishUpdateView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Dish", null);
		}
	}
	
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci nome dell'utente:");
			name = getInput();
			System.out.println("Inserisci calorie del piatto:");
			cal = Float.parseFloat(getInput());
			System.out.println("Inserisci carboidrati del piatto:");
			carb = Float.parseFloat(getInput());
			System.out.println("Inserisci i grassi del piatto:");
			fat = Float.parseFloat(getInput());
			System.out.println("Inserisci proteine del piatto:");
			prot = Float.parseFloat(getInput());
			System.out.println("Inserisci categorie del piatto:");
			category = getInput();
			System.out.println("Inserisci peso del piatto:");
			weight = Float.parseFloat(getInput());
		} catch (Exception e) {

		}
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("cal", cal);
		request.put("carb", carb);
		request.put("fat", fat);
		request.put("prot", prot);
		request.put("category", category);
		request.put("weight", weight);
		request.put("mode", mode);
		
		MainDispatcher.getInstance().callAction("Dish", "doControl", request);
	}
	
}