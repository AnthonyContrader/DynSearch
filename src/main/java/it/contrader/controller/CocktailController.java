package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.CocktailDTO;
import it.contrader.service.CocktailService;

@Controller
@RequestMapping(value = "/cocktail")
public class CocktailController {

	@Autowired
	
	private CocktailService service;



	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "/cocktail/cocktail";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "/cocktail/coktail";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "/cocktail/updatecocktail";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, 
			@RequestParam("id") Long id,
			@RequestParam("name") String name,
			@RequestParam("type") String type, 
			@RequestParam("isAlcohol") boolean isAlcohol,
			@RequestParam("AVG") int AVG, 
			@RequestParam("alcohol") String alcohol
			) {

		CocktailDTO dto = new CocktailDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setType(type);
		dto.setIsAlcohol(isAlcohol);
		dto.setAVG(AVG);
		dto.setAlcohol(alcohol);
		
		service.update(dto);
		setAll(request);
		return "/cocktail/cocktail";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, 
			@RequestParam("name") String name,
			@RequestParam("type") String type, 
			@RequestParam("isAlcohol") boolean isAlcohol,
			@RequestParam("AVG") int AVG, 
			@RequestParam("alcohol") String alcohol
			
			) {
		CocktailDTO dto = new CocktailDTO();
		dto.setName(name);
		dto.setType(type);
		dto.setIsAlcohol(isAlcohol);
		dto.setAVG(AVG);
		dto.setAlcohol(alcohol);
		service.insert(dto);
		setAll(request);
		return "/cocktail/cocktail";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, 
			@RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "/cocktail/readcocktail";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
