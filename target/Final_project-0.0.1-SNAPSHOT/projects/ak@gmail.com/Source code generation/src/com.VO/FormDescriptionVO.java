package com.VO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="formDescription_Table")
public class FormDescriptionVO{ 

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
@Column(name="formDescriptionId")	private int formDescriptionId;

	public int getFormDescriptionId()  {
		return formDescriptionId ;
	}

	public void setFormDescriptionId (int formDescriptionId) {
		this.formDescriptionId = formDescriptionId;
	}

@Column(name="aaaaaaaaaaaId")	private String aaaaaaaaaaa;

	public String getAaaaaaaaaaa(){
		return aaaaaaaaaaa;
	}

	public void setAaaaaaaaaaa(String aaaaaaaaaaa) {
		this.aaaaaaaaaaa=aaaaaaaaaaa;
	}

	}