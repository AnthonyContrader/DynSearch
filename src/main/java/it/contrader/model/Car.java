package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Car {

//child manytoone

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column // (unique = true)
	private String brand;
	
	private String model;
	
	private int doors;
	//da qui
		
	//private int idEngine; //diventerà foreign key
	
@ManyToOne
@JoinColumn(name = "idEngine", referencedColumnName="id" )
private Engine engine;


}
