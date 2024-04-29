package com.tejait.batch8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejait.batch8.model.AssuranceDetails;
@Repository
public interface AssuranceDetailsRepository extends JpaRepository<AssuranceDetails, Integer>{

	boolean existsByAppid(Integer appId);

	List<AssuranceDetails> findByAppid(Integer appId);


}
