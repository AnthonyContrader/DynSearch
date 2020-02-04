package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Dish")
public class Dish {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String name;
	@Column(columnDefinition="TEXT")
	private String descri;
	@Column
	private String urlImg;
	private int minutes;
	private boolean vegetarian;
	private int servings;
	private float weight;
	private float cal;
	private float carb;
	private float prot;
	private float fat;
}
