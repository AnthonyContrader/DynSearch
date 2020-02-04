package it.contrader.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.contrader.dao.IngredientRepository;
import it.contrader.dto.IngredientDTO;
import it.contrader.model.Ingredient;

@Service
public class IngredientService extends AbstractService<Ingredient,IngredientDTO> {
	
	List<IngredientDTO> findAllByName(String name){
		return converter.toDTOList(((IngredientRepository)repository).findAllByName(name));
	}
	IngredientDTO findByName(String name) {
		return converter.toDTO(((IngredientRepository)repository).findByName(name));
	}
}
