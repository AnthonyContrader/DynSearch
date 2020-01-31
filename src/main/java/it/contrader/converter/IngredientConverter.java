package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.IngredientDTO;
import it.contrader.model.Ingredient;

@Component
public class IngredientConverter extends AbstractConverter<Ingredient,IngredientDTO> {
	
	@Override
	public Ingredient toEntity(IngredientDTO ingDTO) {
		Ingredient ing = null;
		if(ingDTO!=null) {
			ing = new Ingredient(ingDTO.getId(),ingDTO.getName(),ingDTO.getUrlImg()); 
		}
		return ing;
	}
	
	@Override
	public IngredientDTO toDTO(Ingredient ing) {
		IngredientDTO ingDTO = null;
		if (ing!=null) {
			ingDTO = new IngredientDTO(ing.getId(),ing.getName(),ing.getUrlImg());
		}
		return ingDTO;
	}
}
