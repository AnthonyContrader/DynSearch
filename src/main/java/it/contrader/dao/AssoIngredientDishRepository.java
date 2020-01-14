package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.AssoIngredientDish;

@Repository
@Transactional
public interface AssoIngredientDishRepository extends CrudRepository<AssoIngredientDish, Long> {
	List<AssoIngredientDish> findAllByDish(Long iddish);
}
