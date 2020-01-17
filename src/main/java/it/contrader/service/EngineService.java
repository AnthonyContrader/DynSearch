package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.EngineConverter;
import it.contrader.dao.EngineRepository;
//import it.contrader.converter.CarConverter;
//import it.contrader.dao.CarRepository;
import it.contrader.dto.EngineDTO;
import it.contrader.model.Engine;

@Service
public class EngineService extends AbstractService<Engine, EngineDTO> {

	@Autowired
	private EngineConverter converter;
	@Autowired
	private EngineRepository repository;

	 
//	public UserDTO findByUsernameAndPassword(String username, String password) {
//		return converter.toDTO(repository.findByUsernameAndPassword(username, password));
//	}
}
