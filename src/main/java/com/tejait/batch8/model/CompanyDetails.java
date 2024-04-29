package com.tejait.batch8.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "company_details")
public class CompanyDetails {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private int appId;
	    private String companyName;
	    private String dateOfEstablish;
	    private String gstin;
	    private String companyPan;
	    private String industryType;
	    private long turnover;
	}


