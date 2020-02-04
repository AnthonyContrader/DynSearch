package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {
	
	private Long id;
	private String name;
	private String descri;
	private String urlImg;
	private int minutes;
	private boolean vegetarian;
	private int servings;
	private float weight;
	private float cal;
	private float carb;
	private float prot;
	private float fat;
}

