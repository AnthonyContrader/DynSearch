package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.IngredientConverter;
import it.contrader.dao.IngredientRepository;
import it.contrader.dto.IngredientDTO;
import it.contrader.model.Ingredient;

@Service
public class IngredientService extends AbstractService<Ingredient, IngredientDTO> {
	@Autowired
	private IngredientConverter converter;
	@Autowired
	private IngredientRepository repository;
}
