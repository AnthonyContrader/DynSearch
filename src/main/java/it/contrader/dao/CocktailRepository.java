package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Cocktail;
import it.contrader.model.User;


/**
 * Estende CrudRepository ed eredita tutti i metodi di CRUD. 
 * Definisce il metodo di login.
 * 
 * @author Stefano Mazzeo
 *
 * @see CrudRepository
 *
 */
@Repository
@Transactional
public interface CocktailRepository extends CrudRepository<Cocktail, Long>{
	
	Cocktail findByName(String name);
	

	
	
}
