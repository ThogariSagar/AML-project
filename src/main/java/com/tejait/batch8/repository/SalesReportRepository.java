package com.tejait.batch8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejait.batch8.model.SalesReport;

@Repository
public interface SalesReportRepository  extends JpaRepository<SalesReport, Integer>{

	boolean existsByAppid(Integer appId);

	List<SalesReport> findByAppid(Integer appId);

	

}
