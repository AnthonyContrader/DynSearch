package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Car {

	/**
	 * Qui sotto definisco gli attributi di User. 
	 */
	private int id;

	private String brand;
	
	private String model;
	
	private int doors;
	
	private float engineCapacity;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
	 */
	public Car() {
		
	}

	public Car (int id, String brand, String model, int doors, float engineCapacity ) {
		this.brand = brand;
		this.model = model;
		this.doors = doors;
		this.engineCapacity = engineCapacity;
		this.id = id; 
		}

	
	
	public Car( String brand, String model, int doors, float engineCapacity  ) {
		this.brand = brand;
		this.model = model;
		this.doors = doors;
		this.engineCapacity = engineCapacity;
	}
	
	
	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di User
	 */
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
	
	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  id + "\t"  + brand +"\t\t" +   model + "\t\t" + doors + "\t\t"  + engineCapacity  ;
	}

	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (id != other.id)
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (doors == 0) {
			if (other.doors != 0)
				return false;
		} else if (doors != other.doors)
			return false;
		if (engineCapacity == 0) {
			if (other.engineCapacity != 0)
				return false;
		} else if (engineCapacity != other.engineCapacity)
			return false;
		
	
		return true;
	}
}
