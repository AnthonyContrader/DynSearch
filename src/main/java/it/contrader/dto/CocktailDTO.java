package it.contrader.dto;

import it.contrader.model.Cocktail.Cocktailtype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CocktailDTO {
	private Long id;
	

	private String name;
	
	private String type;
	
	private boolean IsAlcohol;
	
	private int AVG;
	
	private String alcohol;

}
