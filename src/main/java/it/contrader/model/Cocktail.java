package it.contrader.model;

public class Cocktail {
	private String name;
	private String type;
	private boolean isAlcohol;
	private int AVG;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cocktail (int id, String name, String type, boolean isAlcohol, int AVG) {
		this.setName(name);
		this.setType(type);
		this.setIsAlcohol(isAlcohol);
		this.setAVG(AVG);
		this.setId(id);
	}
	
	public Cocktail(String name, String type, boolean isAlcohol, int AVG) {
		this.setName(name);
		this.setType(type);
		this.setIsAlcohol(isAlcohol);
		this.setAVG(AVG);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean getIsAlcohol() {
		return isAlcohol;
	}

	public void setIsAlcohol(boolean isAlcohol) {
		this.isAlcohol = isAlcohol;
	}

	public int getAVG() {
		return this.AVG;
	}

	public void setAVG(int aVG) {
		this.AVG = aVG;
	}
	
	@Override
	public String toString() {
		String alcohol;
		alcohol = isAlcohol  ? "Alcohol" : "NO Alcohol";
		return   name +"\t\t" +   type + "\t\t" + alcohol + "\t\t"  +   AVG ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cocktail other = (Cocktail) obj;
		if (AVG != other.AVG)
			return false;
		if (id != other.id)
			return false;
		if (isAlcohol != other.isAlcohol)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}
