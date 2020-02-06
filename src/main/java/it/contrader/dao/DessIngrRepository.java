
package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.DessIngr;
import it.contrader.model.Dessert;
;



@Repository
@Transactional
public interface DessIngrRepository extends CrudRepository<DessIngr, Long>{
	
	List<DessIngr> findByDessert(Dessert dessert);
	void deleteByDessert(Dessert dessert);
			
}
