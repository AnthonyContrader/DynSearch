package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.CarDTO;
import it.contrader.service.Service;
import it.contrader.service.CarService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CarServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<CarDTO> service = new CarService();
		List<CarDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<CarDTO> service = new CarService();
		String mode = request.getParameter("mode");
		CarDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {
//fino qui
		case "CARLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/car/carmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/car/readcar.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/car/updatecar.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String brand = request.getParameter("brand").toString();
			String model = request.getParameter("model").toString();
			
			//Potresti aver sbagliato qui 
			int doors = Integer.parseInt(request.getParameter("doors").toString());
			float engineCapacity = Float.parseFloat(request.getParameter("engineCapacity").toString());
			
			
			dto = new CarDTO (brand,model,doors,engineCapacity);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/car/usermanager.jsp").forward(request, response);
			break;
			
			
		case "UPDATE":
			brand = request.getParameter("brand");
			model = request.getParameter("model");
			//potresti aver sbagliato qui			
			doors = Integer.parseInt(request.getParameter("doors"));
			engineCapacity =Float.parseFloat(request.getParameter("engineCapacity"));
			
			id = Integer.parseInt(request.getParameter("id"));
			dto = new CarDTO (id,brand, model, doors, engineCapacity);
			
			//fino qui
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/car/carmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/car/carmanager.jsp").forward(request, response);
			break;
		}
	}
}