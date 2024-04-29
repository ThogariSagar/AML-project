package com.tejait.batch8.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.tejait.batch8.dto.ApplicationOverview;
import com.tejait.batch8.model.AssuranceDetails;
import com.tejait.batch8.model.BusinessProduct;
import com.tejait.batch8.model.CompanyAddress;
import com.tejait.batch8.model.CompanyDetails;
import com.tejait.batch8.model.LoanApplication;
import com.tejait.batch8.model.SalesReport;
import com.tejait.batch8.model.TransactionHistory;


@Service
public interface LoanApplicationService {

	LoanApplication applyingForLoan(LoanApplication data);

	List<LoanApplication> getAllApplicants();

	ApplicationOverview getApplicantOverview(Integer appId);

	BusinessProduct saveBusinessProduct(BusinessProduct data, Integer appId);

	BusinessProduct getAllBusinessProducts(Integer appId);

	CompanyDetails saveCompanyDetails(CompanyDetails data, Integer appId);

	CompanyDetails getAllCompanyDetails(Integer appId);

	CompanyAddress saveCompanyAddress(CompanyAddress data, Integer appId);

	CompanyAddress getAllCompanyAddress(Integer appId);

	String uploadAsuuranceDetails(MultipartFile file);

	List<AssuranceDetails> saveAssurenceDetails(Integer appId, List<AssuranceDetails> data);

	List<AssuranceDetails> findAllAssuranceDetailsById(Integer appId);

	List<SalesReport> uploadSalesRepotDetails(MultipartFile file) throws IOException;

	List<SalesReport> saveSalesReportDetails(Integer appId, List<SalesReport> data);

	List<SalesReport> findAllSalesReportDetailsById(Integer appId);

	List<TransactionHistory> readcsvfile(MultipartFile file) throws IOException, ParseException;

	List<TransactionHistory> savetxnhistory(List<TransactionHistory> txnhistory, Integer appid);

	List<TransactionHistory> getfilteredTransaction(Integer appId, String statusOrInstrument,List<String> statusOrInstrumentTypesList);

	List<TransactionHistory> gettheStatementByDate(Integer appid, Integer duration, Date startDate, Date endDate);

}
