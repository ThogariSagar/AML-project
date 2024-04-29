package com.tejait.batch8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejait.batch8.model.AssuranceDetails;
import com.tejait.batch8.model.BusinessProduct;
import com.tejait.batch8.model.LoanApplication;
import com.tejait.batch8.service.LoanApplicationService;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Integer> {

	boolean existsByMailIdOrMobile(String mailid, long mobile);

	LoanApplication findByAppId(Integer appId);

	

	boolean existsByAppId(Integer appid);

	

}
