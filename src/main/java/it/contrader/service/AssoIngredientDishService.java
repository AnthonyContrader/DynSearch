package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.AssoIngredientDishConverter;
import it.contrader.dao.AssoIngredientDishRepository;
import it.contrader.dto.AssoIngredientDishDTO;
import it.contrader.model.AssoIngredientDish;

@Service
public class AssoIngredientDishService extends AbstractService<AssoIngredientDish,AssoIngredientDishDTO>{
	@Autowired
	private AssoIngredientDishConverter converter;
	@Autowired
	private AssoIngredientDishRepository repository;
	
	public List<AssoIngredientDishDTO> findAllByIddish(Long iddish) {
		return converter.toDTOList(repository.findAllByDish(iddish));
	}
}
