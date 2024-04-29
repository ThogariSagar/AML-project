package com.tejait.batch8.serviceimpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EmptyFileException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tejait.batch8.dto.ApplicationOverview;
import com.tejait.batch8.exceptionhandling.AppIdNotValidException;
import com.tejait.batch8.exceptionhandling.DataAlreadyExistException;
import com.tejait.batch8.exceptionhandling.DataNotFoundException;
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
import com.tejait.batch8.repository.BusinessProductRepository;
import com.tejait.batch8.repository.CompanyAddressRepository;
import com.tejait.batch8.repository.CompanyDetailsRepository;
import com.tejait.batch8.repository.LoanApplicationRepository;
import com.tejait.batch8.repository.SalesReportRepository;
import com.tejait.batch8.repository.TransactionRepository;
import com.tejait.batch8.service.LoanApplicationService;
@Service
public class LoanApplicationServiceImpl implements LoanApplicationService{
	
	@Autowired
		LoanApplicationRepository lARepository;
		@Autowired
		BusinessProductRepository bPRepository;
		@Autowired
		CompanyAddressRepository cARepository;
		@Autowired
		CompanyDetailsRepository cDRepository;
		@Autowired
		AssuranceDetailsRepository aDRepository;
		@Autowired
		SalesReportRepository sRRepository;
		@Autowired
		TransactionRepository txnrepository; 
		
		public static final Logger logger = LogManager.getLogger(LoanApplicationServiceImpl.class);
	 
		@Override
		public LoanApplication applyingForLoan(LoanApplication data) throws DataAlreadyExistException {
	 
			data.setFname(data.getFname() == null ? "N/A" : data.getFname());
			data.setLname(data.getLname() == null ? "N/A" : data.getLname());
			
			String firstname = data.getFname();
			String lastname = data.getLname();
			String fullname = firstname.concat(" "+lastname);
			data.setCustomerName(fullname.equals("N/A N/A") ? "N/A" : fullname);
			
			data.setMailId(data.getMailId() == null ? "N/A" : data.getMailId());
			data.setMobile(data.getMobile() == 0 ? 0 : data.getMobile());
			data.setCity(data.getCity() == null ? "N/A" : data.getCity());
	 
			String mailid = data.getMailId();
			long mobile = data.getMobile();
			
			boolean result = lARepository.existsByMailIdOrMobile(mailid, mobile);
	 
			if (result && (data.getMailId() != "N/A" || data.getMobile() != 0)) {
				throw new DataAlreadyExistException();
			} else {
				return lARepository.save(data);
			}
		}
	 
	
		@Override
		public List<LoanApplication> getAllApplicants() {
			return lARepository.findAll();
		}
	 
		@Override
		public BusinessProduct saveBusinessProduct(BusinessProduct data, Integer appId) {
	 
			if (appId == null || appId == 0) {
				throw new AppIdNotValidException();
			} else {
				data.setAppid(appId);
			}
			data.setLoanAmount(data.getLoanAmount() == 0 ? 0 : data.getLoanAmount());
			data.setNatureOfBusiness(data.getNatureOfBusiness() == null ? "N/A" : data.getNatureOfBusiness());
			data.setProductCategory(data.getProductCategory() == null ? "N/A" : data.getProductCategory());
			data.setPurposeOfLoan(data.getPurposeOfLoan() == null ? "N/A" : data.getPurposeOfLoan());
			data.setSubCategory(data.getSubCategory() == null ? "N/A" : data.getSubCategory());
			data.setTenure(data.getTenure() == 0 ? 0 : data.getTenure());
			boolean result = bPRepository.existsByAppid(appId);
			if (result) {
				BusinessProduct bP = bPRepository.findByAppid(appId);
				data.setId(bP.getId());
				return bPRepository.save(data);
			}
	 
			return bPRepository.save(data);
		}
	 
		@Override
		public BusinessProduct getAllBusinessProducts(Integer appId) {
	 
			return bPRepository.findByAppid(appId);
	 
		}
	 
