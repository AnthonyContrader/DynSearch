package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Engine;


@Repository
@Transactional
public interface EngineRepository extends CrudRepository<Engine, Long> {

	

}
