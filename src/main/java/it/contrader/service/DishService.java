package it.contrader.service;

import it.contrader.converter.DishConverter;
import it.contrader.dao.DishDAO;
import it.contrader.dto.DishDTO;
import it.contrader.model.Dish;


public class DishService extends AbstractService<Dish, DishDTO> {
	
	
	public DishService(){
		this.dao = new DishDAO();
		this.converter = new DishConverter();
	}
	

}
