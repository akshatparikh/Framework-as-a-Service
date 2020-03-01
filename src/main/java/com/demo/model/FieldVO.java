package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="add_field")
public class FieldVO {
	
	@Id
	@Column(name="field_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fieldId;
	
	@Column(name="field_name")
	private String fieldName;
	
	@Column(name="field_type")
	private String fieldType;
	
	@Column(name="field_value")
	private String fieldValue;
	
	@ManyToOne
	private FormVO formVO;
	
	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public FormVO getFormVO() {
		return formVO;
	}

	public void setFormVO(FormVO formVO) {
		this.formVO = formVO;
	}
	
	
}
