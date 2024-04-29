package com.tejait.batch8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejait.batch8.model.BusinessProduct;
@Repository
public interface BusinessProductRepository extends JpaRepository<BusinessProduct, Integer>{

	boolean existsByAppid(Integer appId);

	BusinessProduct findByAppid(Integer appId);

	
	
	

}
