package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.contrader.dto.DishDTO;
import it.contrader.service.Service;
import it.contrader.service.DishService;


public class DishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DishServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<DishDTO> service = new DishService();
		List<DishDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

		@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<DishDTO> service = new DishService();
		String mode = request.getParameter("mode");
		DishDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "DISHLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/dish/dishmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/dish/readdish.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/dish/updatedish.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String name = request.getParameter("name").toString();
			Float cal = Float.parseFloat(request.getParameter("cal").toString());
			Float carb = Float.parseFloat(request.getParameter("carb").toString());
			Float fat = Float.parseFloat(request.getParameter("fat").toString());
			Float prot = Float.parseFloat(request.getParameter("prot").toString());
			String category = request.getParameter("category").toString();
			Float weight = Float.parseFloat(request.getParameter("weight").toString());
			
			dto = new DishDTO (name,cal,carb,fat,prot,category,weight);
			
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/dish/dishmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			 
			
			 
			 
			 name = request.getParameter("name");
			 
			try {cal = Float.parseFloat(request.getParameter("cal"));}
			catch(Exception e) {
				cal = dto.getCal();
			}
			
			
			try {carb = Float.parseFloat(request.getParameter("carb"));}
			catch(Exception e) {
				carb = dto.getCarb();
			}
			
			try {fat = Float.parseFloat(request.getParameter("fat"));}
			catch(Exception e) {
				fat = dto.getFat();
			}
			
			try {prot = Float.parseFloat(request.getParameter("prot"));}
			catch(Exception e) {
				prot = dto.getProt();
			}
			
			try {weight = Float.parseFloat(request.getParameter("weight"));}
			catch(Exception e) {
				weight = dto.getWeight();
			}
			
			
	
			
			
			
			
			 
			
			category = request.getParameter("category");

			 id = Integer.parseInt(request.getParameter("id"));
			dto = new DishDTO (id,name,cal,carb,fat,prot,category,weight);
			
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/dish/dishmanager.jsp").forward(request, response);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/dish/dishmanager.jsp").forward(request, response);
			break;
		}
	}
}