		@Override
		public CompanyDetails saveCompanyDetails(CompanyDetails data, Integer appId) {
	 
			if (appId == null || appId == 0) {
				throw new AppIdNotValidException();
			} else {
				data.setAppId(appId);
			}
			data.setCompanyName(data.getCompanyName() == null ? "N/A" : data.getCompanyName());
			data.setCompanyPan(data.getCompanyPan() == null ? "N/A" : data.getCompanyPan());
			data.setDateOfEstablish(data.getDateOfEstablish() == null ? "" : data.getDateOfEstablish());
			data.setGstin(data.getGstin() == null ? "N/A" : data.getGstin());
			data.setIndustryType(data.getIndustryType() == null ? "N/A" : data.getIndustryType());
			data.setTurnover(data.getTurnover() == 0 ? 0 : data.getTurnover());
	 
			boolean result = cDRepository.existsByAppId(appId);
			if (result) {
				CompanyDetails cD = cDRepository.findByAppId(appId);
				data.setId(cD.getId());
				return cDRepository.save(data);
			}
	 
			return cDRepository.save(data);
		}
	 
	
	@Override
		public CompanyDetails getAllCompanyDetails(Integer appId) {
			return cDRepository.findByAppId(appId);
		}
	 
		@Override
		public CompanyAddress saveCompanyAddress(CompanyAddress data, Integer appId) {
			if (appId == null || appId == 0) {
				throw new AppIdNotValidException();
			} else {
				data.setAppId(appId);
			}
			data.setArea(data.getArea() == null ? "N/A" : data.getArea());
			data.setBuilding(data.getBuilding() == null ? "N/A" : data.getBuilding());
			data.setCity(data.getCity() == null ? "N/A" : data.getCity());
			data.setFlatnum(data.getFlatnum() == null ? "N/A" : data.getFlatnum());
			data.setLandmark(data.getLandmark() == null ? "N/A" : data.getLandmark());
			data.setLine(data.getLine() == null ? "N/A" : data.getLine());
			data.setPincode(data.getPincode() == 0 ? 0 : data.getPincode());
			data.setState(data.getState() == null ? "N/A" : data.getState());
	 
			boolean result = cARepository.existsByAppId(appId);
			if (result) {
				CompanyAddress cA = cARepository.findByAppId(appId);
				data.setId(cA.getId());
				return cARepository.save(data);
			}
	 
		return cARepository.save(data);
		}
	 
		@Override
		public CompanyAddress getAllCompanyAddress(Integer appId) {
			return cARepository.findByAppId(appId);
		}
	 
		@Override
		public ApplicationOverview getApplicantOverview(Integer appId) {
			if (appId == null || appId == 0) {
				throw new AppIdNotValidException();
			} else {
	 
				LoanApplication lA = lARepository.findByAppId(appId);
				BusinessProduct bP = bPRepository.findByAppid(appId);
				CompanyAddress cA = cARepository.findByAppId(appId);
				CompanyDetails cD = cDRepository.findByAppId(appId);
	 
				ApplicationOverview dto = new ApplicationOverview();
	 
				if (lA.getAppId() == 0) {
					throw new AppIdNotValidException();
				} else {
					dto.setAppId(lA.getAppId());
				}
				if (cD.getCompanyName() == null) {
					throw new DataNotFoundException();
				} else {
					dto.setCompanyName(cD.getCompanyName());
				}
				if (cD.getCompanyPan() == null) {
					throw new DataNotFoundException();
				} else {
					dto.setCompanyPan(cD.getCompanyPan());
				}
				if (bP.getLoanAmount() == 0) {
					throw new DataNotFoundException();
				} else {
					dto.setLoanAmt(bP.getLoanAmount());
				}
				if (lA.getMailId() == null) {
					throw new DataNotFoundException();
				} else {
					dto.setMail(lA.getMailId());
				}
	 
				if (lA.getMobile() == 0) {
					throw new DataNotFoundException();
				} else {
					dto.setMobile(lA.getMobile());
				}
				if (bP.getTenure() == 0) {
					throw new DataNotFoundException();
				} else {
					dto.setTenure(bP.getTenure());
				}
				if (cA.getCity() == null) {
					throw new DataNotFoundException();
				} else {
					dto.setCity(cA.getCity());
				}
				return dto;
			}
		}
	 
