package com.VO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="jkkjjkjkj_Table")
public class JkkjjkjkjVO{ 

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
@Column(name="jkkjjkjkjId")	private int jkkjjkjkjId;

	public int getJkkjjkjkjId()  {
		return jkkjjkjkjId ;
	}

	public void setJkkjjkjkjId (int jkkjjkjkjId) {
		this.jkkjjkjkjId = jkkjjkjkjId;
	}

@Column(name="jkjkjkkId")	private String jkjkjkk;

	public String getJkjkjkk(){
		return jkjkjkk;
	}

	public void setJkjkjkk(String jkjkjkk) {
		this.jkjkjkk=jkjkjkk;
	}

	}