package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Ingredient;
@Repository
@Transactional
public interface IngredientRepository extends CrudRepository<Ingredient,Long> {
}
