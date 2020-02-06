package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.DessertDTO;

import it.contrader.model.Dessert;

/**
 * Questa classe implementa i metodi di conversione dell'entità Car.
 *  

 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class DessertConverter extends AbstractConverter<Dessert,DessertDTO> {

	@Override
	public Dessert toEntity(DessertDTO dessertDTO) {
		Dessert dessert = null;
		if (dessertDTO != null) {
			dessert = new Dessert(dessertDTO.getId(),dessertDTO.getName(),dessertDTO.getRecipe(),dessertDTO.getServings(),dessertDTO.getMinutes(),dessertDTO.getWeight(),dessertDTO.getCalories(),dessertDTO.getCarb(),dessertDTO.getPro(),dessertDTO.getFat(),dessertDTO.getImage());			
		}
		return dessert;
	}

	@Override
	public DessertDTO toDTO(Dessert dessert) {
		DessertDTO dessertDTO = null;
		if (dessert != null) {
			dessertDTO = new DessertDTO(dessert.getId(),dessert.getName(),dessert.getRecipe(),dessert.getServings(),dessert.getMinutes(),dessert.getWeight(),dessert.getCalories(),dessert.getCarb(),dessert.getPro(),dessert.getFat(),dessert.getImage());
			
		}
		return dessertDTO;
	}
}