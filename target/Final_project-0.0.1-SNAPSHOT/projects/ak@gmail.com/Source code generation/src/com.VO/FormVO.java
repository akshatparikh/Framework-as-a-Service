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

@Column(name="fnameId")	private String fname;

	public String getFname(){
		return fname;
	}

	public void setFname(String fname) {
		this.fname=fname;
	}

@Column(name="hobbyId")	private String hobby;

	public String getHobby(){
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby=hobby;
	}

@Column(name="genderId")	private String gender;

	public String getGender(){
		return gender;
	}

	public void setGender(String gender) {
		this.gender=gender;
	}

	}