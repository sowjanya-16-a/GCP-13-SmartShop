package com.wipro.capstoneshopfrohome.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wipro.capstoneshopfrohome.config.CSVHelper;
import com.wipro.capstoneshopfrohome.config.ResponseMessage;
import com.wipro.capstoneshopfrohome.service.ISalesLogService;
import com.wipro.capstoneshopfrohome.service.imp.CSVService;



@CrossOrigin("http://localhost:4200")
@RestController

public class CSVController {
	
	@Autowired
	CSVService csvService;
	@Autowired
	ISalesLogService salesService;
	

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file){
		String message = "";
		if(CSVHelper.hasCSVFormat(file)) {
			try {
				csvService.save(file);
				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
		                .path("/api/csv/download/")
		                .path(file.getOriginalFilename())
		                .toUriString();
				
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message,fileDownloadUri));
			}
			catch (Exception e) {
		        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
		        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message,""));
		      }
		}
		message = "Please upload a csv file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message,""));
	}
	
	
	@RequestMapping("/api/csv/salesdownload")
	public void downloadSalesReportCsv(HttpServletResponse response) throws IOException
	{
		System.out.println("this method is called");
		response.setContentType("text/csv");
		System.out.println("1st line excuted");
		response.setHeader("Content-Disposition","attachment; file=sales.csv");
		System.out.println("2nd line executed");
		csvService.downloadSalesReport(response.getWriter(), salesService.getSales());
	}

}
