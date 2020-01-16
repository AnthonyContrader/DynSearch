package it.contrader.dto;


//import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {
	private Long id;
	private String name;
	private String category;
	private Float weight;
	private float cal;
	private float carb;
	private float prot;
	private float fat;
	//private List<AssoIngredientDishDTO> listAssoIngrDishDTO;

}
