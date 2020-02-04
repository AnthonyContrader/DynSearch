package it.contrader.service;

import org.springframework.stereotype.Component;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

@Component
public class DessertApi {
	
	
	private final CloseableHttpClient httpClient = HttpClients.createDefault();



String name="pancake";

public String getName() {
    return name;
  }

public String httpGet(String id) throws ClientProtocolException, IOException {
	

       HttpGet request = new HttpGet("https://api.spoonacular.com/recipes/search?apiKey=773eec3422f144ceb791a4d11571c0e2&query="+ name);
		

   

       try (CloseableHttpResponse response = httpClient.execute(request)) {
       	
     
           
       HttpEntity entity = response.getEntity();
       Header headers = entity.getContentType();
     
        
	            
               String result = EntityUtils.toString(entity);
              
               int b = result.lastIndexOf("]");
               
               StringBuilder build = new StringBuilder(result);
               build.delete(b+1, build.length()-1);
              
              result = build.toString();
              
              JSONObject jsonObj = new JSONObject(result);

              JSONArray results = jsonObj.getJSONArray("results");
             
           
              JSONObject jObj1 = results.getJSONObject(1);
         
          	String idR = jObj1.get("id").toString();
          	
          	 HttpGet request2 = new HttpGet("https://api.spoonacular.com/recipes/"+idR+"/information?includeNutrition=true&apiKey=773eec3422f144ceb791a4d11571c0e2");
           	
             
             try (CloseableHttpResponse response2 = httpClient.execute(request2)) {
 	        	
 	          
 	                       
 	            
          HttpEntity entity2 = response2.getEntity();
          Header headers2 = entity2.getContentType();
 	    
 	         	 	            
 	                String resul2 = EntityUtils.toString(entity2);
 	               
               
               return resul2;
              
       

               	}
       }
           
         
           
        

       }
}

	

