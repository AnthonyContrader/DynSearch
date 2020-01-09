package it.contrader.service;

import it.contrader.converter.CocktailConverter;
import it.contrader.dao.CocktailDAO;
import it.contrader.dto.CocktailDTO;
import it.contrader.model.Cocktail;

public class CocktailService extends AbstractService<Cocktail,CocktailDTO>{
	public CocktailService(){
		this.dao = new CocktailDAO();
		this.converter = new CocktailConverter();
	}
}
