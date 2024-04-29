package com.tejait.batch8.FactoryDesign;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.tejait.batch8.model.Employee;


public class TextFile implements FileGen{

	  @Override
	    public byte[] genFile(List<Employee> empList) throws IOException {
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        try (OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
	            for (Employee emp : empList) {
	                writer.write(emp.getId() + " " + emp.getFname() + " " + emp.getLname() + " " + emp.getFullname() + " " + emp.getSalary() + " " + emp.getDept() + " " + emp.getEmpCode() + "\n");
	            }
	        }
	        return outputStream.toByteArray();
	    }

}
