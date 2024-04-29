package com.tejait.batch8.dtodesignpattren;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController {  
	@Autowired
	PersonService service;
	@PostMapping("savePersonCard")
	public ResponseEntity<PersonCardRequestDto> savePersonCard(@RequestBody PersonCardRequestDto request){
	PersonCardRequestDto dto=service.savePersonCard(request);
		return new ResponseEntity<PersonCardRequestDto>(dto,HttpStatus.OK );				
	}
	@GetMapping("getPersonCard")
	public ResponseEntity<List<PersonCardResponseDto>> getAllPersonCardData(){
		List<PersonCardResponseDto> responseList=service.getAllPersonCardDetails();
		return new ResponseEntity<>(responseList,HttpStatus.OK);
	}

}
