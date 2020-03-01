package com.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="add_form")
public class FormVO {
	
		@Id
		@Column(name="form_Id")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int formId;
		
		@Column(name="form_name")
		private String formName;
		
		@Column(name="form_description")
		private String formDescription;	
		
		@Column(name="fileName")
		private String fileName;	
		
		@Column(name="filePath")
		private String filePath;	

		@ManyToOne
		private ProjectVO projectVO;

		@ManyToOne
		private ModuleVO moduleVO;
		
		@Transient
		private List<FieldVO> fieldList;

		@ManyToOne
		private LoginVO loginVO;
		
		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getFilePath() {
			return filePath;
		}

		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}

		
		public LoginVO getLoginVO() {
			return loginVO;
		}

		public void setLoginVO(LoginVO loginVO) {
			this.loginVO = loginVO;
		}

		public int getFormId() {
			return formId;
		}

		public void setFormId(int formId) {
			this.formId = formId;
		}

		public String getFormName() {
			return formName;
		}

		public void setFormName(String formName) {
			this.formName = formName;
		}

		public String getFormDescription() {
			return formDescription;
		}

		public void setFormDescription(String formDescription) {
			this.formDescription = formDescription;
		}

		public ProjectVO getProjectVO() {
			return projectVO;
		}

		public void setProjectVO(ProjectVO projectVO) {
			this.projectVO = projectVO;
		}

		public ModuleVO getModuleVO() {
			return moduleVO;
		}

		public void setModuleVO(ModuleVO moduleVO) {
			this.moduleVO = moduleVO;
		}

		public List<FieldVO> getFieldList() {
			return fieldList;
		}

		public void setFieldList(List<FieldVO> fieldList) {
			this.fieldList = fieldList;
		}

}
