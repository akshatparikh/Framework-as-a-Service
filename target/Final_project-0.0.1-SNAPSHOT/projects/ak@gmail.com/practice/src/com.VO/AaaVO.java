package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="aaa_Table")
public class AaaVO{ 

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
@Column(name="aaaId")	private int aaaId;

	public int getAaaId()  {
		return aaaId ;
	}

	public void setAaaId (int aaaId) {
		this.aaaId = aaaId;
	}

@Column(name="clothId")	private String cloth;

	public String getCloth(){
		return cloth;
	}

	public void setCloth(String cloth) {
		this.cloth=cloth;
	}

	}