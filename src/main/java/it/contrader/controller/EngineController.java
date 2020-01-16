package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.EngineDTO;
//import it.contrader.model.User.Usertype;
import it.contrader.service.EngineService;

@Controller
@RequestMapping("/engine")
public class EngineController {

	@Autowired
	private EngineService service;


	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "/engine/engines";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "/engine/engines";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "/engine/updatengine";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("horsepower") int horsepower, @RequestParam("capacity") float capacity) {

		EngineDTO dto = new EngineDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setHorsepower(horsepower);
		dto.setCapacity(capacity);
		service.update(dto);
		setAll(request);
		return "/engine/engines";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request,  @RequestParam("name") String name,
			@RequestParam("horsepower") int horsepower, @RequestParam("capacity") float capacity) {
		EngineDTO dto = new EngineDTO();
		dto.setName(name);
		dto.setHorsepower(horsepower);
		dto.setCapacity(capacity);
		service.insert(dto);
		setAll(request);
		return "/engine/engines";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "/engine/readengine";
	}

//	@GetMapping("/logout")
//	public String logout(HttpServletRequest request) {
//		request.getSession().invalidate();
//		return "index";
//	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
