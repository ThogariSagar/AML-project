package com.tejait.batch8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejait.batch8.model.CompanyAddress;
@Repository
public interface CompanyAddressRepository  extends JpaRepository<CompanyAddress, Integer>{

	boolean existsByAppId(Integer appId);

	CompanyAddress findByAppId(Integer appId);

	

	

}