	@Override
		public List<AssuranceDetails> saveAssurenceDetails(Integer appId, List<AssuranceDetails> data) {
	 
			boolean result = aDRepository.existsByAppid(appId);
	 
			List<AssuranceDetails> asdlist = aDRepository.findByAppid(appId);
	 
			if (!result && appId != 0) {
				for (AssuranceDetails list : data) {
					list.setAppid(appId);
				}
				return aDRepository.saveAll(data);
	 
			} else if (result && appId != 0) {
	 
				for (int i = 0; i < asdlist.size(); i++) {
	 
					AssuranceDetails a2 = asdlist.get(i);
					AssuranceDetails a1 = data.get(i);
					a1.setAppid(appId);
					a1.setId(a2.getId());
	 
				}
	 
				return aDRepository.saveAll(data);
	 
			} else {
	 
				throw new AppIdNotValidException();
			}
	 
		}
	 
		@Override
		public List<AssuranceDetails> findAllAssuranceDetailsById(Integer appId) {
			return aDRepository.findByAppid(appId);
		}
	 
		@Override
		public String uploadAsuuranceDetails(MultipartFile file) {
			if (file.isEmpty()) {
				return "Please select a file to upload.";
			}
	 
			try {
				byte[] bytes = file.getBytes();
				return new String(bytes);
			} catch (IOException e) {
				e.printStackTrace();
				return "Error while processing the file.";
			}
		}
	 
	@Override
		public List<SalesReport> uploadSalesRepotDetails(MultipartFile file) throws IOException {
			if (file.isEmpty()) {
				throw new EmptyFileException();
			} else {
				XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
				XSSFSheet sheet = workbook.getSheetAt(0);
	 
				List<SalesReport> list = new ArrayList<>();
	 
				for (int rowIndex = 6; rowIndex <= 17; rowIndex++) {
					XSSFRow row = sheet.getRow(rowIndex);
					SalesReport sR = new SalesReport();
					if (row != null) {
						sR.setDate((row.getCell(0).getDateCellValue()));
						sR.setOrderno((int) row.getCell(1).getNumericCellValue());
						sR.setInvoiceno(row.getCell(2).getStringCellValue());
						sR.setPartyName(row.getCell(3).getStringCellValue().concat(row.getCell(4).getStringCellValue()));
						sR.setPartyPhoneNum((long) (row.getCell(5).getNumericCellValue()));
						sR.setTotalAmount((int) (row.getCell(7).getNumericCellValue()));
						sR.setRecievedOrPaidAmount((int) row.getCell(9).getNumericCellValue());
						sR.setBalanceAmount((int) (row.getCell(11).getNumericCellValue()));
						list.add(sR);
					}
				}
				workbook.close();
				return list;
			}
		}
	 
		@Override
		public List<SalesReport> saveSalesReportDetails(Integer appId, List<SalesReport> data) {
	 
			boolean result = sRRepository.existsByAppid(appId);
	 
			List<SalesReport> asdlist = sRRepository.findByAppid(appId);
	 
			if (!result && appId != 0) {
				for (SalesReport list : data) {
					list.setAppid(appId);
				}
				return sRRepository.saveAll(data);
	 
			} else if (result && appId != 0) {
	 
				for (int i = 0; i < asdlist.size(); i++) {
	 
					SalesReport a2 = asdlist.get(i);
					SalesReport a1 = data.get(i);
					a1.setAppid(appId);
					a1.setSlid(a2.getSlid());
	 
				}
	 
				return sRRepository.saveAll(data);
	 
			} else {
	 
				throw new AppIdNotValidException();
			}
		}
	 
