package com.tejait.batch8.dtodesignpattren;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class PersonService {
	@Autowired
	PersonRepository repository;

	public PersonCardRequestDto savePersonCard(PersonCardRequestDto request) {
		Person p=convertRequestDtoToEntity(request);	
		  Person response=repository.save(p);
		  PersonCardRequestDto dto=convertEntityToRequestDto(response);
		  return dto;
		
		  
		
	}
	
	public static Person convertRequestDtoToEntity(PersonCardRequestDto request) {
		Person p=new Person();
		p.setPname(request.getPname());
		p.setAge(request.getAge());
		
		CardDetails card =new CardDetails();
		 card.setCardnum(request.getCardnum());
		 card.setHolder(request.getHolder());
		 card.setCvv(request.getCvv());
		 card.setPin(request.getPin());
		  
		 Date date=new Date();
		 card.setCreateDate(date);
		 p.setCarddetails(card);
	  	return p;		
	}
	public static PersonCardRequestDto convertEntityToRequestDto(Person response) {
		 PersonCardRequestDto  dto =new PersonCardRequestDto() ;
		  dto.setPname(response.getPname());
		  dto.setAge(response.getAge());
		  dto.setCardnum(response.getCarddetails().getCardnum());
		  dto.setCvv(response.getCarddetails().getCvv());
		  dto.setHolder(response.getCarddetails().getHolder());
		  dto.setPin(response.getCarddetails().getPin());	  
	    	return dto;
	}

	public List<PersonCardResponseDto> getAllPersonCardDetails() {
		 List<Person> list=repository.findAll();
		return list.stream().map(PersonService::convertEntityToResponseDto).collect(Collectors.toList());
	}
	public static PersonCardResponseDto convertEntityToResponseDto(Person person) {
		PersonCardResponseDto responseDto=new PersonCardResponseDto();
		responseDto.setPname(person.getPname());
		responseDto.setAge(person.getAge());
		responseDto.setHolder(person.getCarddetails().getHolder());
		responseDto.setCardnum(person.getCarddetails().getCardnum());
		return responseDto;
		
	}

}
