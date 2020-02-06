package it.contrader.service;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;


import org.springframework.stereotype.Service;

import it.contrader.dao.DessertRepository;
import it.contrader.dao.UserRepository;
import it.contrader.dto.DessertDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Dessert;

/**
 * Estende AbstractService con parametri car e carDTO. 
  
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class DessertService extends AbstractService<Dessert,DessertDTO> {
	
	//ALL crud methods in AbstractService
	public DessertDTO findByName(String name) {
		return converter.toDTO(((DessertRepository)repository).findByName(name));
	

}
	}
