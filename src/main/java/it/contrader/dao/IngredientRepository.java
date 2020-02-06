package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;
import it.contrader.model.Ingredient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface IngredientRepository extends CrudRepository<Ingredient,Long> {
	List<Ingredient> findAllByName(String name);
	Ingredient findByName(String name);
}
