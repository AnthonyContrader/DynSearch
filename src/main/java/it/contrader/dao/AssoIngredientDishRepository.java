package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.AssoIngredientDish;
import it.contrader.model.Dish;
import it.contrader.model.Ingredient;

@Repository
@Transactional
public interface AssoIngredientDishRepository extends CrudRepository<AssoIngredientDish, Long> {
	List<AssoIngredientDish> findByDish(Dish dish);
	void deleteByDish(Dish dish);
	List<AssoIngredientDish> findByIngredient(Ingredient ingredient);
}