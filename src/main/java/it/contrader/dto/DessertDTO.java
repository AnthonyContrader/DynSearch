package it.contrader.dto;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//import it.contrader.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO della classe User. Ha gli stessi attributi di User
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see User
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id") // serve? a cosa? collegamentp front-end?
public class DessertDTO {

	private long id;
	
	private String name;
	
	private String recipe;
	
	private int servings;
	
	private int minutes;
	
	private float weight;
	
	private float calories;
	
	private float carb;
	
	private float pro;
	
	private float fat;
	
	private String image;

	
	

}
