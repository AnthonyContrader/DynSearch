package it.contrader.dao;

import javax.transaction.Transactional;
import it.contrader.model.Ingredient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface IngredientRepository extends CrudRepository<Ingredient,Long> {
	
}
