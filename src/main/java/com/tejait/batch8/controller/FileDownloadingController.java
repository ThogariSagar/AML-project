package com.tejait.batch8.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("files")
public class FileDownloadingController {
	
	@RequestMapping(value = "/Downloads", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response) throws Exception {
		try {
			String fileName = "naimi.jpg";
			String filePath = "C:\\" + fileName;
 
			try {
				File file = new File(filePath);
				FileInputStream in = new FileInputStream(filePath);
 
				response.setContentType(URLConnection.guessContentTypeFromStream(in));
				response.setContentLength(Files.readAllBytes(file.toPath()).length);
				response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
 
				FileCopyUtils.copy(in, response.getOutputStream());
				in.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
