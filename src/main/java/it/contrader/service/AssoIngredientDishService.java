package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.AssoIngredientDishConverter;
import it.contrader.converter.DishConverter;
import it.contrader.dao.AssoIngredientDishRepository;
import it.contrader.dto.AssoIngredientDishDTO;
import it.contrader.dto.DishDTO;
import it.contrader.model.AssoIngredientDish;

@Service
public class AssoIngredientDishService extends AbstractService<AssoIngredientDish,AssoIngredientDishDTO>{
	@Autowired
	private AssoIngredientDishConverter converter;
	@Autowired
	private AssoIngredientDishRepository repository;
	@Autowired
	private DishConverter converterDish;
	
	public List<AssoIngredientDishDTO> findByDish(DishDTO dish) {
		return converter.toDTOList(repository.findByDish(converterDish.toEntity(dish)));
	}
	public void deleteByDish(DishDTO dish) {
		 repository.deleteByDish(converterDish.toEntity(dish));
	}
}
