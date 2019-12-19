package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CookingMetodDTO;
import it.contrader.model.CookingMetod;

//classe per convertire da DTO a entita e viceversa, ma anche da lista di entita a lista DTO
public class CookingMetodConverter{
	
	public CookingMetodDTO toDTO (CookingMetod cookingMetod) {
		CookingMetodDTO cookingMetodDTO = new CookingMetodDTO(cookingMetod.getId(), cookingMetod.getCookingTime(), cookingMetod.getName(), cookingMetod.getDesc());
		return cookingMetodDTO;
	}
	public CookingMetod toEntity(CookingMetodDTO cookingMetodDTO) {
		CookingMetod cookingMetod = new CookingMetod(cookingMetodDTO.getId(), cookingMetodDTO.getCookingTime(), cookingMetodDTO.getName(), cookingMetodDTO.getDesc());
		return cookingMetod;
	}
	public List<CookingMetodDTO> toDTOList(List<CookingMetod> cookingMetodList){
		List<CookingMetodDTO> cookingMetodDTOList = new ArrayList<CookingMetodDTO>();
		for(CookingMetod cookingMetod : cookingMetodList ) {
			cookingMetodDTOList.add(toDTO(cookingMetod));
		}
		return cookingMetodDTOList;
	}
}