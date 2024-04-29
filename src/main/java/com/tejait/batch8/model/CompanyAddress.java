package com.tejait.batch8.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
@Data
@Entity
@Table(name = "company_address")
public class CompanyAddress {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private int appId;
	    private String flatnum;
	    private String building;
	    private String line;
	    private String state;
	    private String city;
	    private Long pincode;
	    private String landmark;
	    private String area;
	}


