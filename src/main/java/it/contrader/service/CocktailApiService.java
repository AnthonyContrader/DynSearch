package it.contrader.service;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import it.contrader.dao.CocktailRepository;
import it.contrader.dao.UserRepository;
import it.contrader.dto.CocktailDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Cocktail;

/**
 * Estende AbstractService con parametri User e UserDTO. 
 * Implementa il metodo di login ed eredita quelli Abstract. 
 * 
 * @author Stefano Mazzeo
 * 
 * @see AbstractService
 * @see ServiceDTO
 */

@Service




public class CocktailApiService {
	private final CloseableHttpClient httpClient = HttpClients.createDefault();
	private final CloseableHttpClient httpClient1 = HttpClients.createDefault();
	public String httpGet(String name) throws ClientProtocolException, IOException {
		
		HttpGet request = new HttpGet("https://the-cocktail-db.p.rapidapi.com/search.php?i="+name);
		
        
	       
        // add request headers
        request.addHeader("x-rapidapi-host", "the-cocktail-db.p.rapidapi.com");
        request.addHeader("x-rapidapi-key", "da84a28913msh3dd904b9f6f41b0p113834jsn5afa08941bce");
        

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
           // System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
           // System.out.println(headers);
            String result = EntityUtils.toString(entity);

		return result;
        }	
	}
        
        public String httpGet1(String name) throws ClientProtocolException, IOException {
    		
    		HttpGet request = new HttpGet("https://www.thecocktaildb.com/api/json/v1/1/search.php?s="+name);
    		


            try (CloseableHttpResponse response = httpClient.execute(request)) {

                // Get HttpResponse Status
               // System.out.println(response.getStatusLine().toString());

                HttpEntity entity = response.getEntity();
                Header headers = entity.getContentType();
               // System.out.println(headers);
                String result1 = EntityUtils.toString(entity);

    		return result1;
    		
    	}
		
	
	}
	

}
