package it.contrader.model;

public class Nutrient{
	
	private Float calorie;
	
	private Float carboidrati;
	
	private Float proteine;
	
	private Float grassi;
	
	public Nutrient() {
		
	}
	
	public Nutrient(Float calorie, Float carboidrati, Float proteine, Float grassi) {
		this.calorie = calorie;
		this.carboidrati = carboidrati;
		this.proteine = proteine;
		this.grassi = grassi;
		
	}

	public Float getCalorie() {
		return calorie;
	}

	public void setCalorie(Float calorie) {
		this.calorie = calorie;
	}

	public Float getCarboidrati() {
		return carboidrati;
	}

	public void setCarboidrati(Float carboidrati) {
		this.carboidrati = carboidrati;
	}

	public Float getProteine() {
		return proteine;
	}

	public void setProteine(Float proteine) {
		this.proteine = proteine;
	}

	public Float getGrassi() {
		return grassi;
	}

	public void setGrassi(Float grassi) {
		this.grassi = grassi;
	}
	
	
}