package com.tejait.batch8.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejait.batch8.model.CompanyDetails;

@Repository
public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, Integer> {

	boolean existsByAppId(Integer appId);

	CompanyDetails findByAppId(Integer appId);

	

	
	
}
