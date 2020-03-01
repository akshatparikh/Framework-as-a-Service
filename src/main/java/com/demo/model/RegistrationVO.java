package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class RegistrationVO {
				
			@Id
			@Column(name="user_id")
			@GeneratedValue(strategy=GenerationType.AUTO)
			private int userId;
			
			@Column(name="First_Name")
			private String firstName;
			
			@Column(name="Middle_Name")
			private String middleName;
			
			@Column(name="Last_Name")
			private String lastName;
			
			@Column(name="Birth_Date")
			private String birthDate;
			
			@Column(name="Mobile_Number")
			private String mobileNo;	
	
			@Column(name="Occupation")
			private String occupation;	
			
			@Column(name="Address")
			private String address;
			
			@ManyToOne
			private LoginVO loginVO;
			
			public String getOccupation() {
				return occupation;
			}

			public void setOccupation(String occupation) {
				this.occupation = occupation;
			}

			public String getBirthDate() {
				return birthDate;
			}

			public void setBirthDate(String birthDate) {
				this.birthDate = birthDate;
			}

			public int getUserId() {
				return userId;
			}

			public void setUserId(int userId) {
				this.userId = userId;
			}

			public String getFirstName() {
				return firstName;
			}

			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}

			public String getMiddleName() {
				return middleName;
			}

			public void setMiddleName(String middleName) {
				this.middleName = middleName;
			}

			public String getLastName() {
				return lastName;
			}

			public void setLastName(String lastName) {
				this.lastName = lastName;
			}

			public String getMobileNo() {
				return mobileNo;
			}

			public void setMobileNo(String mobileNo) {
				this.mobileNo = mobileNo;
			}

			public String getAddress() {
				return address;
			}

			public void setAddress(String address) {
				this.address = address;
			}

			public LoginVO getLoginVO() {
				return loginVO;
			}

			public void setLoginVO(LoginVO loginVO) {
				this.loginVO = loginVO;
			}
}
	

