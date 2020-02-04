package it.contrader.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.contrader.converter.IngredientConverter;
import it.contrader.dto.AssoIngredientDishDTO;
import it.contrader.dto.DishDTO;
import it.contrader.dto.IngredientDTO;

@Service
public class DishApiService {
	
	@Value("${api.key}")
	private String apiKey;
	@Value("${client.id}")
	private String clientId;
	@Value("${client.id1}")
	private String clientId1;
	@Autowired
	RestTemplate rest;
	@Autowired
	IngredientConverter iconverter;
	@Autowired
	AssoIngredientDishService idservice;
	@Autowired
	IngredientService iservice;
	@Autowired
	DishService dservice;
	//metodo richiamato dal controller
	public List<DishDTO> getDishesAPI(String name) {
		
		List<DishDTO> listdish = new ArrayList<DishDTO>();
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
        ResponseEntity<String> response2 = rest.exchange("https://api.spoonacular.com/recipes/search?apiKey="+apiKey+"&query="+name,HttpMethod.GET,entity,String.class);
        JSONObject obj = new JSONObject(response2.getBody());
        final JSONArray results = obj.getJSONArray("results");
        final int n = results.length();
        JSONObject dish;
        for (int i = 0; i < n; ++i) {
        	DishDTO dishdto = new DishDTO();
            dish = results.getJSONObject(i);
            dishdto.setId(dish.getLong("id"));
            dishdto.setName(dish.getString("title"));
            dishdto.setMinutes(dish.getInt("readyInMinutes"));
            dishdto.setServings(dish.getInt("servings"));
            if(dish.has("image")) {
            	dishdto.setUrlImg("https://spoonacular.com/recipeImages/"+dish.getString("image"));
            }else {
            	dishdto.setUrlImg("");
            }
            listdish.add(setDishDTO(dishdto));
          }
		return listdish;
	}
	
	private DishDTO setDishDTO(DishDTO dish) {
		AssoIngredientDishDTO asso;
		List<IngredientDTO> listIng = new ArrayList<IngredientDTO>();
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
        ResponseEntity<String> response = rest.exchange("https://api.spoonacular.com/recipes/"+dish.getId()+"/information?apiKey="+apiKey+"&includeNutrition=true",HttpMethod.GET,entity,String.class);
        
        JSONObject obj = new JSONObject(response.getBody());
        
        dish.setVegetarian(obj.getBoolean("vegetarian"));
        try {
        	dish.setDescri(obj.getString("instructions"));
        }catch(Exception e){
        }
		JSONObject objn = obj.getJSONObject("nutrition");
		JSONObject weight = objn.getJSONObject("weightPerServing");
		dish.setWeight(weight.getFloat("amount"));
		final JSONArray listNutri = objn.getJSONArray("nutrients");
        int n = listNutri.length();
        String title;
        for (int i = 0; i < n; ++i) {
            	final JSONObject nutritions = listNutri.getJSONObject(i);
            	title= nutritions.getString("title");
            	switch (title) {
            	case "Calories":
            		dish.setCal(nutritions.getFloat("amount"));
            		break;
            	case "Fat":
            		dish.setFat(nutritions.getFloat("amount"));
            		break;
            	case "Carbohydrates":
            		dish.setCarb(nutritions.getFloat("amount"));
            		break;
            	case "Protein":
            		dish.setProt(nutritions.getFloat("amount"));
            		break;
            	default:
            		
            	} 		
         }
        
        if(dservice.findByName(dish.getName())==null) {
        	dish = dservice.insert(dish);
        }else {
        	dish.setId(dservice.findByName(dish.getName()).getId());
        }
        listIng= getListIngredient(dish,response);
        final JSONArray listIngr = objn.getJSONArray("ingredients");
        int x=0;
        for(IngredientDTO i : listIng) {
        	final JSONObject ingredients = listIngr.getJSONObject(x);
        	asso=new AssoIngredientDishDTO();
        	asso.setWeight(ingredients.getFloat("amount"));
        	asso.setUnit(ingredients.getString("unit"));
        	asso.setDish(dish);
        	if(iservice.findByName(i.getName())==null) {
        		try {
        			i=iservice.insert(i);
        		}catch(Exception e) {
        		}
        		asso.setIngredient(i);
        	}else {
        		asso.setIngredient(iservice.findByName(i.getName()));
        	}
        	idservice.insert(asso);
        	x++;
        }
        return dish;
	}
	private List<IngredientDTO> getListIngredient(DishDTO dish,ResponseEntity<String> response){
		List<IngredientDTO> listIng = new ArrayList<IngredientDTO>();
		IngredientDTO ingDTO = new IngredientDTO();
        JSONObject obj = new JSONObject(response.getBody());
        JSONObject obji = obj.getJSONObject("nutrition");
        final JSONArray listIngr = obji.getJSONArray("ingredients");
        
        int n = listIngr.length();
        for(int i=0 ; i < n ; i++) {
        	ingDTO = new IngredientDTO();
        	final JSONObject ingredients = listIngr.getJSONObject(i);
        	ingDTO.setName(ingredients.getString("name"));
        	ingDTO=setUrlImgIng(ingDTO);
        	listIng.add(ingDTO);
        }
        return listIng;
	}
	private IngredientDTO setUrlImgIng( IngredientDTO ing) {
		ResponseEntity<String> response;
		response = null;
		try {
			response = rest.exchange("https://api.unsplash.com/search/photos?page=1&query="+ing.getName()+"&client_id="+clientId,HttpMethod.GET,null,String.class);
		}catch(Exception e) {
			response = rest.exchange("https://api.unsplash.com/search/photos?page=1&query="+ing.getName()+"&client_id="+clientId1,HttpMethod.GET,null,String.class);
		}
		JSONObject obj = new JSONObject(response.getBody());
		JSONArray results = obj.getJSONArray("results");
		if(!results.isEmpty()) {
			final JSONObject objn= results.getJSONObject(0);
			obj=objn.getJSONObject("urls");
			ing.setUrlImg(obj.getString("small"));
			try{
				Thread.sleep(25);
			}catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
		}
		return ing;
	}
}
