package com.tejait.batch8.FactoryDesign;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.tejait.batch8.model.Employee;

public class PdfFile implements FileGen {

	@Override
    public byte[] genFile(List<Employee> empList) throws IOException {
        Document pdfDocument = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(pdfDocument, outputStream);
            pdfDocument.open();
            for (Employee emp : empList) {
                Paragraph ph = new Paragraph(emp.getId() + " " + emp.getFname() + " " + emp.getLname() + " " + emp.getFullname() + " " + emp.getSalary() + " " + emp.getDept() + " " + emp.getEmpCode());
                pdfDocument.add(ph);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            pdfDocument.close();
        }
        return outputStream.toByteArray();
    }
}
