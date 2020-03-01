package com.VO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="form_Table")
public class FormVO{ 

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
@Column(name="formId")	private int formId;

	public int getFormId()  {
		return formId ;
	}

	public void setFormId (int formId) {
		this.formId = formId;
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