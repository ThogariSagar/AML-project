package com.tejait.batch8.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;
import com.tejait.batch8.builderdesignpattren.ApiResponse;
import com.tejait.batch8.builderdesignpattren.ResponseBuilder;
import com.tejait.batch8.model.Employee;
import com.tejait.batch8.repository.EmployeeRepository;
import com.tejait.batch8.service.EmployeeService;

import com.tejait.batch8.util.SearchFilters;
@Service
public class EmployeeServiceImpl implements EmployeeService {
  @Autowired
	EmployeeRepository empRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		String fname=employee.getFname();
		String lname=employee.getLname();
		String fullname=fname.concat(" "+lname);
		employee.setFullname(fullname);
		  Employee emp=empRepository.save(employee);
		return emp;
	}

	@Override
	public List<Employee> getAllEmps() {
		//List<Employee> list=empRepository.findAll();
		List<Employee> list=empRepository.findAllEmployee();
		return list;
	}

	@Override
	public void deleteByEmpId(Integer id) {
		empRepository.deleteById(id);
		
	}

	@Override
	public Employee getById(Integer id) {
		//Employee empid=empRepository.findById(id).get();
		Optional<Employee> empid=empRepository.findById(id);
		return empid.get() ;
	}

	@Override
	public List<Employee> findAllEmps() {
		//List<Employee> list=empRepository.findAll();
		List<Employee> list=empRepository.findAllEmployee();//custom query
		
		return list;
	}

	@Override
	public List<Employee> getDatabasedOndept(String dept) {
		//List<Employee> list=empRepository.findByDept(dept);
		List<Employee> list=empRepository.findByDepartment(dept);
		//List<Employee> list=empRepository.findByDepartmentdata(dept);
		return list;
		
	}

	@Override
	public List<Employee> getDatabasedOnsalary(long salary) {
		List<Employee> list=empRepository.findBySalary(salary);
		return list;
	}

	@Override
	public List<Employee> getDatabasedOnlastnameAndfirstname(String lname, String fname) {
		List<Employee> list=empRepository.findDistinctByLnameAndFname(lname,fname);
		return list;
	}

	@Override
	public List<Employee> getDatabasedLnameAndFname(String lname, String fname) {
		List<Employee> list=empRepository.findByLnameAndFname(lname,fname);
		return list;
	}

	@Override
	public List<Employee> getAgeLessthan(int age) {
		List<Employee> list=empRepository.findByAgeLessThan(age);
		return list;
	}

	@Override
	public List<Employee> getBySalaryBetween(long salary1, long salary2) {
		 List<Employee> list=empRepository.findBySalaryBetween(salary1,salary2);
		return list;
	}

	@Override
	public List<Employee> getByOrderbyAge(int age) {
		List<Employee> list=empRepository.findByAgeOrderByLnameDesc(age);
		return list;
	}

	@Override
	public List<Employee> getDatabasedLnameOrFname(String lname, String fname) {
		List<Employee> list=empRepository.findByLnameOrFname(lname,fname);
		return list;
	}

	@Override
	public List<Employee> getByLnameIs(String lname) {
	List<Employee>	 list=empRepository.findByLnameIs(lname);
		return list;
	}

	

	@Override
	public List<Employee> getByFnameStartingWith(String fname) {
		List<Employee> list=empRepository.findByfnameStartingWith(fname);
		return list;
	}

	

	@Override
	public List<Employee> getBynameContaining(String lname) {
		List<Employee> list=empRepository.findByLnameContaining(lname);
		return list;
	} 

	@Override
	public List<Employee> getByFnameEndingWith(String fname) {
		List<Employee> list=empRepository.findByfnameEndingWith(fname);
		return list;
	}

	@Override
	public List<Employee> searchFiltersOnEmpcode(String filterType, String empCode) {
		SearchFilters filter=SearchFilters.valueOf(filterType);
		List<Employee> list=new ArrayList<Employee>();
		switch (filter) {//Enaum  --filterType String for Converting to enumn with valueof()
		case startsWith:
			list=empRepository.findByEmpCodeStartingWith(empCode);			
			break;
		case endsWith:
			list=empRepository.findByEmpCodeEndingWith(empCode);			
			break;
		case contains:
			list=empRepository.findByEmpCodeContaining(empCode);			
			break;
		case notContains:
			list=empRepository.findByEmpCodeNotContaining(empCode);			
			break;
		case equals:
			list=empRepository.findByEmpCodeEquals(empCode);			
			break;
		case notEquals: 
			list=empRepository.findByEmpCodeNotContaining(empCode);			
			break;
		}
		
		return list;
	}

	@Override
	public List<Employee> searchEmployeeData(String searchTerm) {
		 List<Employee> list=empRepository.searchEmployeeData(searchTerm);
		return list;
	}

	@Override
	public Page<Employee> getPageEmployees(int pageNum, int recordsSize) {
		Pageable pagable=PageRequest.of(pageNum, recordsSize);
		Page<Employee> pageData=empRepository.findAll(pagable);
		return pageData;
	}

	@Override
	public List<Employee> getAges(ArrayList<Integer> ageList) {
		List<Employee> list=empRepository.findByAgeIn(ageList);
		return list;
	} 

	 
	@Override
	public List<Employee> getAllEmployeesSorted(String sortField, Direction direction) {
		Sort sort = Sort.by(direction, sortField);
		  return empRepository.findAll(sort);
	}

	@Override
	public List<Employee> getEmployeesInDepartments(List<String> dept) {		   
		        return empRepository.findByDeptIn(dept);
		    }

	@Override
	public List<Employee> getAllEmployeeSorted(String orderType, String property) {
	       if(orderType.equalsIgnoreCase("DESC")) {
               return empRepository.findAll(Sort.by(Sort.Direction.DESC,property));
           }
               return empRepository.findAll(Sort.by(Sort.Direction.ASC,property));
       }

	@Override 
	public boolean existId(Integer id) {
		
		return empRepository.existsById(id);
	}

	  @Autowired 
	ResponseBuilder builder;
	@Override
	public ResponseEntity<ApiResponse> fetchEmpsData(HttpHeaders headers) {
		List<Employee> empList=empRepository.findAll();
		return builder.buildResponse(headers,200,"fetching All Emps",empList);
	}

	
	}
	

	


