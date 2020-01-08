package it.contrader.model;

public class Ingredient{
	private String category;
	private String name;
	private float weight;
	private int id;
	private float cal;
	private float carb;
	private float prot;
	private float fat;
	
	public Ingredient(int id, String category, String name, float weight, float cal, float carb,float prot, float fat ) {
		this.category = category;
		this.name = name;
		this.cal = cal;
		this.carb = carb;
		this.prot = prot;
		this.fat = fat;
		this.weight = weight;
		this.id = id;
	}
	public Ingredient(String category, String name, float weight, float cal,float carb, float prot, float fat ) {
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
		return  id + "\t"  + category +"\t\t" +   name + "\t\t" + weight + "\t\t"  +   cal+"\t\t" +   carb + "\t\t" + prot + "\t\t" + fat ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		if (id != other.id)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight == 0.0f) {
			if (other.weight != 0.0f)
				return false;
		} else if (weight != other.weight)
			return false;
		if (cal == 0.0f) {
			if (other.cal != 0.0f)
				return false;
		} else if (cal != other.cal)
			return false;
		if (carb == 0.0f) {
			if (other.carb != 0.0f)
				return false;
		} else if (carb != other.carb)
			return false;
		if (prot == 0.0f) {
			if (other.prot != 0.0f)
				return false;
		} else if (prot != other.prot)
			return false;
		if (fat == 0.0f) {
			if (other.fat != 0.0f)
				return false;
		} else if (fat != other.fat)
			return false;
	
		return true;
	}
}