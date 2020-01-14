package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.IngredientDTO;
import it.contrader.model.Ingredient;

@Component
public class IngredientConverter extends AbstractConverter<Ingredient, IngredientDTO>{
	DishConverter converter = new DishConverter();
	@Override
	public Ingredient toEntity (IngredientDTO ingredientDTO) {
		Ingredient ingredient = null;
		if(ingredientDTO != null) {
			ingredient = new Ingredient(ingredientDTO.getId(),ingredientDTO.getName(),ingredientDTO.getCategory(),ingredientDTO.getWeight(),ingredientDTO.getCal(),ingredientDTO.getCarb(),ingredientDTO.getProt(),ingredientDTO.getFat());
		}
		return ingredient;
	}
	@Override
	public IngredientDTO toDTO (Ingredient ingredient) {
		IngredientDTO ingredientDTO = null;
		if(ingredient != null) {
			ingredientDTO = new IngredientDTO(ingredient.getId(),ingredient.getName(),ingredient.getCategory(),ingredient.getWeight(),ingredient.getCal(),ingredient.getCarb(),ingredient.getProt(),ingredient.getFat());
		}
		return ingredientDTO;
	}
}
