package com.tejait.batch8.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/communication")

public class CommunicationController {
	
	/*
	 * @GetMapping("getTemplatedata") public String getData(){ RestTemplate
	 * template=new RestTemplate(); String
	 * response=template.getForObject("http://localhost:8081/restTemplate/test",
	 * String.class); return response;
	 * 
	 * }
	 */
	 
	@GetMapping("getTemplateData")
	public ResponseEntity<String>getData(){
		RestTemplate template=new RestTemplate();
		String response=template.getForObject("http://localhost:8081/restTemplate/test", String.class);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

}
