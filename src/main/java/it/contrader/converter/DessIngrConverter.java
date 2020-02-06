
package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.DessIngrDTO;

import it.contrader.model.DessIngr;

@Component
public class DessIngrConverter extends AbstractConverter<DessIngr,DessIngrDTO> {

	@Autowired
	private DessertConverter dessertconverter;
	@Autowired
	private IngredientConverter iConverter;
	
	public DessIngr toEntity (DessIngrDTO dessIngrDTO) {
		DessIngr dessIngr =  null;
		if(dessIngrDTO!=null) {
			dessIngr = new DessIngr(dessIngrDTO.getId(),
														iConverter.toEntity(dessIngrDTO.getIngredient()),
														dessertconverter.toEntity(dessIngrDTO.getDessert()));
		}
		return dessIngr;
	}
	
	public DessIngrDTO toDTO(DessIngr dessIngr) {
		DessIngrDTO dessIngrDTO =  null;
		if(dessIngr!=null) {
			dessIngrDTO = new DessIngrDTO(dessIngr.getId(),
														iConverter.toDTO(dessIngr.getIngredient()),
														dessertconverter.toDTO(dessIngr.getDessert()));
		}
		return dessIngrDTO;
	}
}
