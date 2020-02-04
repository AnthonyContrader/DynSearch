package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Dish;

@Repository
@Transactional
public interface DishRepository extends CrudRepository<Dish, Long>{
	@Query("SELECT d FROM Dish d WHERE d.name LIKE %:name%")
	List<Dish> findAllByName(String name);
	Dish findByName(String name);
}
