package it.contrader.dto;

public class IngredientDTO{
	private String category;
	private String name;
	private float weight;
	private int id;
	private float cal;
	private float carb;
	private float prot;
	private float fat;
	
	public IngredientDTO() {
		
	}
	public IngredientDTO(int id, String category, String name, float weight, float cal, float prot, float fat, float carb) {
		this.category = category;
		this.name = name;
		this.cal = cal;
		this.carb = carb;
		this.prot = prot;
		this.fat = fat;
		this.weight = weight;
		this.id = id;
	}
	public IngredientDTO(String category, String name, float weight, float cal, float prot, float fat, float carb) {
		this.category = category;
		this.name = name;
		this.cal = cal;
		this.carb = carb;
		this.prot = prot;
		this.fat = fat;
		this.weight = weight;
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

	public float getProt() {
		return prot;
	}

	public void setProt(float prot) {
		this.prot = prot;
	}

	public float getFat() {
		return this.fat;
	}

	public void setFat(float fat) {
		this.fat = fat;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
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
		return  id + "\t "  + category +"\t\t " +   name + "\t\t " + weight + "\t\t  " +   cal+"\t\t  " +   carb + "\t\t  " + prot + "\t\t  " + fat ;
	}
}