package com.tejait.batch8.FactoryDesign;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.tejait.batch8.model.Employee;


public class WordFile implements FileGen{

	 @Override
	    public byte[] genFile(List<Employee> empList) throws IOException {
	        XWPFDocument document = new XWPFDocument();
	        XWPFTable table = document.createTable();
	        boolean isFirstTime = true;
	        for (Employee emp : empList) {
	            XWPFTableRow row;
	            if (isFirstTime) {
	                row = table.getRow(0);
	                isFirstTime = false;
	            } else {
	                row = table.createRow();
	            }
	            row.createCell().setText(emp.getId() + "");
	            row.createCell().setText(emp.getFname() + "");
	            row.createCell().setText(emp.getLname() + "");
	            row.createCell().setText(emp.getFullname() + "");
	            row.createCell().setText(emp.getSalary() + "");
	            row.createCell().setText(emp.getDept() + "");
	            row.createCell().setText(emp.getEmpCode() + "");
	        }
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        document.write(outputStream);
	        document.close();
	        return outputStream.toByteArray();
	    }
	}	

