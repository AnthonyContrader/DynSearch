package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CarDTO;

import it.contrader.model.Car;

@Component
public class CarConverter extends AbstractConverter<Car, CarDTO> {

	@Override
	public Car toEntity(CarDTO carDTO) {
		Car car = null;
		if (carDTO != null) {
				
			car = new Car(carDTO.getId(),
						carDTO.getBrand(),
						carDTO.getModel(),
						carDTO.getDoors(),
						carDTO.getEngineCapacity());
		
		}
		return car;
	}

	@Override
	public CarDTO toDTO(Car car) {
		CarDTO carDTO = null;
		if (car != null) {
			carDTO = new CarDTO(car.getId(),
					car.getBrand(),
					car.getModel(),
					car.getDoors(), 
				car.getEngineCapacity());


		}
		return carDTO;
	}
}