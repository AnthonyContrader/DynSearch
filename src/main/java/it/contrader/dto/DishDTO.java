package it.contrader.dto;

public class DishDTO {
	
	private int id;
	
	private float cal;
	
	private float carb;
	
	private float fat;
	
	private float prot;
	
	private String category;
	
	private String name;
	
	private float weight;
	
public DishDTO() {
		
	}
public DishDTO(String name, float cal, float carb, float fat, float prot, String category, float weight) {
	
	
	this.cal = cal;
	this.carb = carb;
	this.fat = fat;
	this.prot = prot;
	this.category = category;
	this.name = name;
	this.weight = weight;
	
	}

public DishDTO(int id,  String name, float cal, float carb, float fat, float prot, String category, float weight) {

	this.id = id;
	this.cal = cal;
	this.carb = carb;
	this.fat = fat;
	this.prot = prot;
	this.category = category;
	this.name = name;
	this.weight = weight;

}


	
public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public float getCal() {
	return cal;
}


public void setCal(float cal) {
	this.cal = cal;
}


public float getCarb() {
	return carb;
}


public void setCarb(float carb) {
	this.carb = carb;
}


public float getFat() {
	return fat;
}


public void setFat(float fat) {
	this.fat = fat;
}


	public float getProt() {
		return prot;
	}


	public void setProt(float prot) {
		this.prot = prot;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getWeight() {
		return weight;
	}


	public void setWeight(float weight) {
		this.weight = weight;
	}



@Override
	public String toString() {
		return id + "\t" + name + "\t"  + carb +"\t\t" +   fat + "\t\t" + prot + "\t\t" + category + "\t\t" + weight;
	}
	
}