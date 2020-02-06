package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.CocktailRepository;
import it.contrader.dao.UserRepository;
import it.contrader.dto.CocktailDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Cocktail;

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
public class CocktailService extends AbstractService<Cocktail,CocktailDTO> {


		
		public CocktailDTO findByName(String name) {
			return converter.toDTO(((CocktailRepository)repository).findByName(name));
			
		
				
	
	
	//ALL crud methods in AbstractService
		}
}
