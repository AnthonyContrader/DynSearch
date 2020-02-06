package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.DishDTO;
import it.contrader.model.Dish;

@Component
public class DishConverter extends AbstractConverter<Dish , DishDTO> {
	@Override
	public Dish toEntity (DishDTO dishDTO) {
		Dish dish = null;
		if (dishDTO != null) {
			dish= new Dish(dishDTO.getId(),
							dishDTO.getName(),
							dishDTO.getDescri(),
							dishDTO.getUrlImg(),
							dishDTO.getMinutes(),
							dishDTO.isVegetarian(),
							dishDTO.getServings(),
							dishDTO.getWeight(),
							dishDTO.getCal(),
							dishDTO.getCarb(),
							dishDTO.getProt(),
							dishDTO.getFat());
		}
		return dish;
	}
	@Override
	public DishDTO toDTO(Dish dish) {
		DishDTO dishDTO = null;
		if (dish != null) {
			dishDTO= new DishDTO(dish.getId(),
							dish.getName(),
							dish.getDescri(),
							dish.getUrlImg(),
							dish.getMinutes(),
							dish.isVegetarian(),
							dish.getServings(),
							dish.getWeight(),
							dish.getCal(),
							dish.getCarb(),
							dish.getProt(),
							dish.getFat());
		}
		return dishDTO;
	}
}
