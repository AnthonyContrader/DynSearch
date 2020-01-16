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

public class Engine {

//parent onetomany
	@Id
	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//private Car car;
		
@Column  (unique = true)
	private String name;
	
	private int horsepower;
	
	private float capacity;
	

	
	
}
