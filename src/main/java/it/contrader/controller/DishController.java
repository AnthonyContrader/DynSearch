package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.DishDTO;
import it.contrader.service.DishApiService;
import it.contrader.service.DishService;

@RestController
@RequestMapping("/dish")
@CrossOrigin(origins = "http://localhost:4200")
public class DishController extends AbstractController<DishDTO> {
	
	@Autowired
	private DishApiService dishApiService;
	@Autowired
	private DishService dishService;
		
	
	@GetMapping(value = "/search")
	
	public List<DishDTO> getDishAPI( @RequestParam("name") String name ) {
		List<DishDTO> dishes;
		if (dishService.findAllByName(name).isEmpty()){
			dishes = dishApiService.getDishesAPI(name);
			return dishes;
		}else {
			return dishService.findAllByName(name);
		}
	}
	
	
}
