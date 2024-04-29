package com.tejait.batch8.FactoryDesign;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tejait.batch8.model.Employee;

public class ExcelFile implements FileGen{

	 @Override
	    public byte[] genFile(List<Employee> empList) throws IOException {
	        XSSFWorkbook workBook = new XSSFWorkbook();
	        XSSFSheet sheet = workBook.createSheet("Employee Details");
	        XSSFRow row;
	        row = sheet.createRow(0);
	        row.createCell(0).setCellValue("Id");
	        row.createCell(1).setCellValue("FirstName");
	        row.createCell(2).setCellValue("LastName");
	        row.createCell(3).setCellValue("FullName");
	        row.createCell(4).setCellValue("Salary");
	        row.createCell(5).setCellValue("Department");
	        row.createCell(6).setCellValue("Employee Code");
	        int rowcount = 1;
	        for (Employee person : empList) {
	            row = sheet.createRow(rowcount);
	            row.createCell(0).setCellValue(person.getId());
	            row.createCell(1).setCellValue(person.getFname());
	            row.createCell(2).setCellValue(person.getLname());
	            row.createCell(3).setCellValue(person.getFullname());
	            row.createCell(4).setCellValue(person.getSalary());
	            row.createCell(5).setCellValue(person.getDept());
	            row.createCell(6).setCellValue(person.getEmpCode());
	            rowcount++;
	        }
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        workBook.write(outputStream);
	        workBook.close();
	        return outputStream.toByteArray();
	    }
	}
	