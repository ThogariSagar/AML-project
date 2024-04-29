package com.tejait.batch8.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trid;
	private int appid;
	private Date transactionDate;
	private String activity;
	private long txnId;
	private String comment;
	private double debtAmt;
	private double creditAmt;
	private String transactionBreakup;
	private String transactionStatus;
	private String instrument;
}
