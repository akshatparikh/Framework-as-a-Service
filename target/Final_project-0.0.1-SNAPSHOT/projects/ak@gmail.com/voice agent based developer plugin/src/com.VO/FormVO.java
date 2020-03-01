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

@Column(name="genderId")	private String gender;

	public String getGender(){
		return gender;
	}

	public void setGender(String gender) {
		this.gender=gender;
	}

@Column(name="hibbyId")	private String hibby;

	public String getHibby(){
		return hibby;
	}

	public void setHibby(String hibby) {
		this.hibby=hibby;
	}

@Column(name="fnameId")	private String fname;

	public String getFname(){
		return fname;
	}

	public void setFname(String fname) {
		this.fname=fname;
	}

	}