package it.contrader.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.converter.DessertConverter;
import it.contrader.dto.DessIngrDTO;
import it.contrader.dto.DessertDTO;
import it.contrader.dto.IngredientDTO;
import it.contrader.model.Dessert;
import it.contrader.service.DessIngrService;
import it.contrader.service.DessertApi;
import it.contrader.service.DessertService;
import it.contrader.service.IngredientService;


/**
 * 
 * Questa classe estende AbstractController con tipo UserDTO.
 * In aggiunta ai metodi di CRUD si implementa il metodo di login.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @param<UserDTO>
 * 
 * @see AbstractController
 *
 */
@RestController
@RequestMapping("/dessert")
@CrossOrigin(origins = "http://localhost:4200")
public class DessertController extends AbstractController<DessertDTO>{
	
	@Autowired
	private DessertService dessertService;
	@Autowired
	private DessertApi dessertApi;
	@Autowired
	private DessertConverter dessertconverter;
	@Autowired
	DessIngrService diservice;
	@Autowired
	IngredientService ingrService;
	
	
	// da qui API
    @GetMapping("/dessert")
  //  @GetMapping(value="/search")
     public DessertDTO Dessert(Dessert dessert) throws ClientProtocolException, IOException, Exception {

    	
    	DessertApi mc = new DessertApi();
    	String name = mc.getName();
    	
    	if (dessertService.findByName(name) == null) {
    		String results = dessertApi.httpGet(name);
    
            
              
             JSONObject jsonObj = new JSONObject(results);
 
         
         	
         	String s= new String(jsonObj.get("nutrition").toString());

        	
        	 JSONObject jsonObj2 = new JSONObject(s);
        	
        	 JSONArray nutrients = new JSONArray(jsonObj2.get("nutrients").toString());
        	 
        		String w= new String(jsonObj2.get("weightPerServing").toString());
             	 JSONObject jsonObj3 = new JSONObject(w);
             	 //System.out.println("wheigt "+jsonObj3.get("amount")+jsonObj3.get("unit"));
        	int length = nutrients.length();
        	float cal=1;
          	float fat=1;
        	float carb=1;
        	float pro=1;
       	
        	for (int i=0; i<length; i++) {
        		JSONObject jnut = nutrients.getJSONObject(i);
        		if(jnut.get("title").toString().equals("Calories")) {
        			 cal= Float.parseFloat(jnut.get("amount").toString());
        			}
        		
       		     else if(jnut.get("title").toString().equals("Fat")) {
       			 fat=Float.parseFloat(jnut.get("amount").toString());    }
        		
        		else if(jnut.get("title").toString().equals("Carbohydrates")) {
      			 carb=Float.parseFloat(jnut.get("amount").toString());}
       		
        		else if(jnut.get("title").toString().equals("Protein")) {
       			 pro=Float.parseFloat(jnut.get("amount").toString());
       			 
       	                      	
        	        	}
        }
        	//da qui prende gli ingredienti
        	JSONArray ingr = new JSONArray(jsonObj.get("extendedIngredients").toString());
       	 //System.out.println(ingr);
       	List<String> ingredient = new LinkedList<String>();
    	List<String> extIngr = new LinkedList<String>();
       	 int lengthI = ingr.length();
       	 
       	       for (int i=0; i<lengthI; i++) {
           		JSONObject jingr = ingr.getJSONObject(i);
           		//System.out.println(jingr.get("originalName"));
               //	System.out.println(""+jingr.get("amount")+jingr.get("unit"));
               	ingredient.add(jingr.get("originalName").toString());
               	extIngr.add(jingr.get("originalName").toString()+" "+jingr.get("amount").toString()+jingr.get("unit").toString());
       	 }
       	 //a qui
       	    if (dessertService.findByName(jsonObj.get("title").toString()) == null) {
        	 dessert  = new Dessert(Long.parseLong(jsonObj.get("id").toString()),jsonObj.get("title").toString(),jsonObj.get("instructions").toString(),
        		Integer.parseInt(jsonObj.get("servings").toString()),Integer.parseInt(jsonObj.get("readyInMinutes").toString()),
        		Float.parseFloat(jsonObj3.get("amount").toString()),cal,carb,pro,fat,jsonObj.get("image").toString());  
       // System.out.println(ingredient);
      //  System.out.println(extIngr);
       
        dessertService.insert(dessertconverter.toDTO(dessert));
        
       // System.out.println( dessertconverter.toDTO(dessert));
        }
       //
       	    else {
 			System.out.println("in databese");
 		
 		}
        //
    		}else {
    			System.out.println("in databese");
    		
    		}
    	return dessertService.findByName(name);
    	}
    	
	
}