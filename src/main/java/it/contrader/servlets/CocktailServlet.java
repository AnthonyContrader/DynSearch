package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.service.CocktailService;
import it.contrader.service.Service;
import it.contrader.dto.CocktailDTO;

public class CocktailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CocktailServlet () {
		
	}
	
	public void updateList (HttpServletRequest request) {
		Service<CocktailDTO> service = new CocktailService();
		List<CocktailDTO> listDTO = service.getAll();
		request.setAttribute("list",listDTO);
	}
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Service<CocktailDTO> service = new CocktailService();
		String mode = request.getParameter("mode");
		CocktailDTO dto;
		int id;
		boolean ans;
		
		switch (mode.toUpperCase()) {
			case "COCKTAILLIST":
				updateList(request);
				getServletContext().getRequestDispatcher("/cocktail/cocktailmanager.jsp").forward(request, response);
				break;
			case "READ":
				id = Integer.parseInt(request.getParameter("id"));
				dto = service.read(id);
				request.setAttribute("dto", dto);
				if (request.getParameter("update") == null) {
					 getServletContext().getRequestDispatcher("/cocktail/readcocktail.jsp").forward(request, response);
				}
				else getServletContext().getRequestDispatcher("/cocktail/updatecocktail.jsp").forward(request, response);
				
				break;
			case "INSERT":
				
				String name = request.getParameter("name").toString();
				String type = request.getParameter("type").toString();
				int alcohol = Integer.parseInt(request.getParameter("alcohol").toString());
				int avg = Integer.parseInt(request.getParameter("avg").toString());
				dto = new CocktailDTO (name,type,alcohol,avg);
				ans = service.insert(dto);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/cocktail/cocktailmanager.jsp").forward(request, response);
				break;
			case "UPDATE":
				name = request.getParameter("name").toString();
				type = request.getParameter("type").toString();
				id = Integer.parseInt(request.getParameter("id"));
				CocktailDTO rea = service.read(id);
				try {
					alcohol = Integer.parseInt(request.getParameter("alcohol").toString());
				}catch(Exception e) {
					alcohol= rea.getIsAlcohol()? 1 : 0;
				}
				try {
					avg = Integer.parseInt(request.getParameter("avg").toString());
				}catch(Exception e) {
					avg = rea.getAVG(); 
				}
				dto = new CocktailDTO (id,name,type,alcohol,avg);
				ans = service.update(dto);
				updateList(request);
				getServletContext().getRequestDispatcher("/cocktail/cocktailmanager.jsp").forward(request, response);
				break;
			case "DELETE":
				id = Integer.parseInt(request.getParameter("id"));
				ans = service.delete(id);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/cocktail/cocktailmanager.jsp").forward(request, response);
				break;
		}
	}
}
