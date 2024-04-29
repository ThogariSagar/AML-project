package com.tejait.batch8.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name="student")
public class Student {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)	  
	     private int id;
	     private String fname;
	     private String lname;
	     private String fullname;
	     private String dept;
	     private int age;
	     private long salary;
	     private String stdCode; 
	

}
