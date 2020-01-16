package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CocktailDTO;

import it.contrader.model.Cocktail;

@Component
public class CocktailConverter extends AbstractConverter<Cocktail, CocktailDTO> {

	@Override
	public Cocktail toEntity(CocktailDTO cocktailDTO) {
		Cocktail cocktail = null;
		if (cocktailDTO != null) {
			cocktail = new Cocktail(cocktailDTO.getId(), 
					cocktailDTO.getName(), 
					cocktailDTO.getType(), 
					cocktailDTO.isIsAlcohol(),
					cocktailDTO.getAVG(),
					cocktailDTO.getAlcohol()
					);
		}
		return cocktail;
	}

	@Override
	public CocktailDTO toDTO(Cocktail cocktail) {
		CocktailDTO cocktailDTO = null;
		if (cocktail != null) {
			cocktailDTO = new CocktailDTO(cocktail.getId(), 
					cocktail.getName(), 
					cocktail.getType(), 
					cocktail.isAlcohol(),
					cocktail.getAVG(),
					cocktail.getAlcohol()
					);

		}
		return cocktailDTO;
	}
}