		@Override
		public List<SalesReport> findAllSalesReportDetailsById(Integer appId) {
			return sRRepository.findByAppid(appId);
		}


		@Override
		public List<TransactionHistory> readcsvfile(MultipartFile file) throws IOException, ParseException {
			
			List<TransactionHistory> transactionList = new ArrayList<>();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
	        String line;
	        // to skip header row
	        reader.readLine();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
 
 
	        while ((line = reader.readLine()) != null) {
	            String[] columns = line.split(",");
 
 
	            TransactionHistory transaction = new TransactionHistory();
	            transaction.setTransactionDate(dateFormat.parse(columns[0].trim()));
	            transaction.setActivity(columns[1].trim());
	            transaction.setInstrument(columns[2].trim());
	            transaction.setTxnId(Long.parseLong(columns[3].trim()));
	            transaction.setComment(columns[4].trim() == "" ? "N/A" : columns[4].trim());
	            transaction.setDebtAmt(columns[5].trim() == "" ? 0 : Double.parseDouble(columns[5].trim()));
	            transaction.setCreditAmt(columns[6].trim() == "" ? 0 : Double.parseDouble(columns[6].trim()));
	            transaction.setTransactionBreakup(columns[7].trim()	== "" ? "N/A" :columns[7].trim());
	            transaction.setTransactionStatus(columns[8].trim());
	            transactionList.add(transaction);
	        }
	        reader.close();
	        return transactionList;    
		}


		@Override
		public List<TransactionHistory> savetxnhistory(List<TransactionHistory> txnhistory, Integer appid) {
			boolean result = lARepository.existsByAppId(appid);
		        if (!result) {
		            throw new DataNotFoundException();
		        }
		     boolean appIdexists = txnrepository.existsByAppid(appid);
		     List<TransactionHistory> existedlist01 = txnrepository.findByAppid(appid);
		     if(!appIdexists && appid != 0) {
		         for(TransactionHistory list: txnhistory) {
		             list.setAppid(appid);
		         }
		          return txnrepository.saveAll(txnhistory);
		     }else if(appid != 0 && appIdexists) {    
		         for(int i = 0; i<existedlist01.size(); i++) {
		        	 TransactionHistory a2 = existedlist01.get(i);
		        	 TransactionHistory a1 = txnhistory.get(i);
		             a1.setTrid(a2.getTrid());
		             a1.setAppid(a2.getAppid());
		         }
		     }
		     return txnrepository.saveAll(txnhistory);
		}


		@Override
		public List<TransactionHistory> getfilteredTransaction(Integer appId, String statusOrInstrument,
				List<String> statusOrInstrumentTypesList) {
			
		     List<TransactionHistory> filteredData = null;
	         
		        if (statusOrInstrument.equalsIgnoreCase("status")) {
		            filteredData = txnrepository.findByTransactionStatusIn(statusOrInstrumentTypesList);
		        } else if (statusOrInstrument.equalsIgnoreCase("instrument")) {
		            filteredData = txnrepository.findByInstrumentIn(statusOrInstrumentTypesList);
		        }
		        return filteredData;
		    }


		@Override
		public List<TransactionHistory> gettheStatementByDate(Integer appid, Integer duration, Date startDate,
				Date endDate) {  
	        List<TransactionHistory> statement = null;
	        if (duration != null) {
	            LocalDate date = LocalDate.now().minusMonths(duration);
	 
	            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	            Date newdate = null;
	            try {
	                newdate = formatter.parse(date.toString());
	            } catch (ParseException e) {
	                e.printStackTrace();
	            }
	            statement = txnrepository.findByTransactionDateGreaterThanEqual(newdate);
	        }
	        else if (startDate != null && endDate != null) {
	        statement = txnrepository.findByTransactionDateBetween(startDate, endDate);
	       }
	        return statement;
		}
		}
	 
		