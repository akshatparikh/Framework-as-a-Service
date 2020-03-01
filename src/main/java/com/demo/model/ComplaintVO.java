package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="add_complaint")
public class ComplaintVO {
	
	@Id
	@Column(name="complaint_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int complaintId;
	
	@Column(name="complaint_date")
	private String complaintDate;
	
	@Column(name="complaint_title")
	private String complaintTitle;
	
	@Column(name="complaint_description")
	private String complaintDescription;
	
	@Column(name="complaint_reply")
	private String complaintReply;
	
	@Column(name="complaint_reply_date")
	private String complaintReplyDate;

	@Column
	private Boolean status = true;

	@Column
	private String complaintStatus = "PENDING";

	@ManyToOne
	private LoginVO loginVO;
	
	public String getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(String complaintDate) {
		this.complaintDate = complaintDate;
	}

	public String getComplaintReply() {
		return complaintReply;
	}

	public void setComplaintReply(String complaintReply) {
		this.complaintReply = complaintReply;
	}

	public String getComplaintReplyDate() {
		return complaintReplyDate;
	}

	public void setComplaintReplyDate(String complaintReplyDate) {
		this.complaintReplyDate = complaintReplyDate;
	}

	public String getComplaintStatus() {
		return complaintStatus;
	}

	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintTitle() {
		return complaintTitle;
	}

	public void setComplaintTitle(String complaintTitle) {
		this.complaintTitle = complaintTitle;
	}

	public String getComplaintDescription() {
		return complaintDescription;
	}

	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

}
