package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CocktailDTO;
import it.contrader.model.Cocktail;

public class CocktailConverter implements Converter<Cocktail,CocktailDTO> {
	
	public CocktailDTO toDTO(Cocktail cocktail) {
		CocktailDTO cocktailDTO = new CocktailDTO (cocktail.getId(),cocktail.getName(),cocktail.getType(),cocktail.getIsAlcohol()? 1 : 0,cocktail.getAVG());
		return cocktailDTO;
	}
	public Cocktail toEntity (CocktailDTO cocktailDTO) {
		Cocktail cocktail = new Cocktail (cocktailDTO.getId(),cocktailDTO.getName(),cocktailDTO.getType(),(cocktailDTO.getIsAlcohol()? 1 : 0),cocktailDTO.getAVG());
		return cocktail;
	}
	public List<CocktailDTO> toDTOList (List<Cocktail> cocktailList){
		List<CocktailDTO> cocktailDTOList = new ArrayList<>();
		for(Cocktail cocktail : cocktailList) {
			cocktailDTOList.add(toDTO(cocktail));
		}
		return cocktailDTOList;
	}
}
