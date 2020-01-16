package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.CarDTO;
//import it.contrader.model.User.Usertype;
import it.contrader.service.CarService;
import it.contrader.service.EngineService;

@Controller
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService service;
	@Autowired
	private EngineService serviceEng;


	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "/car/cars";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "/car/cars";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		request.getSession().setAttribute("listEng", serviceEng.getAll());
		return "/car/updatecar";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("brand") String brand,
			@RequestParam("model") String model, @RequestParam("doors") int doors, @RequestParam("idEngine") Long idEngine) {

		CarDTO dto = new CarDTO();
		dto.setId(id);
		dto.setBrand(brand);
		dto.setModel(model);
		dto.setDoors(doors);
		dto.setEngine(serviceEng.read(idEngine));
		
		service.update(dto);
		setAll(request);
		return "/car/cars";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request,  @RequestParam("brand") String brand,
			@RequestParam("model") String model, @RequestParam("doors") int doors, @RequestParam("idEngine") Long idEngine) {
		
		CarDTO dto = new CarDTO();
		dto.setBrand(brand);
		dto.setModel(model);
		dto.setDoors(doors);
		dto.setEngine(serviceEng.read(idEngine));
		service.insert(dto);
		setAll(request);
		return "/car/cars";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
	   return "/car/readcar";
	}

//	@GetMapping("/logout")
//	public String logout(HttpServletRequest request) {
//		request.getSession().invalidate();
//		return "index";
//	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
		request.getSession().setAttribute("listEng", serviceEng.getAll());
	}
}
