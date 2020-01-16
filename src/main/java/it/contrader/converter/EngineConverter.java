package it.contrader.converter;


import org.springframework.stereotype.Component;

import it.contrader.dto.EngineDTO;

import it.contrader.model.Engine;


@Component
public class EngineConverter extends AbstractConverter<Engine, EngineDTO> {


	@Override
	public Engine toEntity(EngineDTO engineDTO) {
		Engine engine = null;
		if (engineDTO != null) {
				
			engine = new Engine(engineDTO.getId(),
						engineDTO.getName(),
						engineDTO.getHorsepower(),
						engineDTO.getCapacity()
						);
			
		}
		return engine;
	}

	@Override
	public EngineDTO toDTO(Engine engine) {
		EngineDTO engineDTO = null;
		if (engine != null) {
			engineDTO = new EngineDTO(engine.getId(),
					engine.getName(),
					engine.getHorsepower(),
					engine.getCapacity()
					);


		}
		return engineDTO;
	}
}