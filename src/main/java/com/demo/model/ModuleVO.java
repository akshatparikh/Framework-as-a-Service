package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="add_module")
public class ModuleVO {
	
		@Id
		@Column(name="module_Id")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int moduleId;
		
		@Column(name="module_name")
		private String moduleName;
		
		@Column(name="module_description")
		private String moduleDescription;	

		@ManyToOne
		private ProjectVO projectVO;

		@Column
		private Boolean status = true;

		@ManyToOne
		private LoginVO loginVO;
		
		public LoginVO getLoginVO() {
			return loginVO;
		}

		public void setLoginVO(LoginVO loginVO) {
			this.loginVO = loginVO;
		}

		public Boolean getStatus() {
			return status;
		}

		public void setStatus(Boolean status) {
			this.status = status;
		}

		public int getModuleId() {
			return moduleId;
		}

		public void setModuleId(int moduleId) {
			this.moduleId = moduleId;
		}

		public String getModuleName() {
			return moduleName;
		}

		public void setModuleName(String moduleName) {
			this.moduleName = moduleName;
		}

		public String getModuleDescription() {
			return moduleDescription;
		}

		public void setModuleDescription(String moduleDescription) {
			this.moduleDescription = moduleDescription;
		}

		public ProjectVO getProjectVO() {
			return projectVO;
		}

		public void setProjectVO(ProjectVO projectVO) {
			this.projectVO = projectVO;
		}
		
}