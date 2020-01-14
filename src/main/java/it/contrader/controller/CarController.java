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

@Controller
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService service;

//	@PostMapping("/login")
//	public String login(HttpServletRequest request, @RequestParam(value = "username", required = true) String username,
//			@RequestParam(value = "password", required = true) String password) {
//
//		UserDTO userDTO = service.findByUsernameAndPassword(username, password);
//		request.getSession().setAttribute("user", userDTO);
//
//		switch (userDTO.getUsertype()) {
//
//		case ADMIN:
//			return "homeadmin";
//
//		case USER:
//			return "index";
//
//		default:
//			return "index";
//		}
	//}

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "cars";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "cars";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatecar";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("brand") String brand,
			@RequestParam("model") String model, @RequestParam("doors") int doors, @RequestParam("engineCapacity") float engineCapacity) {

		CarDTO dto = new CarDTO();
		dto.setId(id);
		dto.setBrand(brand);
		dto.setModel(model);
		dto.setDoors(doors);
		dto.setEngineCapacity(engineCapacity);
		service.update(dto);
		setAll(request);
		return "cars";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request,  @RequestParam("brand") String brand,
			@RequestParam("model") String model, @RequestParam("doors") int doors, @RequestParam("engineCapacity") float engineCapacity) {
		CarDTO dto = new CarDTO();
		dto.setBrand(brand);
		dto.setModel(model);
		dto.setDoors(doors);
		dto.setEngineCapacity(engineCapacity);
		service.insert(dto);
		setAll(request);
		return "cars";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readcar";
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
