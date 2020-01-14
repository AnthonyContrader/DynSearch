package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.IngredientDTO;
import it.contrader.service.IngredientService;

@Controller
@RequestMapping(value = "/ingredient")
public class IngredientController {
	@Autowired
	IngredientService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "/ingredient/ingredients";
	}
	
	private void setAll (HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "/ingredient/ingredients";
	}
	
	@PostMapping("/insert")
	public String insert (HttpServletRequest request,@RequestParam("name") String name, @RequestParam("category") String category, 
			@RequestParam("weight") float weight, @RequestParam("cal") float cal, @RequestParam("carb") float carb, @RequestParam("prot") float prot, @RequestParam("fat") float fat) {
		IngredientDTO dto = new IngredientDTO();
		dto.setName(name);
		dto.setCategory(category);
		dto.setWeight(weight);
		dto.setCal(cal);
		dto.setCarb(carb);
		dto.setProt(prot);
		dto.setFat(fat);
		service.insert(dto);
		setAll(request);
		return "/ingredient/ingredients";
	}
	
	@GetMapping("/read")
	public String read (HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto",service.read(id));
		return "ingredient/readingredient";
	}
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "/ingredient/updateingredient";
	}
	
	@PostMapping("/update")
	public String update (HttpServletRequest request,@RequestParam("id") Long id,@RequestParam("name") String name, @RequestParam("category") String category, 
			@RequestParam("weight") float weight, @RequestParam("cal") float cal, @RequestParam("carb") float carb, @RequestParam("prot") float prot, @RequestParam("fat") float fat) {
		IngredientDTO dto = new IngredientDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setCategory(category);
		dto.setWeight(weight);
		dto.setCal(cal);
		dto.setCarb(carb);
		dto.setProt(prot);
		dto.setFat(fat);
		service.update(dto);
		setAll(request);
		return "/ingredient/ingredients";
	}
}
