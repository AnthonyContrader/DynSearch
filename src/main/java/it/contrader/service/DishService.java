package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.DishConverter;
import it.contrader.dao.DishRepository;
import it.contrader.dto.DishDTO;
import it.contrader.model.Dish;

@Service
public class DishService extends AbstractService<Dish,DishDTO> {
	@Autowired
	private DishConverter converter;
	@Autowired
	private DishRepository repository;
}
