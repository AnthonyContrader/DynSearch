package it.contrader.dto;

/**
 * 
 * @author Vittorio
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "User".
 */
public class CarDTO{
	private int id;
	private String brand;
	private String model;
	private int doors;
	private float engineCapacity;
		

	
public CarDTO() {
		
	}
	public CarDTO(int id, String brand, String model, int doors, float engineCapacity) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.doors = doors;
		this.engineCapacity = engineCapacity;
		
	}
	public CarDTO(String brand, String model, int doors, float engineCapacity) {
		this.brand = brand;
		this.model = model;
		this.doors = doors;
		this.engineCapacity = engineCapacity;
	}
	//fino qui
	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public float getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(float engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		
		return  id + "\t" + brand +"\t" +  model + "\t" + doors + "\t\t" +  engineCapacity ;
	}
}
