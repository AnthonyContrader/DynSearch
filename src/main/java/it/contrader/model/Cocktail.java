package it.contrader.model;

import javax.persistence.Entity;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 

 * 
 * @author Stefano Mazzeo
 * 
 * @see CocktailDTO
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cocktail {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String name;
	private String type;
	private int isAlcohol;
	private int AVG;
	private String alcohol;
	private String image;
	
	
}
