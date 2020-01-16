package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Cocktail;

@Repository
@Transactional
public interface CocktailRepository extends CrudRepository<Cocktail, Long> {

	

}
