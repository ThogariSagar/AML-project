package com.tejait.batch8.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tejait.batch8.FactoryDesign.FactoryDesignPattern;
import com.tejait.batch8.builderdesignpattren.ApiResponse;
import com.tejait.batch8.exceptionhandling.AppIdNotValidException;
import com.tejait.batch8.exceptionhandling.InsuffiecientBalanceException;
import com.tejait.batch8.exceptionhandling.InvalidCredentialsException;
import com.tejait.batch8.exceptionhandling.InvalidIdException;
import com.tejait.batch8.model.Employee;
import com.tejait.batch8.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

	@Autowired
	EmployeeService empservice;

	@RequestMapping(value = "saveEmp", method = RequestMethod.POST)
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee emp = empservice.saveEmployee(employee);
		ResponseEntity<Employee> response = new ResponseEntity<>(emp, HttpStatus.ACCEPTED);

		return response;

	}

	@PutMapping("update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee emp = empservice.saveEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);

	}

	@GetMapping("getAll")
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> list = empservice.getAllEmps();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@DeleteMapping("deleteEmp/{id}")
	public ResponseEntity<String> deleteByEmplId(@PathVariable Integer id) {
		empservice.deleteByEmpId(id);
		return new ResponseEntity<>("Succesfully delete Id " + id, HttpStatus.OK);

	}

	@GetMapping("getById/{id}")
	public ResponseEntity<Employee> getById(@PathVariable Integer id) {
		Employee empid = empservice.getById(id);
		return new ResponseEntity<Employee>(empid, HttpStatus.OK);
	}

	@RequestMapping(value = "findBydept", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findDatabasedOndept(@RequestParam String dept) {
		List<Employee> list = empservice.getDatabasedOndept(dept);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@RequestMapping(value = "findBysalary", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findDatabasedOnsalary(@RequestParam long salary) {
		List<Employee> list = empservice.getDatabasedOnsalary(salary);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@RequestMapping(value = "findDistinctByLnameAndFname", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findDatabasedOnlastnameAndfirstname(@RequestParam String lname,
			String fname) {
		List<Employee> list = empservice.getDatabasedOnlastnameAndfirstname(lname, fname);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@RequestMapping(value = "findBylnameAndfname", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findDatabasedLnameAndFname(@RequestParam String lname, String fname) {
		List<Employee> list = empservice.getDatabasedLnameAndFname(lname, fname);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@RequestMapping(value = "findBylnameOrfname", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findDatabasedLnameOrFname(@RequestParam String lname, String fname) {
		List<Employee> list = empservice.getDatabasedLnameOrFname(lname, fname);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@RequestMapping(value = "findByAgeLessthan", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findByAgeLessthan(@RequestParam int age) {
		List<Employee> list = empservice.getAgeLessthan(age);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "findBySalaryBetween", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findBySalaryBetween(@RequestParam long salary1, long salary2) {
		List<Employee> list = empservice.getBySalaryBetween(salary1, salary2);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "findByOrderByage", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findByOrderbyAge(@RequestParam int age) {
		List<Employee> list = empservice.getByOrderbyAge(age);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "findBylnameIs", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findBylnameIs(@RequestParam String lname) {
		List<Employee> list = empservice.getByLnameIs(lname);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@RequestMapping(value = "findByFnameStartswith", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findByFnameStartingWith(@RequestParam String fname) {
		List<Employee> list = empservice.getByFnameStartingWith(fname);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@RequestMapping(value = "findByFnameEndingWith", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findByFnameEndingWith(@RequestParam String fname) {
		List<Employee> list = empservice.getByFnameEndingWith(fname);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@GetMapping("/findByLnameContaing")
	public ResponseEntity<List<Employee>> findByFnameContaining(@RequestParam String lname) {
		List<Employee> list = empservice.getBynameContaining(lname);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@GetMapping("/searchFilters")
	public ResponseEntity<List<Employee>> empCodeSearchFilters(@RequestParam String filterType,
			@RequestParam String empCode) {
		List<Employee> list = empservice.searchFiltersOnEmpcode(filterType, empCode);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	@GetMapping("/search/{searchTerm}")
	public ResponseEntity<List<Employee>> searchEmpsData(@PathVariable String searchTerm) {
		List<Employee> list = empservice.searchEmployeeData(searchTerm);
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@GetMapping("/pagination")
	public Page<Employee> employeePagination(@RequestParam int pageNum, @RequestParam int recordsSize) {
		Page<Employee> pagination = empservice.getPageEmployees(pageNum, recordsSize);
		return pagination;

	}

	@GetMapping("findages")
	public ResponseEntity<List<Employee>> findAges(@RequestParam int age1,int age2, int age3){
	  ArrayList<Integer> ageList=new ArrayList<Integer>(); ageList.add(age1);
	  ageList.add(age2); ageList.add(age3); List<Employee>
	  list=empservice.getAges(ageList); 
	  return new
	  ResponseEntity<>(list,HttpStatus.OK);
	  
	  }
	 

	@GetMapping("/employees")
	public List<Employee> getEmployeesInDepartments(@RequestParam List<String> dept) {
		return empservice.getEmployeesInDepartments(dept);
	}
	
	/*
	 * @GetMapping("/sorted") public List<Employee> getAllEmployeesSorted(
	 * 
	 * @RequestParam(name = "sortField", required = false, defaultValue = "id")
	 * String sortField,
	 * 
	 * @RequestParam(name = "direction", required = false, defaultValue = "ASC")
	 * Sort.Direction direction) { return
	 * empservice.getAllEmployeesSorted(sortField, direction); }
	 */

	@GetMapping("/dataSorting")
	public ResponseEntity<List<Employee>>getAllEmployeesSorted(@RequestParam String property,@RequestParam String orderType){
	List<Employee>	list=empservice.getAllEmployeeSorted(orderType, property);
	return new ResponseEntity<>(list,HttpStatus.OK);
	 
		
	}
	@GetMapping("exist/{id}")
	public ResponseEntity<Boolean> existIdData(@PathVariable Integer id){
	boolean result=empservice.existId(id);
	if(!result) {
		//throw new InvalidIdException();
		//throw new InsuffiecientBalanceException();		
		//throw new InvalidCredentialsException();
		throw new AppIdNotValidException();
	}
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
 @GetMapping("buildDesignPattren")
	public ResponseEntity<ApiResponse>builderDesignPattren(@RequestHeader HttpHeaders headers){
		return empservice.fetchEmpsData(headers);
	}
 
 @GetMapping("factoryDesign/{type}")
 public ResponseEntity<byte[]> factoryDesignPattern(@PathVariable String type) throws IOException{
	 
	 FactoryDesignPattern fdp=new FactoryDesignPattern(type);
	 List<Employee> empList=empservice.getAllEmps();
	 byte[] fileData=fdp.downloadFile(empList);
	 
	  HttpHeaders headers=new HttpHeaders();
	  String mediaType="";
	  String fileName="";
	switch (type) {
	case "xlsx":
		mediaType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		fileName="employee.xlsx";
		break;
	case "pdf":
		mediaType = "application/pdf";
		fileName="employee.pdf";
		break;
	case "docx":
		mediaType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
		fileName="employee.docx";
		break;
	case "txt":
		mediaType = "text/plain";
		fileName="employee.txt";
		break;

	default:
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	  headers.setContentType(MediaType.parseMediaType(mediaType));
	  headers.setContentDisposition(ContentDisposition.builder("attachment").filename(fileName).build());
	 
	 
	return new ResponseEntity<>(fileData,headers,HttpStatus.OK);
	 
 }
	
	@GetMapping("/generate-txt")
	public ResponseEntity<String> generateTxtFile() {
		List<Employee> employees = empservice.findAllEmps();
		if (employees.isEmpty()) {
			return ResponseEntity.ok("No data to export.");
		}

		// Specify the file path (e.g., C:/upload/employee_data.txt)
		String filePath = "C:\\uploadfiles\\employee_data01.txt";

		try (FileWriter fileWriter = new FileWriter(filePath)) {
			for (Employee emp : employees) {
				fileWriter.write("ID: " + emp.getId() + "\n");
				fileWriter.write("Name: " + emp.getFullname() + "\n");
				fileWriter.write("Department: " + emp.getDept() + "\n");
				fileWriter.write("Age: " + emp.getAge() + "\n");
				fileWriter.write("Salary: " + emp.getSalary() + "\n");
				fileWriter.write("EmployeeCode: " + emp.getEmpCode() + "\n");

				// Add more fields as needed
				fileWriter.write("\n"); // Add a separator between records
			}

			return ResponseEntity.ok(
					"Text file generated successfully. You can download it from the following link: /employee/download/txt/employee_data.txt");
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating the text file.");
		}
	}

}
