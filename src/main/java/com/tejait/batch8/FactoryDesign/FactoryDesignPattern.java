package com.tejait.batch8.FactoryDesign;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpHeaders;

import com.tejait.batch8.model.Employee;

public class FactoryDesignPattern {
	FileGen fileGen=null;
	public FactoryDesignPattern (String type) {//xlxs,pdf,docx,pdf
		fileGen=FileGenUtil.createFileObjects(type);
	}
  public byte[] downloadFile(List<Employee> empList) throws IOException {
	  byte[] fileData=fileGen.genFile(empList);
	  
	return fileData;
	
	
	  
  }
}
 