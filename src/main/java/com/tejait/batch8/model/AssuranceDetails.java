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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter 
@Table(name = "assurance_ldetails")
public class AssuranceDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    int id;
	    String ename;
	    String nationality;
	    int age;
	    String mail;
	    String gender;
	    int appid;
}
