package com.VO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="1111111111_Table")
public class 1111111111VO{ 

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
@Column(name="1111111111Id")	private int 1111111111Id;

	public int get1111111111Id()  {
		return 1111111111Id ;
	}

	public void set1111111111Id (int 1111111111Id) {
		this.1111111111Id = 1111111111Id;
	}

@Column(name="firstnameId")	private String firstname;

	public String getFirstname(){
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname=firstname;
	}

@Column(name="genderId")	private String gender;

	public String getGender(){
		return gender;
	}

	public void setGender(String gender) {
		this.gender=gender;
	}

	}