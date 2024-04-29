package com.tejait.batch8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch8.model.Employee;
//@RestController     //@RestCpntroller combination ofboth(@controller and @ResponseBody)
@Controller          //if @controller given must should be taken @ResponseBody
@RequestMapping("ctrlTest")
public class ControllerTest {
	@GetMapping("getEmp")
   @ResponseBody
	public Employee getEmployee() {
	 Employee emp=new Employee(101, "ABC", "XYZ", "ABC XYZ","java", 22, 10000L, "ja123va");
	return emp;
	}

}
