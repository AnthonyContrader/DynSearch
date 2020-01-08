package it.contrader.service;

import it.contrader.converter.CarConverter;
import it.contrader.dao.CarDAO;
import it.contrader.dto.CarDTO;
import it.contrader.model.Car;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class CarService extends AbstractService<Car, CarDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public CarService(){
		this.dao = new CarDAO();
		this.converter = new CarConverter();
	}
	

}
