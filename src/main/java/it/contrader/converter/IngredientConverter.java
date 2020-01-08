package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.IngredientDTO;
import it.contrader.model.Ingredient;

public class IngredientConverter implements Converter<Ingredient, IngredientDTO>{
	public IngredientDTO toDTO(Ingredient ingredient) {
		IngredientDTO ingredientDTO = new IngredientDTO(ingredient.getId(), ingredient.getCategory(), ingredient.getName(),ingredient.getWeight(), ingredient.getCal(), ingredient.getCarb(), ingredient.getProt(), ingredient.getFat());
		return ingredientDTO;
	}
	public Ingredient toEntity(IngredientDTO ingredientDTO) {
		Ingredient ingredient = new Ingredient(ingredientDTO.getId(), ingredientDTO.getCategory(), ingredientDTO.getName(),ingredientDTO.getWeight(), ingredientDTO.getCal(), ingredientDTO.getCarb(), ingredientDTO.getProt(), ingredientDTO.getFat());
		return ingredient;
	}
	public List<IngredientDTO> toDTOList (List<Ingredient> ingredients){
		List<IngredientDTO> ingredientsDTO = new ArrayList<IngredientDTO>();
		for(Ingredient ingredient : ingredients) {
			ingredientsDTO.add(toDTO(ingredient));
		}
		return ingredientsDTO;
	}
}