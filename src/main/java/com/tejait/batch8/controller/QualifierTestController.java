package com.tejait.batch8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch8.service.CustomerService;

@RestController
@RequestMapping("qualifier")
public class QualifierTestController {
	@Autowired
	@Qualifier("bussiness")
	CustomerService customerService;
	@GetMapping("customer")
	public String getCustomer() {
		return customerService.getCustomerType();
		
	}

}
