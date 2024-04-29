package com.tejait.batch8.dtodesignpattren;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Data
@Entity
@Table(name="card_details")
public class CardDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	int cid;
	long cardnum;
	String holder;
	int cvv;
	int pin;
	Date createDate;
	
	
	
	
}