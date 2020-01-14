package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.AssoIngredientDishDTO;
import it.contrader.dto.DishDTO;
import it.contrader.service.AssoIngredientDishService;
import it.contrader.service.DishService;
import it.contrader.service.IngredientService;
import it.contrader.dto.IngredientDTO;

@Controller
@RequestMapping("/dish")
public class DishController {
	@Autowired
	DishService service;
	@Autowired
	AssoIngredientDishService serviceAsso;
	@Autowired
	IngredientService ingredientService;
	
	private void setAllIng(HttpServletRequest request,@RequestParam("id") Long id) {
		List<AssoIngredientDishDTO> assoListDTO = new ArrayList<AssoIngredientDishDTO>();
		List<IngredientDTO> listIngredientsDTO = new ArrayList<IngredientDTO>();
		assoListDTO=serviceAsso.findAllByIddish(id);
		for(AssoIngredientDishDTO assoDTO : assoListDTO) {
			listIngredientsDTO.add(assoDTO.getIngredient());
		}
		request.getSession().setAttribute("listIngredients", listIngredientsDTO);
	}
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
		request.getSession().setAttribute("listAllIngr", ingredientService.getAll());
	}
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "/dish/dishes";
	}
	@GetMapping("/read")
	public String read (HttpServletRequest request,@RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		setAllIng(request, id);
		return "/dish/readdish";
	}
	@GetMapping("/preupdate")
	public String preUpdate (HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "/dish/updatedish";
	}
	@PostMapping("/update")
	public String update (HttpServletRequest request,@RequestParam("idIngredients")Long[] idingredients,@RequestParam("id") Long id,@RequestParam("name") String name, @RequestParam("category") String category, 
			@RequestParam("weight") float weight, @RequestParam("cal") float cal, @RequestParam("carb") float carb, @RequestParam("prot") float prot, @RequestParam("fat") float fat) {
		DishDTO dto = new DishDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setCategory(category);
		dto.setCal(cal);
		dto.setCarb(carb);
		dto.setWeight(weight);
		dto.setProt(prot);
		dto.setProt(prot);
		dto.setFat(fat);
		service.update(dto);
		setAll(request);
		return "dish/dishes";
	}
	@PostMapping("/insert")
	public String insert(HttpServletRequest request ,@RequestParam("name") String name, @RequestParam("category") String category, 
			@RequestParam("weight") float weight, @RequestParam("cal") float cal, @RequestParam("carb") float carb, @RequestParam("prot") float prot, @RequestParam("fat") float fat) {
		DishDTO dto = new DishDTO();
		dto.setName(name);
		dto.setCategory(category);
		dto.setCal(cal);
		dto.setCarb(carb);
		dto.setWeight(weight);
		dto.setProt(prot);
		dto.setProt(prot);
		dto.setFat(fat);
		
		service.insert(dto);
		setAll(request);
		return "/dish/dishes";
	}
	@GetMapping("/delete")
	public String delete (HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "/dish/dishes";
	}
}
