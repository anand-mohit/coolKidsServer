package com.Kewl.coolKids.services;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestCallService {
	
	public static ResponseEntity<Object> makeGetHttpCall(String url,Class clazz)
	{
		RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    return restTemplate.exchange(url, HttpMethod.GET, entity, clazz);
	     
	}
	
	public static Object makePostHttpCall(String url,Object postObject,Class clazz)
	{
	    final String uri = "http://localhost:8080/springrestexample/employees";
	    RestTemplate restTemplate = new RestTemplate();
	    return restTemplate.postForObject( uri, postObject, clazz);
	 
	}

}
