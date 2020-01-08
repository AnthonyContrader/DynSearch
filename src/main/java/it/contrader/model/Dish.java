package it.contrader.model;

public class Dish {

	private int id;
	
	private float cal;
	
	private float carb;
	
	private float fat;
	
	private float prot;
	
	private String category;
	
	private String name;
	
	private float weight;
	
	
	public Dish() {
		
	}

public Dish(String name, float cal, float carb, float fat, float prot, String category, float weight) {
		
		this.cal = cal;
		this.carb = carb;
		this.fat = fat;
		this.prot = prot;
		this.category = category;
		this.name = name;
		this.weight = weight;
		
		}
	
public Dish(int id, String name, float cal, float carb, float fat, float prot, String category, float weight) {
		
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
	
	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dish other = (Dish) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		if (cal == 0.0f) {
			if (other.cal != 0.0f)
				return false;
		} else if (cal != (other.cal))
			return false;
		if (name == null) {
			if (other.cal != 0.0f)
				return false;
		} else if (cal != (other.cal))
			return false;
		
		if (carb == 0.0f) {
			if (other.carb != 0.0f)
				return false;
		} else if (carb != (other.carb))
			return false;
		if (name == null) {
			if (other.carb != 0.0f)
				return false;
		} else if (carb != (other.carb))
			return false;
		
		if (fat == 0.0f) {
			if (other.fat != 0.0f)
				return false;
		} else if (fat != (other.fat))
			return false;
		if (name == null) {
			if (other.fat != 0.0f)
				return false;
		} else if (fat != (other.fat))
			return false;
		
		
		if (prot == 0.0f) {
			if (other.prot != 0.0f)
				return false;
		} else if (prot != (other.prot))
			return false;
		if (name == null) {
			if (other.prot != 0.0f)
				return false;
		} else if (prot != (other.prot))
			return false;
		
		
		
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		
		
		
		if (weight == 0.0f) {
			if (other.weight != 0.0f)
				return false;
		} else if (weight != (other.weight))
			return false;
		if (weight == 0.0f) {
			if (other.weight != 0.0f)
				return false;
		} else if (weight != (other.weight))
			return false;
		return true;
		
		
	}}
	

