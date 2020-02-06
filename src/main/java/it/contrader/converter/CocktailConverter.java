package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CocktailDTO;

import it.contrader.model.Cocktail;

/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Stefano Mazzeo
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class CocktailConverter extends AbstractConverter<Cocktail,CocktailDTO> {

	@Override
	public Cocktail toEntity(CocktailDTO cocktailDTO) {
		Cocktail cocktail = null;
		if (cocktailDTO != null) {
			cocktail = new Cocktail(cocktailDTO.getId(),cocktailDTO.getName(),cocktailDTO.getType(),cocktailDTO.getIsAlcohol(),cocktailDTO.getAVG(),cocktailDTO.getAlcohol(),cocktailDTO.getImage());			
		}
		return cocktail;
	}

	@Override
	public CocktailDTO toDTO(Cocktail cocktail) {
		CocktailDTO cocktailDTO = null;
		if (cocktail != null) {
			cocktailDTO = new CocktailDTO (cocktail.getId(),cocktail.getName(),cocktail.getType(),cocktail.getIsAlcohol(),cocktail.getAVG(),cocktail.getAlcohol(),cocktail.getImage());			
		}
		return cocktailDTO;
	}
	
	
}