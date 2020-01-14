package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssoIngredientDishDTO {
	private Long id;
	private IngredientDTO ingredient;
	private DishDTO dish;
}
