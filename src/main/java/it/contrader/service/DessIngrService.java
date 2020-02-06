 package it.contrader.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.DessIngrConverter;
import it.contrader.converter.DessertConverter;
import it.contrader.dao.DessIngrRepository;

import it.contrader.dto.DessIngrDTO;
import it.contrader.dto.DessertDTO;

import it.contrader.model.DessIngr;


// Estende AbstractService con parametri car e carDTO. 

@Service
public class DessIngrService extends AbstractService<DessIngr,DessIngrDTO> {
	
	//ALL crud methods in AbstractService
	@Autowired
	private DessIngrConverter diconverter;
	@Autowired
	private  DessIngrRepository direpository;
	@Autowired
	private DessertConverter dessertconverter;
	
	public List< DessIngrDTO> findByDessert(DessertDTO dessert) {
		return diconverter.toDTOList(direpository.findByDessert(dessertconverter.toEntity(dessert)));
	}
	public void deleteByDish(DessertDTO dish) {
		 direpository.deleteByDessert(dessertconverter.toEntity(dish));
	}
}
	


	
