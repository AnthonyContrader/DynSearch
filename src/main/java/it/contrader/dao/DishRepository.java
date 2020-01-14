package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Dish;

@Repository
@Transactional
public interface DishRepository extends CrudRepository<Dish,Long> {
}
