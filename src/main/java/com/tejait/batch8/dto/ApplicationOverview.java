package com.tejait.batch8.dto;

import lombok.Data;

@Data
public class ApplicationOverview {
	
	    private int appId;
	    private String companyName;
	    private String city;
	    private Long mobile;
	    private String mail;
	    private Long loanAmt;
	    private int tenure;
	    private String companyPan;
}
