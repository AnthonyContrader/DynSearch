package it.contrader.dto;

//import it.contrader.model.User.Usertype;
//import it.contrader.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CarDTO {

	private Long id;

	private String brand;

	private String model;
	
	private int doors;
	
	private float engineCapacity;

	//private Usertype usertype;

}
