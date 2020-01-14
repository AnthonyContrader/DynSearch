package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, length = 40)
	private String name;
	@Column(length = 40)
	private String category;
	@Column (columnDefinition = "float default 100")
	private Float weight;
	@Column(nullable = true)
	private float cal;
	private float carb;
	private float prot;
	private float fat;
}
