package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.IngredientDTO;
import it.contrader.service.IngredientService;
import it.contrader.service.Service;




public class IngredientServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public IngredientServlet() {
		
	}
	
	public void updateList(HttpServletRequest request) {
		Service<IngredientDTO> service = new IngredientService();
		List<IngredientDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<IngredientDTO> service = new IngredientService();
		String mode = request.getParameter("mode");
		IngredientDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "INGREDIENTLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/ingredient/ingredientmanager.jsp").forward(request, response);
			break;
			

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/ingredient/readingredient.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/ingredient/updateingredient.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String category = request.getParameter("category").toString();
			String name = request.getParameter("name").toString();
			Float weight = Float.parseFloat(request.getParameter("weight").toString());
			Float cal = Float.parseFloat(request.getParameter("cal").toString());
			Float carb = Float.parseFloat(request.getParameter("carb").toString());
			Float prot = Float.parseFloat(request.getParameter("prot").toString());
			Float fat = Float.parseFloat(request.getParameter("fat").toString());
			dto = new IngredientDTO (category,name,weight,cal,carb,prot,fat);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/ingredient/ingredientmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			category = request.getParameter("category").toString();
			name = request.getParameter("name").toString();
			id = Integer.parseInt(request.getParameter("id"));
			IngredientDTO rea = service.read(id);
			try {
					weight = Float.parseFloat(request.getParameter("weight").toString());
			}catch(Exception e) {
				weight=rea.getWeight();
			}
			try {
					cal = Float.parseFloat(request.getParameter("cal").toString());
			}catch(Exception e) {
				cal=rea.getCal();
			}
			try {
					carb = Float.parseFloat(request.getParameter("carb").toString());
			}catch(Exception e) {
				carb=rea.getCarb();
			}
			try {
					prot = Float.parseFloat(request.getParameter("prot").toString());
			}catch(Exception e) {
				prot=rea.getProt();
			}
			try {
					fat = Float.parseFloat(request.getParameter("fat").toString());
			}catch(Exception e) {
				fat=rea.getFat();
			}
			
			dto = new IngredientDTO (id,category,name,weight,cal,carb,prot,fat);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/ingredient/ingredientmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/ingredient/ingredientmanager.jsp").forward(request, response);
			break;
		}
	}
}
