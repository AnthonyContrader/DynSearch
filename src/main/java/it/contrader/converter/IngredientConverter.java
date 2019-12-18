package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.IngredientDTO;
import it.contrader.model.Ingredient;

public class IngredientConverter{
	
	public IngredientDTO toDTO(Ingredient ingredient) {
		IngredientDTO ingredientDTO = new IngredientDTO(ingredient.getId(), ingredient.getCategory(), ingredient.getName(), ingredient.getWeight(), ingredient.getCal(), ingredient.getCarb(), ingredient.getProt(), ingredient.getFat());
		return ingredientDTO;
	}
	
	public Ingredient toEntity(IngredientDTO ingredientDTO) {
		Ingredient ingredient = new Ingredient(ingredientDTO.getId(), ingredientDTO.getCategory(), ingredientDTO.getName(), ingredientDTO.getWeight(), ingredientDTO.getCal(), ingredientDTO.getCarb(), ingredientDTO.getProt(), ingredientDTO.getFat());
		return ingredient;
	}
	
	public List<IngredientDTO> toDTOList(List<Ingredient> ingredientList) {
		List<IngredientDTO> ingredientsDTOList = new ArrayList<IngredientDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Ingredient ingredient : ingredientList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			ingredientsDTOList.add(toDTO(ingredient));
		}
		return ingredientsDTOList;
	}

}