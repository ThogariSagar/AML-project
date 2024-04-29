package com.tejait.batch8.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tejait.batch8.model.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{
	 List<Employee>findByDept(String dept);

	List<Employee> findBySalary(long salary);


	List<Employee> findByLnameAndFname(String lname, String fname);

	List<Employee> findDistinctByLnameAndFname(String lname, String fname);

	List<Employee> findByAgeLessThan(int age);

	List<Employee> findBySalaryBetween(long salary1, long salary2);

	List<Employee> findByAgeOrderByLnameDesc(int age);

	List<Employee> findByLnameOrFname(String lname, String fname);

	List<Employee> findByLnameIs(String lname);

	List<Employee> findByfnameStartingWith(String fname);	

	List<Employee> findByLnameContaining(String lname);

	List<Employee> findByfnameEndingWith(String fname);

	// -------Search Filters for EmpCode start------------------
	 List<Employee> findByEmpCodeStartingWith(String empcode);
	 List<Employee> findByEmpCodeEndingWith(String empcode);	
	 List<Employee> findByEmpCodeContaining(String empcode);
	 List<Employee> findByEmpCodeNotContaining(String empcode);
	 List<Employee> findByEmpCodeEquals(String empcode);	
	 List<Employee> findByEmpCodeNot(String empcode);
	// -------Search Filters for EmpCode ENd------------------

	 
	 @Query("select e from  Employee e ")
	List<Employee> findAllEmployee();
	 
	 @Query("select e from Employee e where e.dept=?1")
	 List<Employee> findByDepartment(String dept);
	 
	 @Query(value = "select * from employee e where e.dept=?1",nativeQuery=true)
	 List<Employee> findByDepartmentdata(String dept);
	 
	 
	// @Query("select e from Employee e where e,fname Like %?1%")
	 @Query("select e from Employee e where concat(e.fname,e.lname,e.fullname,e.dept,e.age,e.empCode) like %?1%")
    List<Employee>searchEmployeeData(String searchVal);

	List<Employee> findByAgeIn(ArrayList<Integer> ageList);

	List<Employee> findByDeptIn(List<String> dept);
	 
}
