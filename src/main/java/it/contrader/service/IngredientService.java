package it.contrader.service;

import java.util.List;


import it.contrader.converter.IngredientConverter;
import it.contrader.dao.IngredientDAO;
import it.contrader.dto.IngredientDTO;

public class IngredientService {
	private IngredientDAO ingredientDAO;
	private IngredientConverter ingredientConverter;
	
	public IngredientService(){
		this.ingredientDAO = new IngredientDAO();
		this.ingredientConverter = new IngredientConverter();
	}
	
	public List<IngredientDTO> getAll() {
		return ingredientConverter.toDTOList(ingredientDAO.getAll());
	}
	
	public IngredientDTO read(int id) {
		return ingredientConverter.toDTO(ingredientDAO.read(id));
	}
	
	public boolean insert(IngredientDTO dto) {
		return ingredientDAO.insert(ingredientConverter.toEntity(dto));
	}
	
	public boolean update(IngredientDTO dto) {
		return ingredientDAO.update(ingredientConverter.toEntity(dto));
	}
	
	public boolean delete(int id) {
		return ingredientDAO.delete(id);
	}
}