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
	IngredientService ingrService;
	
	private void getAllIng(HttpServletRequest request) {
		List<AssoIngredientDishDTO> assoListDTO = new ArrayList<AssoIngredientDishDTO>();
		List<IngredientDTO> listIngredientsDTO = new ArrayList<IngredientDTO>();
		List<DishDTO> listDishDTO = new ArrayList<DishDTO>();
		listDishDTO=service.getAll();
		for(DishDTO dish : listDishDTO) {
			assoListDTO=serviceAsso.findByDish(dish);
			listIngredientsDTO = new ArrayList<IngredientDTO>();
			for(AssoIngredientDishDTO assoDTO : assoListDTO) {
				listIngredientsDTO.add(assoDTO.getIngredient());
			}
			request.getSession().setAttribute("listIngredients"+dish.getId(), listIngredientsDTO);
		}
		
	}
	private void deleteAllIng(Long id) {
		List<AssoIngredientDishDTO> assoListDTO = new ArrayList<AssoIngredientDishDTO>();
		DishDTO dishDTO = new DishDTO();
		dishDTO=service.read(id);
		assoListDTO=serviceAsso.findByDish(dishDTO);
		for(AssoIngredientDishDTO assoDTO : assoListDTO) {
			serviceAsso.delete(assoDTO.getId());;
		}
		
	}
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
		request.getSession().setAttribute("listAllIngr", ingrService.getAll());
		
	}
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		getAllIng(request);
		return "/dish/dishes";
	}
	@GetMapping("/read")
	public String read (HttpServletRequest request,@RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		getAllIng(request);
		return "/dish/readdish";
	}
	@GetMapping("/preupdate")
	public String preUpdate (HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		request.getSession().setAttribute("listAllIngr", ingrService.getAll());
		return "/dish/updatedish";
	}
	@PostMapping("/update")
	public String update (HttpServletRequest request,
							@RequestParam("idingr")Long[] idingr,
							@RequestParam("id") Long id,
							@RequestParam("name") String name, 
							@RequestParam("category") String category, 
							@RequestParam("weight") float weight, 
							@RequestParam("cal") float cal, 
							@RequestParam("carb") float carb, 
							@RequestParam("prot") float prot, 
							@RequestParam("fat") float fat){
		DishDTO dto = new DishDTO();
		AssoIngredientDishDTO assoDTO = new AssoIngredientDishDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setCategory(category);
		dto.setCal(cal);
		dto.setCarb(carb);
		dto.setWeight(weight);
		dto.setProt(prot);
		dto.setProt(prot);
		dto.setFat(fat);
		dto=service.update(dto);
		deleteAllIng(dto.getId());
		for(Long x : idingr) {
			assoDTO.setDish(dto);
			assoDTO.setIngredient(ingrService.read(x));
			serviceAsso.update(assoDTO);
		}
		getAllIng(request);
		setAll(request);
		return "dish/dishes";
	}
	@PostMapping("/insert")
	public String insert(HttpServletRequest request ,
							@RequestParam("idingr") Long[] idingr,
							@RequestParam("name") String name, 
							@RequestParam("category") String category, 
							@RequestParam("weight") float weight, 
							@RequestParam("cal") float cal, 
							@RequestParam("carb") float carb, 
							@RequestParam("prot") float prot, 
							@RequestParam("fat") float fat) {
		DishDTO dto = new DishDTO();
		AssoIngredientDishDTO assoDTO = new AssoIngredientDishDTO();
		dto.setName(name);
		dto.setCategory(category);
		dto.setCal(cal);
		dto.setCarb(carb);
		dto.setWeight(weight);
		dto.setProt(prot);
		dto.setFat(fat);
		dto=service.insert(dto);
		for(Long x : idingr) {
			assoDTO.setDish(dto);
			assoDTO.setIngredient(ingrService.read(x));
			serviceAsso.insert(assoDTO);
		}
		getAllIng(request);
		setAll(request);
		return "/dish/dishes";
	}
	@GetMapping("/delete")
	public String delete (HttpServletRequest request, @RequestParam("id") Long id) {
		DishDTO dish =service.read(id);
		serviceAsso.deleteByDish(dish);
		service.delete(id);
		getAllIng(request);
		setAll(request);
		return "/dish/dishes";
	}
}
