package com.tejait.batch8.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "salesreport")
public class SalesReport {
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int slid;
	    private int appid;
	   //@CreationTimestamp
	    @DateTimeFormat(pattern="dd-mm-yyyy")
	    @Temporal(TemporalType.DATE)
	    private Date date;
	    private int orderno;
	    private String invoiceno;
	    private String partyName;
	    private Long partyPhoneNum;
	    private int totalAmount;
	    private int recievedOrPaidAmount;
	    private int balanceAmount;
}
