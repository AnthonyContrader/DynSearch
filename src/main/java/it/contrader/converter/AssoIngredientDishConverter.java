package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.AssoIngredientDishDTO;
import it.contrader.model.AssoIngredientDish;
@Component
public class AssoIngredientDishConverter extends AbstractConverter<AssoIngredientDish,AssoIngredientDishDTO>{
	private DishConverter dConverter = new DishConverter();
	private IngredientConverter iConverter = new IngredientConverter();
	
	public AssoIngredientDish toEntity (AssoIngredientDishDTO assoIngredientDishDTO) {
		AssoIngredientDish assoIngredientDish =  null;
		if(assoIngredientDishDTO!=null) {
			assoIngredientDish = new AssoIngredientDish(assoIngredientDishDTO.getId(),
														iConverter.toEntity(assoIngredientDishDTO.getIngredient()),
														dConverter.toEntity(assoIngredientDishDTO.getDish()));
		}
		return assoIngredientDish;
	}
	
	public AssoIngredientDishDTO toDTO(AssoIngredientDish assoIngredientDish) {
		AssoIngredientDishDTO assoIngredientDishDTO =  null;
		if(assoIngredientDish!=null) {
			assoIngredientDishDTO = new AssoIngredientDishDTO(assoIngredientDish.getId(),
														iConverter.toDTO(assoIngredientDish.getIngredient()),
														dConverter.toDTO(assoIngredientDish.getDish()));
		}
		return assoIngredientDishDTO;
	}
}
