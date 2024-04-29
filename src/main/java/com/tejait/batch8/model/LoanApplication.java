package com.tejait.batch8.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="loan_application")
public class LoanApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appId;
    private String fname;
    private String lname;
    private String customerName;
    private String mailId;
    private Long mobile;
    private String city;

}
