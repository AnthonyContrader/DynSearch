package it.contrader.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.CocktailDTO;
import it.contrader.service.CocktailApiService;
import it.contrader.service.CocktailService;


/**
 * 
 * Questa classe estende AbstractController con tipo UserDTO.
 * In aggiunta ai metodi di CRUD si implementa il metodo di login.
 * 
 * @author Stefano Mazzeo
 * 
 * @param<CocktailDTO>
 * 
 * @see AbstractController
 *
 */
@RestController
@RequestMapping("/cocktail")
@CrossOrigin(origins = "http://localhost:4200")
public class CocktailController extends AbstractController<CocktailDTO>{
	
	@Autowired
	private CocktailService cocktailService;
	
	
	@Autowired
	
	private CocktailApiService cocktailApiService;
	@GetMapping("/prova")
	
	
	 public String ciao(@RequestParam("name") String fff) throws ClientProtocolException, IOException, Exception {
		 //return cocktailApiService.httpGet("mo");
		String currLine = null;
	String name = "gin" ;
		//String ciiao = "";
	
	System.out.println(cocktailService.findByName(name));
		if (cocktailService.findByName(name) == null) {
			
			// effettua la ricerca API di cocktail DB
			String result = cocktailApiService.httpGet(name);
			
			
			JSONObject jo = new JSONObject(result);
			

			JSONArray loudScreaming = jo.getJSONArray("ingredients");
			
             
		
			String uno = loudScreaming.toString();
            
            int lunghezza = uno.length(); 
            
            String tot = uno.substring(1, lunghezza-1);
            System.out.println(tot);
            JSONObject jo_1 = new JSONObject(tot);
            
            String tipo = jo_1.getString("strType");
           System.out.println(tipo);
           
           String ingrediente = jo_1.getString("strIngredient");
           System.out.println(ingrediente);
           
           String alcolica = jo_1.getString("strAlcohol");
           System.out.println(alcolica);
           int int_alcolica = 0 ;
           if (alcolica != "No") 
           {
        	   int_alcolica = 1;
           } if (alcolica != "Yes")
           {
        	   int_alcolica = 1; 
           }
           
           String gradazione = jo_1.getString("strABV");
           System.out.println(gradazione);
           int int_gradazione = Integer.parseInt(gradazione); 
          
           

           
          String res1 = cocktailApiService.httpGet1(name);
           System.out.println(res1);
			
			JSONObject jo1 = new JSONObject(res1);
			
          JSONArray loudScreaming_1 = jo1.getJSONArray("drinks");
           System.out.println(loudScreaming_1);
			
           String due = loudScreaming_1.toString();
            
           int lunghezza1 = due.length(); 
            System.out.println("ddddddddddddddddd");
           String tot1 = due.substring(1, lunghezza-1);
             System.out.println(tot1);
             
             int i = tot1.indexOf("https");
             System.out.println(i);
             
             String l = tot1.substring(1142, tot.length());
             System.out.println(l);
             
             String m = l.substring(0, l.indexOf("jpg")+3);
             System.out.println(m);
             CocktailDTO cockDTO= new CocktailDTO();
             
             cockDTO.setName(name);
           cockDTO.setType(tipo);
          cockDTO.setIsAlcohol(int_alcolica);
          cockDTO.setAVG(int_gradazione);
          cockDTO.setImage(m);
         
         cocktailService.insert(cockDTO);
           
           
         
             
		
			
		}
			
		//	System.out.println(loudScreaming.toString());
	//	}else {
	//	System.out.println("ss");}
		//System.out.println(cocktailService.findByName(name));
		return currLine;
	 }

	
	

	
	
	
	
	
}