package com.tejait.batch8.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.tejait.batch8.dto.ApplicationOverview;
import com.tejait.batch8.exceptionhandling.DataAlreadyExistException;
import com.tejait.batch8.exceptionhandling.MailAlreadyExistException;
import com.tejait.batch8.exceptionhandling.MobileAlreadyexistException;
import com.tejait.batch8.model.AssuranceDetails;
import com.tejait.batch8.model.BusinessProduct;
import com.tejait.batch8.model.CompanyAddress;
import com.tejait.batch8.model.CompanyDetails;
import com.tejait.batch8.model.LoanApplication;
import com.tejait.batch8.model.SalesReport;
import com.tejait.batch8.model.TransactionHistory;
import com.tejait.batch8.repository.AssuranceDetailsRepository;
import com.tejait.batch8.repository.LoanApplicationRepository;
import com.tejait.batch8.service.LoanApplicationService;

@RestController
@RequestMapping("/loans")
@CrossOrigin
public class LoanApplicationController {
		@Autowired
		LoanApplicationService service;
		@Autowired
		LoanApplicationRepository lA;
		
 
	 
		@PostMapping("applyLoan")
		public ResponseEntity<LoanApplication> applyLoan(@RequestBody LoanApplication data)
				throws DataAlreadyExistException {
	 
			LoanApplication Loan = service.applyingForLoan(data);
			return new ResponseEntity<>(Loan, HttpStatus.CREATED);
		}
	 
		@GetMapping("loanTaskboard")
		public ResponseEntity<List<LoanApplication>> getAllApplicants() {
			List<LoanApplication> list = service.getAllApplicants();
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	 
		@GetMapping("getOverviewDeatils/{appId}")
		public ResponseEntity<ApplicationOverview> getApplicantOverview(@PathVariable Integer appId) {
			ApplicationOverview dto = service.getApplicantOverview(appId);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
	 
		@PostMapping("/saveProductDetails/{appId}")
		public ResponseEntity<BusinessProduct> saveEmployee(@RequestBody BusinessProduct data,
				@PathVariable Integer appId) {
			BusinessProduct BProduct = service.saveBusinessProduct(data, appId);
			return new ResponseEntity<>(BProduct, HttpStatus.CREATED);
		}
	 

	@GetMapping("getProductDetails/{appId}")
		public ResponseEntity<BusinessProduct> getAllBusinessProductData(@PathVariable Integer appId) {
			BusinessProduct list = service.getAllBusinessProducts(appId);
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	 
		@PostMapping("/saveCompanyDetails/{appId}")
		public ResponseEntity<CompanyDetails> saveCompanyDetails(@RequestBody CompanyDetails data,
				@PathVariable Integer appId) {
			CompanyDetails companyDetails = service.saveCompanyDetails(data, appId);
			return new ResponseEntity<>(companyDetails, HttpStatus.CREATED);
		}
	 
		@GetMapping("getCompanyDetails/{appId}")
		public ResponseEntity<CompanyDetails> getAllCompaniesDetailsData(@PathVariable Integer appId) {
			CompanyDetails list = service.getAllCompanyDetails(appId);
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	 
		@PostMapping("/saveCompanyAddress/{appId}")
		public ResponseEntity<CompanyAddress> saveCompanyAddress(@PathVariable Integer appId,@RequestBody CompanyAddress data) {
			CompanyAddress companyAddress = service.saveCompanyAddress(data, appId);
			return new ResponseEntity<>(companyAddress, HttpStatus.CREATED);
		}
	 
		@GetMapping("/getCompanyAddress/{appId}")
		public ResponseEntity<CompanyAddress> getAllCompaniesAddressesData(@PathVariable Integer appId) {
			CompanyAddress companyAddress = service.getAllCompanyAddress(appId);
			return new ResponseEntity<>(companyAddress, HttpStatus.CREATED);
		}
	 
		@PostMapping("/readJson")
		public ResponseEntity<String> uploadJson(@RequestParam("file") MultipartFile file) {
	 
			String jsonData = service.uploadAsuuranceDetails(file);
			return new ResponseEntity<>(jsonData, HttpStatus.ACCEPTED);
		}
	 
		@PostMapping("/saveJsonfileData/{appId}")
		public ResponseEntity<List<AssuranceDetails>> uploadJsonData(@PathVariable Integer appId,
				@RequestBody List<AssuranceDetails> data) {
	 
			List<AssuranceDetails> list = service.saveAssurenceDetails(appId, data);
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	 
		@GetMapping("getPersonDetails/{appId}")
		public ResponseEntity<List<AssuranceDetails>> getAllAssuranceDetailsById(@PathVariable Integer appId) {
			List<AssuranceDetails> list = service.findAllAssuranceDetailsById(appId);
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	 
		@PostMapping("/readExcel")
		public ResponseEntity<List<SalesReport>> uploadExcel(@RequestParam("file") MultipartFile file) throws IOException {
			List<SalesReport> list = service.uploadSalesRepotDetails(file);
			return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
		}
	 
		@PostMapping("/saveSalesReport/{appId}")
		public ResponseEntity<List<SalesReport>> uploadExcelData(@PathVariable Integer appId,
				@RequestBody List<SalesReport> data) {
	 
			List<SalesReport> list = service.saveSalesReportDetails(appId, data);
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	 
		@GetMapping("getSalesReportDetails/{appId}")
		public ResponseEntity<List<SalesReport>> getAllSalesReportsById(@PathVariable Integer appId) {
			List<SalesReport> list = service.findAllSalesReportDetailsById(appId);
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	
		@PostMapping("/readTransactionsCsv")
		   public ResponseEntity<List<TransactionHistory>> uploadCsvFile(@RequestParam("file") MultipartFile file) throws IOException, ParseException{
		       List<TransactionHistory> csvfile = service.readcsvfile(file);
		       return new ResponseEntity<>(csvfile, HttpStatus.OK);
	}
		  @PostMapping("/saveTxnsData/{appid}")
		   public ResponseEntity<List<TransactionHistory>> uploadtxnhistory(@RequestBody List<TransactionHistory> txnhistory, @PathVariable Integer appid){
		    List<TransactionHistory> list =service.savetxnhistory(txnhistory, appid);
		    return new ResponseEntity<>(list,HttpStatus.OK);
		  } 
		  @GetMapping("/filtertransactions/{appId}")
		    public ResponseEntity<List<TransactionHistory>> filteredTransaction(@PathVariable Integer appId,@RequestParam String statusOrInstrument,@RequestParam("statusOrInstrumentTypesList") List<String> statusOrInstrumentTypesList){
		        List<TransactionHistory> list=service.getfilteredTransaction(appId,statusOrInstrument,statusOrInstrumentTypesList);
		        return new ResponseEntity<>(list,HttpStatus.OK);
		    }
		  @GetMapping("/fetchtransactions/{appid}")
	       public ResponseEntity<List<TransactionHistory>> showStatementByDate(@PathVariable Integer appid,
	               @RequestParam(required = false) Integer duration,
	               @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date startDate,
	               @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date endDate) {
	           List<TransactionHistory> list = service.gettheStatementByDate(appid,duration, startDate, endDate);
	           return new ResponseEntity<>(list, HttpStatus.OK);
	       }
}