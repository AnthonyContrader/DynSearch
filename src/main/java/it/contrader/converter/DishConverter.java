package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DishDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Dish;
import it.contrader.model.User;


public class DishConverter  implements Converter<Dish, DishDTO> {
	
	
	@Override
	public DishDTO toDTO(Dish dish) {
		DishDTO dishDTO = new DishDTO(dish.getId(), dish.getName(), dish.getCal(), dish.getCarb(), dish.getFat(), dish.getProt(),  dish.getCategory(), dish.getWeight());
		return dishDTO;
	}

	
	@Override
	public Dish toEntity(DishDTO dishDTO) {
		Dish dish = new Dish(dishDTO.getId(), dishDTO.getName(), dishDTO.getCal(), dishDTO.getCarb(), dishDTO.getFat(), dishDTO.getProt(), dishDTO.getCategory(), dishDTO.getWeight());
		return dish;
	}
	
	
	@Override
	public List<DishDTO> toDTOList(List<Dish> dishList) {
		
		List<DishDTO> dishDTOList = new ArrayList<DishDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Dish dish : dishList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			dishDTOList.add(toDTO(dish));
		}
		return dishDTOList;
	}

	
	
}
