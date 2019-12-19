package it.contrader.dto;


public class CookingMetodDTO {
	
	private int id;
	private String name;
	private String desc;
	private int cookingTime;
	
	public CookingMetodDTO(int cookingTime, String name, String desc) {
		this.name = name;
		this.desc = desc;
		this.cookingTime = cookingTime;
	}
	public CookingMetodDTO(int id, int cookingTime, String name, String desc) {
		this.id = id; 
		this.name = name;
		this.desc = desc;
		this.cookingTime = cookingTime;
	} 

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getCookingTime() {
		return cookingTime;
	}
	public void setCookingTime(int cookingTime) {
		this.cookingTime = cookingTime;
	}
	
	@Override
	public String toString() {
		return id + "\t" + name + "\t\t" + desc + "\t\t" + cookingTime;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CookingMetodDTO other = (CookingMetodDTO) obj;
		if (cookingTime != other.cookingTime)
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}