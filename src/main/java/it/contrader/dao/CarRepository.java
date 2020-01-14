package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Car;


@Repository
@Transactional
public interface CarRepository extends CrudRepository<Car, Long> {

	//User findByUsernameAndPassword(String username, String password);

}
