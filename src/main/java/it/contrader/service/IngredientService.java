package it.contrader.service;

import it.contrader.converter.IngredientConverter;
import it.contrader.dao.IngredientDAO;
import it.contrader.dto.IngredientDTO;
import it.contrader.model.Ingredient;

public class IngredientService extends AbstractService<Ingredient, IngredientDTO>{
	public IngredientService(){
		this.dao = new IngredientDAO();
		this.converter = new IngredientConverter();
	}
}