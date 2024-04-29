package com.tejait.batch8.controller;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.tejait.batch8.model.Student;
import com.tejait.batch8.service.StudentService;
import com.tejait.batch8.util.ExcelGenerator;
import com.tejait.batch8.util.PdfGenerator;






@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService stdtservice;
	
	@RequestMapping(value="save",method = RequestMethod.POST)
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
	 Student stdt=stdtservice.saveStudent(student);
	 ResponseEntity<Student> response=new ResponseEntity<Student>(stdt, HttpStatus.CREATED);
		return response;
		
	}
	@RequestMapping(value="update",method = RequestMethod.PUT)
	public ResponseEntity<Student>updateStudent(@RequestBody Student student){
		Student stdt=stdtservice.saveStudent(student);
		return new ResponseEntity<Student>(stdt,HttpStatus.OK);
		
	}
	
	 @GetMapping("/export-to-excel")
	    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
	        response.setContentType("application/octet-stream");
	        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());

	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=student" + currentDateTime + ".xlsx";
	        response.setHeader(headerKey, headerValue);

	        List <Student> listOfStudents = stdtservice.getTheListStudent();
	        ExcelGenerator generator = new ExcelGenerator(listOfStudents);
	        generator.generateExcelFile(response);
	    }
	 @GetMapping("/export-to-pdf")
	  public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException 
	  {
	    response.setContentType("application/pdf");
//	    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
//	    String currentDateTime = dateFormat.format(new Date());
	    String headerkey = "Content-Disposition";
	    String headervalue = "attachment; filename=student.pdf";
	    response.setHeader(headerkey, headervalue);
	    List < Student > listofStudents = stdtservice.getStudentList();
	    PdfGenerator generator = new PdfGenerator();
	    generator.generate(listofStudents, response);
	  }
	
}
