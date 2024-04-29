package com.tejait.batch8.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.tejait.batch8.builderdesignpattren.ApiResponse;

import com.tejait.batch8.model.Employee;


public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmps();

	void deleteByEmpId(Integer id);

	Employee getById(Integer id);

	List<Employee> findAllEmps();

	List<Employee> getDatabasedOndept(String dept);

	List<Employee> getDatabasedOnsalary(long salary);

	
	List<Employee> getDatabasedOnlastnameAndfirstname(String lname, String fname);
	

	List<Employee> getDatabasedLnameAndFname(String lname, String fname);

	List<Employee> getAgeLessthan(int age);

	List<Employee> getBySalaryBetween(long salary1, long salary2);

	List<Employee> getByOrderbyAge(int age);

	List<Employee> getDatabasedLnameOrFname(String lname, String fname);

	List<Employee> getByLnameIs(String lname);


	List<Employee> getByFnameStartingWith(String fname);


	List<Employee> getBynameContaining(String lname);

	List<Employee> getByFnameEndingWith(String fname);

	List<Employee> searchFiltersOnEmpcode(String filterType, String empCode);

	List<Employee> searchEmployeeData(String searchTerm);

	Page<Employee> getPageEmployees(int pageNum, int recordsSize);

	List<Employee> getAges(ArrayList<Integer> ageList);

	 List<Employee> getAllEmployeesSorted(String sortField, Sort.Direction direction);

	List<Employee> getEmployeesInDepartments(List<String> dept);

	//List<Employee> getAllEmployeesSorted(String orderType, String property);

	List<Employee> getAllEmployeeSorted(String orderType, String property);

	boolean existId(Integer id);

	ResponseEntity<ApiResponse> fetchEmpsData(HttpHeaders headers);

	
	
	

	

	

}
