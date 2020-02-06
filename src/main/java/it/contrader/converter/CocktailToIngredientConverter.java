package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.CocktailToIngredientDTO;

import it.contrader.model.CocktailToIngredient;

/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Stefano Mazzeo
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class CocktailToIngredientConverter extends AbstractConverter<CocktailToIngredient,CocktailToIngredientDTO> {
	@Autowired
	private CocktailConverter cconverter;
	@Autowired
	private IngredientConverter iconverter;
	@Override
	public CocktailToIngredient toEntity(CocktailToIngredientDTO cocktailToIngredientDTO) {
		CocktailToIngredient cocktailToIngredient = null;
		if (cocktailToIngredientDTO != null) {
			cocktailToIngredient = new CocktailToIngredient(cocktailToIngredientDTO.getId(),
															cconverter.toEntity(cocktailToIngredientDTO.getCocktailDTO()),
															iconverter.toEntity(cocktailToIngredientDTO.getIngredientDTO()),
															cocktailToIngredientDTO.getMeasure(),
															cocktailToIngredientDTO.getUnity());			
		}
		return cocktailToIngredient;
	}

	@Override
	public CocktailToIngredientDTO toDTO(CocktailToIngredient cocktailToIngredient) {
		CocktailToIngredientDTO cocktailToIngredientDTO = null;
		if (cocktailToIngredient != null) {
			cocktailToIngredientDTO = new CocktailToIngredientDTO (cocktailToIngredient.getId(),
																cconverter.toDTO(cocktailToIngredient.getCocktail()),
																iconverter.toDTO(cocktailToIngredient.getIngredient()),
																cocktailToIngredient.getMeasure(), 
																cocktailToIngredient.getUnity());			
			}
		return cocktailToIngredientDTO;
	}
	
	
}