package it.contrader.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.contrader.dao.DishRepository;
import it.contrader.dto.DishDTO;
import it.contrader.model.Dish;

@Service
public class DishService extends AbstractService<Dish,DishDTO> {
	
	public List<DishDTO> findAllByName(String name) {
		return converter.toDTOList(((DishRepository)repository).findAllByName(name));
	}
	public DishDTO findByName(String name) {
		return converter.toDTO(((DishRepository)repository).findByName(name));
	}
}
