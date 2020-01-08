package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.CarDTO;
import it.contrader.model.Car;

/**
 * 
 * @author Vittorio
 * 
 * 
 *
 */
public class CarConverter  implements Converter<Car, CarDTO> {
	
	/**
	
	 */
	@Override
	public CarDTO toDTO(Car car) {
		CarDTO carDTO = new CarDTO(car.getId(), car.getBrand(), car.getModel(), car.getDoors(), car.getEngineCapacity());
		return carDTO;
	}
	/**
	
	 */
	@Override
	public Car toEntity(CarDTO carDTO) {
		Car car = new Car(carDTO.getId(), carDTO.getBrand(), carDTO.getModel(), carDTO.getDoors(), carDTO.getEngineCapacity());
		return car;
	}
	//fino qui
	/**

	 */
	@Override
	public List<CarDTO> toDTOList(List<Car> carList) {
		//Crea una lista vuota.
		List<CarDTO> carDTOList = new ArrayList<CarDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Car car : carList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			carDTOList.add(toDTO(car));
		}
		return carDTOList;
	}

	
	
}
