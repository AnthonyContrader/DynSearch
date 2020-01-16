package it.contrader.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EngineDTO {

	private Long id;

	private String name;

	private int horsepower;
	
	private float capacity;
	
	//private List<CarDTO> carDTO;

}
