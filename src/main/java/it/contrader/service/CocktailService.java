package it.contrader.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.CocktailConverter;
import it.contrader.dao.CocktailRepository;
import it.contrader.dto.CocktailDTO;
import it.contrader.model.Cocktail;

@Service
public class CocktailService extends AbstractService<Cocktail, CocktailDTO> {


}
