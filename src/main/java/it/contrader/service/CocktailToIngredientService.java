package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.CocktailRepository;
import it.contrader.dao.CocktailToIngredientRepository;
import it.contrader.dto.CocktailDTO;
import it.contrader.dto.CocktailToIngredientDTO;
import it.contrader.model.Cocktail;

import it.contrader.model.CocktailToIngredient;

/**
 * Estende AbstractService con parametri User e UserDTO. 
 * Implementa il metodo di login ed eredita quelli Abstract. 
 * 
 * @author Stefano Mazzeo
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class CocktailToIngredientService extends AbstractService<CocktailToIngredient,CocktailToIngredientDTO> {


		
	//	public CocktailToIngredientDTO findByName(String name) {
		//	return converter.toDTO(((CocktailRepository)repository).findByName(name));
			
		
				
	
	
	//ALL crud methods in AbstractService
	//	}
}
