package it.contrader.model;

import javax.persistence.Entity;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import it.contrader.dto.CocktailDTO;
import it.contrader.dto.IngredientDTO;
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
public class CocktailToIngredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name="id_cocktail", nullable=false)
    private Cocktail cocktail;
	
	@ManyToOne
    @JoinColumn(name="id_ingredient", nullable=false)
    private Ingredient ingredient;

	
	
	@Column(unique = true)
	private float measure;
	private String unity;
	
	
	
	
	
	
	
}
