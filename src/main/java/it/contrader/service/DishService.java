package it.contrader.service;

import java.util.List;

import it.contrader.converter.DishConverter;

import it.contrader.dao.DishDAO;

import it.contrader.dto.DishDTO;


public class DishService {
	
	private DishDAO dishDAO;
	private DishConverter dishConverter;
	
	//Istanzio DAO  e Converter specifici.
	public DishService(){
		this.dishDAO = new DishDAO();
		this.dishConverter = new DishConverter();
	}
	
	public List<DishDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return dishConverter.toDTOList(dishDAO.getAll());
	}
	
	public DishDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return dishConverter.toDTO(dishDAO.read(id));
	}
	
	public boolean insert(DishDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return dishDAO.insert(dishConverter.toEntity(dto));
	}
	
	public boolean update(DishDTO dto) {
		// Converte un userDTO in entità e lo passa allo userDAO per la modifica
		return dishDAO.update(dishConverter.toEntity(dto));
	}
	
	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return dishDAO.delete(id);
	}
	
}
	
	
	