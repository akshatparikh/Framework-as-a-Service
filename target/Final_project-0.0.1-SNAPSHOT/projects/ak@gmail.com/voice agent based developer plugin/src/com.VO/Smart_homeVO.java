package com.VO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="smart_home_Table")
public class Smart_homeVO{ 

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
@Column(name="smart_homeId")	private int smart_homeId;

	public int getSmart_homeId()  {
		return smart_homeId ;
	}

	public void setSmart_homeId (int smart_homeId) {
		this.smart_homeId = smart_homeId;
	}

@Column(name="genderId")	private String gender;

	public String getGender(){
		return gender;
	}

	public void setGender(String gender) {
		this.gender=gender;
	}

@Column(name="countryId")	private String country;

	public String getCountry(){
		return country;
	}

	public void setCountry(String country) {
		this.country=country;
	}

@Column(name="fnamId")	private String fnam;

	public String getFnam(){
		return fnam;
	}

	public void setFnam(String fnam) {
		this.fnam=fnam;
	}

	}