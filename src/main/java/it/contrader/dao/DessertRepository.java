package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Dessert;
import it.contrader.model.User;


/**
 * Estende CrudRepository ed eredita tutti i metodi di CRUD. 
 * Definisce il metodo di login.
 * 
 *
 * @see CrudRepository
 *
 */
@Repository
@Transactional
public interface DessertRepository extends CrudRepository<Dessert, Long>{
	
	Dessert findByName(String name);
		
}
