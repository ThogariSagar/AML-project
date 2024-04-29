package com.tejait.batch8.FactoryDesign;

public class FileGenUtil {
	public static FileGen createFileObjects(String type) {//xlxs,pdf,docx,txt
		
		FileGen file=null;
		switch (type) {
		case "xlsx":
			file= new ExcelFile(); 
			break;
		case "pdf":
			file=new PdfFile();
			break;
		case "txt":
		 file=new TextFile();
		 break;
		case "docx": 
			file=new WordFile();
			break;

		default:
			throw new IllegalAccessError("file type not descibed properly");
		}
		return file;
		
	}

}
