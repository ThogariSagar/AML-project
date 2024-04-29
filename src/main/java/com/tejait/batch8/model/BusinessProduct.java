package com.tejait.batch8.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="business_product")
public class BusinessProduct {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    @Column(nullable = false)
	    private int appid;
	    private String purposeOfLoan;
	    private String natureOfBusiness;
	    private int tenure;
	    private long loanAmount;
	    private String ProductCategory;
	    private String SubCategory;
		
		
		

}
